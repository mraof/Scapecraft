package scapecraft.client.gui.swing;

import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;
import scapecraft.Scapecraft;
import scapecraft.network.NewDataPacket;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by mraof on 2016 March 02.
 */
public class FileUploadWindow extends JDialog
{
    public FileUploadWindow() throws HeadlessException
    {
        super();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        ScrollPane pane = new ScrollPane();
        pane.setPreferredSize(new Dimension(320, 240));
        final JTable jTable = new JTable();
        jTable.setModel(new FileTableModel());
        jTable.setFillsViewportHeight(true);
        pane.add(jTable);
        panel.add(pane);
        JPanel buttonPanel = new JPanel(new GridLayout());
        buttonPanel.add(new JButton(new AbstractAction("Add file")
        {
            final JFileChooser fc = new JFileChooser();
            @Override
            public void actionPerformed(ActionEvent e)
            {
                fc.setMultiSelectionEnabled(true);
                if(fc.showOpenDialog(FileUploadWindow.this) == JFileChooser.APPROVE_OPTION)
                {
                    System.out.println(Arrays.toString(fc.getSelectedFiles()));
                    for(File file : fc.getSelectedFiles())
                    {
                        int row = jTable.getRowCount();
                        jTable.setValueAt(file, row, 0);
                        jTable.setValueAt("", row, 1);
                    }
                }
            }
        }));
        buttonPanel.add(new JButton(new AbstractAction("Send files")
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                HashMap<String, byte[]> files = new HashMap<String, byte[]>();
                for(int i = 0; i < jTable.getRowCount(); i++)
                {
                    if(jTable.getValueAt(i, 0) instanceof File && !((String) jTable.getValueAt(i, 1)).isEmpty())
                    {
                        File file = (File) jTable.getValueAt(i, 0);
                        String name = new ResourceLocation((String) jTable.getValueAt(i, 1)).toString();
                        if (file.exists())
                        {
                            try
                            {
                                byte[] data = IOUtils.toByteArray(new FileInputStream(file));
                                files.put(name, data);
                            } catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                if(!files.isEmpty())
                {
                    Scapecraft.network.sendToServer(new NewDataPacket(files));
                    FileUploadWindow.this.setVisible(false);
                }
            }
        }));
        panel.add(buttonPanel);
        panel.setSize(320, 320);
        this.add(panel);
    }

    public static void main(String[] args)
    {
        /*int x = Display.getX();
        int y = Display.getY();*/
        int x = 320;
        int y = 320;
        FileUploadWindow uploadWindow = new FileUploadWindow();
        uploadWindow.setBounds(x, y, 320, 320);
        uploadWindow.pack();
        uploadWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        uploadWindow.setVisible(true);
    }

    static class FileTableModel extends AbstractTableModel
    {
        private ArrayList<Object[]> tablePairs = new ArrayList<Object[]>();

        /**
         * Returns false.  This is the default implementation for all cells.
         *
         * @param rowIndex    the row being queried
         * @param columnIndex the column being queried
         * @return false
         */
        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex)
        {
            return columnIndex == 1;
        }

        @Override
        public int getRowCount()
        {
            return tablePairs.size();
        }

        @Override
        public int getColumnCount()
        {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex)
        {
            return tablePairs.get(rowIndex)[columnIndex];
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex)
        {
            if (tablePairs.size() == rowIndex)
            {
                tablePairs.add(new Object[2]);
            }

            tablePairs.get(rowIndex)[columnIndex] = aValue;
        }
    }
}
