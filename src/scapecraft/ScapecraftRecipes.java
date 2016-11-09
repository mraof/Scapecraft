package scapecraft;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import scapecraft.block.ScapecraftBlocks;
import scapecraft.item.ScapecraftItems;
import scapecraft.util.SmeltingRecipe;
import scapecraft.util.SmithingRecipe;

import java.util.ArrayList;
import java.util.Iterator;

public class ScapecraftRecipes
{
	public static void registerRecipes()
	{
		final ArrayList<Class> vanillaEquipmentClasses = new ArrayList<Class>()
		{{
			add(ItemArmor.class);
			add(ItemSword.class);
			add(ItemAxe.class);
			add(ItemPickaxe.class);
			add(ItemHoe.class);
			add(ItemSpade.class);
		}
		};
		for(Iterator it = CraftingManager.getInstance().getRecipeList().iterator(); it.hasNext();)
		{
			IRecipe recipe = (IRecipe)it.next();
			if(recipe.getRecipeOutput() != null && vanillaEquipmentClasses.contains(recipe.getRecipeOutput().getItem().getClass()))
			{
				System.out.println(recipe);
				it.remove();
			}
		}

		SmeltingRecipe.addRecipe(12, 20, 1, ScapecraftItems.bronzeIngot, ScapecraftBlocks.tinOre, ScapecraftBlocks.copperOre);
		SmeltingRecipe.addRecipe(32, 35, 15, Items.IRON_INGOT, Blocks.IRON_ORE);
		SmeltingRecipe.addRecipe(50, 50, 30, ScapecraftItems.steelIngot, Blocks.IRON_ORE, new ItemStack(Items.COAL, 1, 0));
		SmeltingRecipe.addRecipe(68, 65, 45, ScapecraftItems.mithrilIngot, ScapecraftBlocks.mithrilOre, new ItemStack(Items.COAL, 2, 0));
		SmeltingRecipe.addRecipe(88, 80, 60, ScapecraftItems.adamantIngot, ScapecraftBlocks.adamantOre, new ItemStack(Items.COAL, 4, 0));
		SmeltingRecipe.addRecipe(106, 95, 75, ScapecraftItems.runeIngot, ScapecraftBlocks.runeOre, new ItemStack(Items.COAL, 8, 0));

		GameRegistry.addRecipe(new ItemStack(ScapecraftBlocks.blueCobbleCompressed, 1), "XXX", "XXX", "XXX", 'X', ScapecraftBlocks.blueCobble);
		GameRegistry.addRecipe(new ItemStack(ScapecraftItems.boltRack, 3), " X ", " Y ", 'X', ScapecraftBlocks.magicPlank, 'Y', Items.ARROW);
		GameRegistry.addRecipe(new ItemStack(ScapecraftItems.cabbagePieUncooked, 1), " X ", " Y ", 'X', ScapecraftItems.cutCabbage, 'Y', Items.BREAD);
		GameRegistry.addRecipe(new ItemStack(ScapecraftItems.cabbagePieUncooked, 1), " X ", "XYX", 'X', Blocks.LOG, 'Y', Blocks.TORCH);
		GameRegistry.addRecipe(new ItemStack(ScapecraftItems.cutCabbage, 1), "X", 'X', ScapecraftBlocks.cabbage);
		GameRegistry.addRecipe(new ItemStack(ScapecraftItems.fishPieUncooked, 1), " X ", " Y ", 'X', Items.COOKED_FISH, 'Y', Items.BREAD);
		GameRegistry.addRecipe(new ItemStack(ScapecraftItems.greenDLeather, 1), " X ", " Y ", 'X', Items.GOLD_INGOT, 'Y', ScapecraftItems.greenDHide);
		GameRegistry.addRecipe(new ItemStack(ScapecraftBlocks.magicPlank, 2), "X", 'X', ScapecraftBlocks.magicLog);
		GameRegistry.addRecipe(new ItemStack(ScapecraftBlocks.magicSapling, 1), "XXX", "XYX", "XXX", 'Y', Items.DIAMOND, 'X', ScapecraftBlocks.yewSapling);
		GameRegistry.addRecipe(new ItemStack(ScapecraftBlocks.magicStairs, 4), "  X", " XX", "XXX", 'X', ScapecraftBlocks.magicPlank);
		GameRegistry.addRecipe(ScapecraftItems.stick.getStackFromName("magic"), "X", "X", 'X', ScapecraftBlocks.magicPlank);
		GameRegistry.addRecipe(new ItemStack(ScapecraftItems.stoneBoots, 1), "X X", "X X", 'X', ScapecraftBlocks.blueCobbleCompressed);
		GameRegistry.addRecipe(new ItemStack(ScapecraftItems.stonePlatebody, 1), "X X", "XXX", "XXX", 'X', ScapecraftBlocks.blueCobbleCompressed);
		GameRegistry.addRecipe(new ItemStack(ScapecraftItems.stoneHelmet, 1), "XXX", "X X", 'X', ScapecraftBlocks.blueCobbleCompressed);
		GameRegistry.addRecipe(new ItemStack(ScapecraftItems.stonePlatelegs, 1), "XXX", "X X", "X X", 'X', ScapecraftBlocks.blueCobbleCompressed);
		GameRegistry.addRecipe(new ItemStack(ScapecraftBlocks.strongOakPlank, 2), "X", 'X', ScapecraftBlocks.strongOakLog);
		GameRegistry.addRecipe(new ItemStack(ScapecraftBlocks.strongOakStairs, 4), "  X", " XX", "XXX", 'X', ScapecraftBlocks.strongOakPlank);
		GameRegistry.addRecipe(ScapecraftItems.stick.getStackFromName("strongOak"), "X", "X", 'X', ScapecraftBlocks.strongOakPlank);
		GameRegistry.addRecipe(new ItemStack(ScapecraftBlocks.willowPlank, 2), "X", 'X', ScapecraftBlocks.willowLog);
		GameRegistry.addRecipe(new ItemStack(ScapecraftBlocks.willowStairs, 4), "  X", " XX", "XXX", 'X', ScapecraftBlocks.willowPlank);
		GameRegistry.addRecipe(ScapecraftItems.stick.getStackFromName("willow"), "X", "X", 'X', ScapecraftBlocks.willowPlank);
		GameRegistry.addRecipe(new ItemStack(ScapecraftBlocks.maplePlank, 2), "X", 'X', ScapecraftBlocks.mapleLog);
		GameRegistry.addRecipe(new ItemStack(ScapecraftBlocks.mapleStairs, 4), "  X", " XX", "XXX", 'X', ScapecraftBlocks.maplePlank);
		GameRegistry.addRecipe(ScapecraftItems.stick.getStackFromName("maple"), "X", "X", 'X', ScapecraftBlocks.maplePlank);
		GameRegistry.addRecipe(new ItemStack(ScapecraftBlocks.yewPlank, 2), "X", 'X', ScapecraftBlocks.yewLog);
		GameRegistry.addRecipe(new ItemStack(ScapecraftBlocks.yewStairs, 4), "  X", " XX", "XXX", 'X', ScapecraftBlocks.yewPlank);
		GameRegistry.addRecipe(ScapecraftItems.stick.getStackFromName("yew"), "X", "X", 'X', ScapecraftBlocks.yewPlank);
		GameRegistry.addRecipe(new ItemStack(ScapecraftItems.dragonPickaxeg, 1), "Y", "Y", "X", 'X', ScapecraftItems.equipmentSets.get("dragonPickaxe"), 'Y', Items.GOLD_INGOT);
		GameRegistry.addRecipe(new ItemStack(ScapecraftItems.applePieUncooked, 1), " X ", " Y ", 'X', Items.APPLE, 'Y', Items.BREAD);
		GameRegistry.addRecipe(new ItemStack(ScapecraftItems.graniteBoots, 1), "X X", "X X", 'X', ScapecraftItems.graniteLump);
		GameRegistry.addRecipe(new ItemStack(ScapecraftItems.granitePlatebody, 1), "X X", "XXX", "XXX", 'X', ScapecraftItems.graniteLump);
		GameRegistry.addRecipe(new ItemStack(ScapecraftItems.graniteHelmet, 1), "XXX", "X X", 'X', ScapecraftItems.graniteLump);
		GameRegistry.addRecipe(new ItemStack(ScapecraftItems.granitePlatelegs, 1), "XXX", "X X", "X X", 'X', ScapecraftItems.graniteLump);
		GameRegistry.addRecipe(new ItemStack(ScapecraftItems.meatPieUncooked, 1), " X ", " Y ", 'X', Items.COOKED_PORKCHOP, 'Y', Items.BREAD);

		GameRegistry.addRecipe(new ItemStack(ScapecraftItems.bronzeIngot, 9), "X", 'X', ScapecraftBlocks.bronzeBlock);
		GameRegistry.addRecipe(new ItemStack(ScapecraftBlocks.bronzeBlock, 1), "XXX", "XXX", "XXX", 'X', ScapecraftItems.bronzeIngot);
		GameRegistry.addRecipe(new ItemStack(ScapecraftItems.mithrilIngot, 9), "X", 'X', ScapecraftBlocks.mithrilBlock);
		GameRegistry.addRecipe(new ItemStack(ScapecraftBlocks.mithrilBlock, 1), "XXX", "XXX", "XXX", 'X', ScapecraftItems.mithrilIngot);
		GameRegistry.addRecipe(new ItemStack(ScapecraftItems.adamantIngot, 9), "X", 'X', ScapecraftBlocks.adamantBlock);
		GameRegistry.addRecipe(new ItemStack(ScapecraftBlocks.adamantBlock, 1), "XXX", "XXX", "XXX", 'X', ScapecraftItems.adamantIngot);
		GameRegistry.addRecipe(new ItemStack(ScapecraftItems.runeIngot, 9), "X", 'X', ScapecraftBlocks.runeBlock);
		GameRegistry.addRecipe(new ItemStack(ScapecraftBlocks.runeBlock, 1), "XXX", "XXX", "XXX", 'X', ScapecraftItems.runeIngot);

		GameRegistry.addSmelting(ScapecraftItems.applePieUncooked, new ItemStack(ScapecraftItems.applePie), 1.0F);
		GameRegistry.addSmelting(ScapecraftItems.cabbagePieUncooked, new ItemStack(ScapecraftItems.cabbagePie), 1.0F);
		GameRegistry.addSmelting(ScapecraftItems.fishPieUncooked, new ItemStack(ScapecraftItems.fishPie), 1.0F);
		GameRegistry.addSmelting(ScapecraftItems.meatPieUncooked, new ItemStack(ScapecraftItems.meatPie), 1.0F);
	}

	public static void registerSetRecipes(int level, String name, String metal, int smithingLevel)
	{
		int xpPerBar = (int) (12.5 + (level / 10) * 12.5);
		SmithingRecipe.addRecipe(20 + level, smithingLevel, xpPerBar, new ItemStack(ScapecraftItems.equipmentSets.get(name + "Dagger")), metal, 1, 1);
		SmithingRecipe.addRecipe(20 + level, smithingLevel + 1, xpPerBar, new ItemStack(ScapecraftItems.equipmentSets.get(name + "Axe")), metal, 1, 2);
		SmithingRecipe.addRecipe(20 + level, smithingLevel + 2, xpPerBar, new ItemStack(ScapecraftItems.equipmentSets.get(name + "Hoe")), metal, 1, 2);
		SmithingRecipe.addRecipe(20 + level, smithingLevel + 3, xpPerBar, new ItemStack(ScapecraftItems.equipmentSets.get(name + "Helmet")), metal, 1, 0);
		SmithingRecipe.addRecipe(20 + level, smithingLevel + 4, xpPerBar, new ItemStack(ScapecraftItems.equipmentSets.get(name + "Sword")), metal, 1, 1);
		SmithingRecipe.addRecipe(20 + level, smithingLevel + 5, xpPerBar, new ItemStack(ScapecraftItems.equipmentSets.get(name + "Pickaxe")), metal, 2, 2);
		SmithingRecipe.addRecipe(20 + level, smithingLevel + 6, xpPerBar, new ItemStack(ScapecraftItems.equipmentSets.get(name + "Shovel")), metal, 1, 2);
		SmithingRecipe.addRecipe(20 + level, smithingLevel + 7, xpPerBar, new ItemStack(ScapecraftItems.equipmentSets.get(name + "FullHelm")), metal, 2, 0);
		SmithingRecipe.addRecipe(20 + level, smithingLevel + 9, xpPerBar, new ItemStack(ScapecraftItems.equipmentSets.get(name + "Hammer")), metal, 3, 2);
		SmithingRecipe.addRecipe(20 + level, smithingLevel + 9, xpPerBar, new ItemStack(ScapecraftItems.equipmentSets.get(name + "Hammer")), metal, 3, 2);
		SmithingRecipe.addRecipe(20 + level, smithingLevel + 10, xpPerBar, new ItemStack(ScapecraftItems.equipmentSets.get(name + "Boots")), metal, 1, 0);
		SmithingRecipe.addRecipe(20 + level, smithingLevel + 11, xpPerBar, new ItemStack(ScapecraftItems.equipmentSets.get(name + "Chainbody")), metal, 3, 0);
		SmithingRecipe.addRecipe(20 + level, smithingLevel + 16, xpPerBar, new ItemStack(ScapecraftItems.equipmentSets.get(name + "Platelegs")), metal, 3, 0);
		SmithingRecipe.addRecipe(20 + level, smithingLevel + 16, xpPerBar, new ItemStack(ScapecraftItems.equipmentSets.get(name + "Plateskirt")), metal, 3, 0);
		SmithingRecipe.addRecipe(20 + level, smithingLevel + 18, xpPerBar, new ItemStack(ScapecraftItems.equipmentSets.get(name + "Platebody")), metal, 5, 0);
		System.out.println(metal + " " + OreDictionary.getOres(metal));
	}
}
