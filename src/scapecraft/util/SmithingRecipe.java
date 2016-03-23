package scapecraft.util;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import scapecraft.inventory.InventoryScapecraft;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mraof on 2016 March 02.
 */
public class SmithingRecipe
{
    private final int time;
    private final int level;
    private final int xp;
    private ItemStack result;
    private final int ingotNum;
    private final int stickNum;
    private static HashMap<String, ArrayList<SmithingRecipe>> recipes = new HashMap<String, ArrayList<SmithingRecipe>>();

    public static void addRecipe(int time, int level, int xpPerBar, ItemStack result, String ingot, int ingotNum, int stickNum)
    {
        ArrayList<SmithingRecipe> recipeList = recipes.get(ingot);
        if(recipeList == null)
        {
            recipeList = new ArrayList<SmithingRecipe>();
            recipes.put(ingot, recipeList);
        }
        recipeList.add(new SmithingRecipe(time * ingotNum, level, xpPerBar * ingotNum, result, ingotNum, stickNum));
    }
    public SmithingRecipe(int time, int level, int xp, ItemStack result, int ingotNum, int stickNum)
    {
        super();
        this.time = time;
        this.level = level;
        this.result = result;
        this.ingotNum = ingotNum;
        this.stickNum = stickNum;
        this.xp = xp;
    }

    public int getTime()
    {
        return time;
    }

    public ItemStack getResult()
    {
        return result;
    }

    public int getXp()
    {
        return xp;
    }

    public static ArrayList<SmithingRecipe> getRecipes(InventoryScapecraft inventoryScapecraft, int level)
    {
        String ingot = "";
        for(int ingotID : OreDictionary.getOreIDs(inventoryScapecraft.getStackInSlot(0)))
        {
            String currentIngot = OreDictionary.getOreName(ingotID);
            if(recipes.containsKey(currentIngot))
            {
                ingot = currentIngot;
                break;
            }
        }
        if(ingot.isEmpty())
        {
            return null;
        }

        int ingotNum = inventoryScapecraft.getStackInSlot(0).stackSize;
        int stickNum = 0;
        for(int id : OreDictionary.getOreIDs(inventoryScapecraft.getStackInSlot(1)))
        {
            if("stickWood".equals(OreDictionary.getOreName(id)))
            {
                stickNum = inventoryScapecraft.getStackInSlot(1).stackSize;
                break;
            }
        }

        ArrayList<SmithingRecipe> smithingRecipes = new ArrayList<SmithingRecipe>();
        for(SmithingRecipe recipe : recipes.get(ingot))
        {
            if(recipe.level <= level && recipe.ingotNum <= ingotNum && recipe.stickNum <= stickNum)
            {
                smithingRecipes.add(recipe);
            }
        }

        return smithingRecipes;
    }

    public int getIngotNum()
    {
        return ingotNum;
    }

    public int getStickNum()
    {
        return stickNum;
    }
}
