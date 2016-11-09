package scapecraft.client.gui;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiTextField;

/**
 * Created by mraof on 2016 March 02.
 */
public class GuiNumberField extends GuiTextField
{
    int value = 0;
    int minNum = Integer.MIN_VALUE;

    int maxNum = Integer.MAX_VALUE;
    public GuiNumberField(int componentId, FontRenderer fontRenderer, int xPosition, int yPosition, int width, int height)
    {
        super(componentId, fontRenderer, xPosition, yPosition, width, height);
    }

    public int keyTypedNumber(char character, int key)
    {
        textboxKeyTyped(character, key);
        int oldValue = value;
        try
        {
            if(this.getText().isEmpty())
            {
                this.value = minNum;
                return this.value;
            }
            if("-".equals(this.getText()) && this.minNum < 0)
            {
                this.value = 0;
                return this.value;
            }
            value = Integer.parseInt(this.getText());
            if(value < minNum)
            {
                value = minNum;
            }
            else if(value > maxNum)
            {
                value = maxNum;
            }
        }
        catch (NumberFormatException e)
        {
            value = oldValue;
            e.printStackTrace();
        }
        this.setText(String.valueOf(value));
        return value;
    }

    public void setMin(int minNum)
    {
        this.minNum = minNum;
        if(value < minNum)
        {
            value = minNum;
        }
    }

    public void setMax(int maxNum)
    {
        this.maxNum = maxNum;
        if(value > maxNum)
        {
            value = maxNum;
        }
    }

    public void setValue(int value)
    {
        this.value = value;
        this.setText(Integer.toString(value));
    }
}
