package scapecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import scapecraft.Scapecraft;
import scapecraft.network.XpSplitPacket;
import scapecraft.util.Stat;
import scapecraft.util.Stats;

import java.io.IOException;

/**
 * Created by mraof on 2016 March 02.
 */
public class GuiXpSplit extends GuiStats
{
    private int meleeConstitution = 120;
    private GuiNumberField attackField;
    private GuiNumberField strengthField;
    private GuiNumberField meleeDefenseField;
    private int rangedConstitution = 120;
    private GuiNumberField rangedField;
    private GuiNumberField rangedDefenseField;
    private int magicConstitution = 120;
    private GuiNumberField magicField;
    private GuiNumberField magicDefenseField;

    @Override
    public void initGui()
    {
        super.initGui();
        currentTab = 1;
        attackField = new GuiNumberField(0, this.fontRendererObj, left + 44, top + 30, 34, 20);
        strengthField = new GuiNumberField(1, this.fontRendererObj, left + 84, top + 30, 34, 20);
        meleeDefenseField = new GuiNumberField(2, this.fontRendererObj, left + 124, top + 30, 34, 20);

        rangedField = new GuiNumberField(3, this.fontRendererObj, left + 44, top + 85, 34, 20);
        rangedDefenseField = new GuiNumberField(4, this.fontRendererObj, left + 84, top + 85, 34, 20);
        magicField = new GuiNumberField(5, this.fontRendererObj, left + 44, top + 140, 34, 20);
        magicDefenseField = new GuiNumberField(6, this.fontRendererObj, left + 84, top + 140, 34, 20);
        attackField.setMin(0);
        strengthField.setMin(0);
        meleeDefenseField.setMin(0);
        rangedField.setMin(0);
        rangedDefenseField.setMin(0);
        magicField.setMin(0);
        magicDefenseField.setMin(0);

        attackField.setMaxStringLength(3);
        strengthField.setMaxStringLength(3);
        meleeDefenseField.setMaxStringLength(3);
        rangedField.setMaxStringLength(3);
        rangedDefenseField.setMaxStringLength(3);
        magicField.setMaxStringLength(3);
        magicDefenseField.setMaxStringLength(3);

        meleeConstitution = Stats.getCombatSplit(mc.thePlayer, Stat.ATTACK, Stat.CONSTITUTION);
        attackField.setValue(Stats.getCombatSplit(mc.thePlayer, Stat.ATTACK, Stat.ATTACK));
        strengthField.setValue(Stats.getCombatSplit(mc.thePlayer, Stat.ATTACK, Stat.STRENGTH));
        meleeDefenseField.setValue(Stats.getCombatSplit(mc.thePlayer, Stat.ATTACK, Stat.DEFENSE));

        rangedConstitution = Stats.getCombatSplit(mc.thePlayer, Stat.RANGED, Stat.CONSTITUTION);
        rangedField.setValue(Stats.getCombatSplit(mc.thePlayer, Stat.RANGED, Stat.RANGED));
        rangedDefenseField.setValue(Stats.getCombatSplit(mc.thePlayer, Stat.RANGED, Stat.DEFENSE));

        magicConstitution = Stats.getCombatSplit(mc.thePlayer, Stat.MAGIC, Stat.CONSTITUTION);
        magicField.setValue(Stats.getCombatSplit(mc.thePlayer, Stat.MAGIC, Stat.MAGIC));
        magicDefenseField.setValue(Stats.getCombatSplit(mc.thePlayer, Stat.MAGIC, Stat.DEFENSE));
    }

    @Override
    public void drawScreen(int x, int y, float f)
    {
        super.drawScreen(x, y, f);
        fontRendererObj.drawString(String.valueOf(meleeConstitution), left + 14, top + 35, 0x404040);
        attackField.drawTextBox();
        strengthField.drawTextBox();
        meleeDefenseField.drawTextBox();

        fontRendererObj.drawString(String.valueOf(rangedConstitution), left + 14, top + 90, 0x404040);
        rangedField.drawTextBox();
        rangedDefenseField.drawTextBox();

        fontRendererObj.drawString(String.valueOf(magicConstitution), left + 14, top + 145, 0x404040);
        magicField.drawTextBox();
        magicDefenseField.drawTextBox();

        this.mc.getTextureManager().bindTexture(statsIcons);

        drawStatIcon(left + 14, top + 10, 8);
        drawStatIcon(left + 54, top + 10, 5);
        drawStatIcon(left + 94, top + 10, 6);
        drawStatIcon(left + 134, top + 10, 7);

        drawStatIcon(left + 14, top + 65, 8);
        drawStatIcon(left + 54, top + 65, 9);
        drawStatIcon(left + 94, top + 65, 7);

        drawStatIcon(left + 14, top + 120, 8);
        drawStatIcon(left + 54, top + 120, 10);
        drawStatIcon(left + 94, top + 120, 7);
    }
    @Override
    public void keyTyped(char character, int key) throws IOException {
        super.keyTyped(character, key);
        meleeConstitution = 120;
        attackField.setMax(meleeConstitution);
        meleeConstitution -= attackField.keyTypedNumber(character, key);
        strengthField.setMax(meleeConstitution);
        meleeConstitution -= strengthField.keyTypedNumber(character, key);
        meleeDefenseField.setMax(meleeConstitution);
        meleeConstitution -= meleeDefenseField.keyTypedNumber(character, key);

        rangedConstitution = 120;
        rangedField.setMax(rangedConstitution);
        rangedConstitution -= rangedField.keyTypedNumber(character, key);
        rangedDefenseField.setMax(rangedConstitution);
        rangedConstitution -= rangedDefenseField.keyTypedNumber(character, key);

        magicConstitution = 120;
        magicField.setMax(magicConstitution);
        magicConstitution -= magicField.keyTypedNumber(character, key);
        magicDefenseField.setMax(magicConstitution);
        magicConstitution -= magicDefenseField.keyTypedNumber(character, key);
    }

    @Override
    protected void mouseClicked(int x, int y, int button) throws IOException {
        super.mouseClicked(x, y, button);
        attackField.mouseClicked(x, y, button);
        strengthField.mouseClicked(x, y, button);
        meleeDefenseField.mouseClicked(x, y, button);

        rangedField.mouseClicked(x, y, button);
        rangedDefenseField.mouseClicked(x, y, button);

        magicField.mouseClicked(x, y, button);
        magicDefenseField.mouseClicked(x, y, button);
    }

    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat events
     */
    @Override
    public void onGuiClosed()
    {
        super.onGuiClosed();
        IMessage packet = new XpSplitPacket(attackField.value, strengthField.value, meleeDefenseField.value, rangedField.value, rangedDefenseField.value, magicField.value, magicDefenseField.value);
        Scapecraft.network.sendToServer(packet);
        int meleeConstitution = 120 - attackField.value - meleeDefenseField.value - strengthField.value;
        int rangedConstitution = 120 - rangedField.value - rangedDefenseField.value;
        int magicConstitution = 120 - magicField.value - magicDefenseField.value;
        if(meleeConstitution >= 0 && rangedConstitution >= 0 && magicConstitution >= 0)
        {
            Stats.setCombatSplit(Minecraft.getMinecraft().thePlayer, meleeConstitution, attackField.value, strengthField.value, meleeDefenseField.value, rangedConstitution, rangedField.value, rangedDefenseField.value, magicConstitution, magicField.value, magicDefenseField.value);
        }
    }
}
