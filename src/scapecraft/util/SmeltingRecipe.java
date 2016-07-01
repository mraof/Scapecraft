package scapecraft.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import scapecraft.inventory.InventoryScapecraft;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by mraof on 2016 March 02.
 */
public class SmeltingRecipe
{
    private static ArrayList<SmeltingRecipe> recipes = new ArrayList<SmeltingRecipe>();
    private int xp;
    private int time;
    private int level;

    private ItemStack result;
    private ArrayList<ItemStack> ingredients = new ArrayList<ItemStack>();

    public static void addRecipe(int xp, int time, int level, Object result, Object... ingredients)
    {
        recipes.add(new SmeltingRecipe(xp, time, level, result,  ingredients));
    }

    public SmeltingRecipe(int xp, int time, int level, Object result, Object... ingredients)
    {
        this.xp = xp;
        this.time = time;
        this.level = level;
        if(result instanceof Block)
        {
            result = new ItemStack((Block) result);
        }
        else if(result instanceof Item)
        {
            result = new ItemStack((Item) result);
        }
        this.result = (ItemStack) result;

        for(int i = 0; i < ingredients.length; i++)
        {
            if(ingredients[i] instanceof Block)
            {
                ingredients[i] = new ItemStack((Block) ingredients[i]);
            }
            else if(ingredients[i] instanceof Item)
            {
                ingredients[i] = new ItemStack((Item) ingredients[i]);
            }
            this.ingredients.add((ItemStack) ingredients[i]);
        }
    }

    public int getXp()
    {
        return xp;
    }

    public int getTime()
    {
        return time;
    }

    public ItemStack getResult()
    {
        return result;
    }

    public ArrayList<ItemStack> getIngredients()
    {
        return new ArrayList<ItemStack>(ingredients);
    }

    public static SmeltingRecipe getRecipe(InventoryScapecraft inventoryScapecraft)
    {
        ArrayList<ItemStack> inv = new ArrayList<ItemStack>();
        if(inventoryScapecraft.getStackInSlot(0) != null)
        {
            inv.add(inventoryScapecraft.getStackInSlot(0));
        }
        if(inventoryScapecraft.getStackInSlot(1) != null)
        {
            inv.add(inventoryScapecraft.getStackInSlot(1));
        }
        for(SmeltingRecipe recipe : recipes)
        {
            ArrayList<ItemStack> input = new ArrayList<ItemStack>(inv);
            ArrayList<ItemStack> ingredients = recipe.getIngredients();
            if (input.size() != ingredients.size())
            {
                continue;
            }
            Iterator<ItemStack> iterator = ingredients.iterator();
            while (iterator.hasNext())
            {
                ItemStack stack = iterator.next();
                Iterator<ItemStack> invIterator = input.iterator();
                while (invIterator.hasNext())
                {
                    ItemStack inputStack = invIterator.next();
                    if(stack.isItemEqual(inputStack) && stack.stackSize <= inputStack.stackSize && ItemStack.areItemStackTagsEqual(stack, inputStack))
                    {
                        invIterator.remove();
                        iterator.remove();
                        break;
                    }
                }
                if(ingredients.isEmpty())
                {
                    return recipe;
                }
            }
        }
        return null;
    }

    public int getLevel()
    {
        return level;
    }
}
