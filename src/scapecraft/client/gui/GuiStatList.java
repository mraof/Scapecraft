package scapecraft.client.gui;

import scapecraft.util.Stat;
import scapecraft.util.Stats;

/**
 * Created by mraof on 2016 March 02.
 */
public class GuiStatList extends GuiStats
{
    private static final int rowHeight = 20;
    private static final Stat[] stats = {
            Stat.ATTACK,
            Stat.CONSTITUTION,
            Stat.MINING,
            Stat.STRENGTH,
            Stat.AGILITY,
            Stat.SMITHING,
            Stat.DEFENSE,
            Stat.HERBLORE,
            Stat.FISHING,
            Stat.RANGED,
            Stat.THIEVING,
            Stat.COOKING,
            Stat.PRAYER,
            Stat.CRAFTING,
            Stat.FIREMAKING,
            Stat.MAGIC,
            Stat.FLETCHING,
            Stat.WOODCUTTING,
            Stat.RUNECRAFTING,
            Stat.SLAYER,
            Stat.FARMING,
            Stat.CONSTRUCTION,
            Stat.HUNTER,
            Stat.SUMMONING,
            Stat.DUNGEONEERING,
            Stat.DIVINATION,
    };
    private static final int statLimit = 9;
    @Override
    public void initGui()
    {
        super.initGui();
        currentTab = 0;
    }

    @Override
    public void drawScreen(int x, int y, float f)
    {
        super.drawScreen(x, y, f);
        for(int statNum = 0; statNum < stats.length; statNum++)
        {
            Stat stat = stats[statNum];
            if(stat.ordinal() <= statLimit)
            {
                int statX = left + (statNum % 3) * 58 + 4;
                int statY = top + (statNum / 3) * rowHeight + 8;
                this.mc.getTextureManager().bindTexture(statsIcons);
                drawStatIcon(statX, statY, stat.ordinal() + 2);
                String text = Integer.toString(Stats.getLevel(mc.thePlayer, stat));
                this.fontRendererObj.drawStringWithShadow(text, statX + 39 - this.fontRendererObj.getStringWidth(text) / 2, statY, 0xFFFFFF); //
                text = String.format("%.1f%%", ((Stats.getXp(mc.thePlayer, stat) - Stats.getXpForLevel(Stats.getLevel(mc.thePlayer, stat))) / (double) (Stats.getXpForLevel(Stats.getLevel(mc.thePlayer, stat) + 1) - Stats.getXpForLevel(Stats.getLevel(mc.thePlayer, stat)))) * 100);
                this.fontRendererObj.drawStringWithShadow(text, statX + 39 - this.fontRendererObj.getStringWidth(text) / 2, statY + 8, 0xFFFFFF);
            }
        }
        if(x > left + 4 && x < left + 172 && y > top + 8 && y < top + guiHeight && (x - left - 4) % 58 <= 16 && (y - top - 8) % rowHeight <= 16)
        {
            int statNum = (x - left - 4) / 58 + (y - top - 8) / rowHeight * 3;
            if(statNum < stats.length)
            {
                Stat stat = stats[statNum];
                if(stat.ordinal() <= statLimit)
                {
                    String text = stat.toString().charAt(0) + stat.toString().substring(1).toLowerCase() + ": " + Stats.getXp(mc.thePlayer, stat) + "/" + Stats.getXpForLevel(Stats.getLevel(mc.thePlayer, stat) + 1);
                    this.fontRendererObj.drawStringWithShadow(text, x, y - 8, 0xFFFFFF);
                }
            }
        }
    }
}
