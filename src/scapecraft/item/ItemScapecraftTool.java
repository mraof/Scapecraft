package scapecraft.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.StatCollector;
import scapecraft.Scapecraft;
import scapecraft.util.Stat;
import scapecraft.util.Stats;

import java.util.List;
import java.util.Set;

public class ItemScapecraftTool extends ItemTool implements QualityItem
{
	protected float damageVsEntity;
	protected String toolClass;
	public Stat skill;
	protected int level;

	public ItemScapecraftTool(float damageVsEntity, int level, Set<Block> effectiveBlocks)
	{
		super(0, ToolMaterial.EMERALD, effectiveBlocks); //None of these arguments matter, but extending ItemTool is needed for enchantments
		this.damageVsEntity = damageVsEntity;
		this.level = level;
		this.setMaxDurability((level * level / 2 + 50) * 2);
		this.efficiencyOnProperMaterial = 5 + (level / 10f) * (level / 20f);
		this.setCreativeTab(Scapecraft.tabScapecraftTool);
	}

	@Override
	public int getMaxDamage(ItemStack stack)
	{
		int durability = this.getMaxDurability();
		if (stack.getTagCompound() != null && stack.getTagCompound().hasKey("level"))
		{
			durability = (this.getMaxDurability() + (2 * this.level * (stack.getTagCompound().getInteger("level") - this.level)));
			if (durability < this.getMaxDurability() / 2)
			{
				durability = this.getMaxDurability() / 2;
			}
		}
		return durability;
	}

	//Code copied from ItemTool, looks the same but uses variables declared here instead
	@Override
	public int getHarvestLevel(ItemStack stack, String toolClass)
	{
		if (toolClass != null && toolClass.equals(this.toolClass))
		{
			return this.toolMaterial.getHarvestLevel();
		}
		else
		{
			return -1;
		}
	}

	//Code copied from ItemTool, looks the same but uses variables declared here instead
	@Override
	public Set<String> getToolClasses(ItemStack stack)
	{
		return toolClass != null ? ImmutableSet.of(toolClass) : super.getToolClasses(stack);
	}

	@Override
	public String getToolMaterialName()
	{
		return this.toolMaterial.toString();
	}

	@Override
	public boolean getIsRepairable(ItemStack toolStack, ItemStack materialStack)
	{
		return false;
	}

	@Override
	public int getItemEnchantability()
	{
		return this.toolMaterial.getEnchantability();
	}

	/**
	 * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
	 */
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Multimap getAttributeModifiers(ItemStack stack)
	{
		Multimap multimap = HashMultimap.create();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(itemModifierUUID, "Tool modifier", (double)this.damageVsEntity, 0));
		return multimap;
	}

	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addInformation(ItemStack itemStack, EntityPlayer player, List lines, boolean advancedTooltips)
	{
		super.addInformation(itemStack, player, lines, advancedTooltips);
		if(Scapecraft.requireLevels)
		{
			lines.add(StatCollector.translateToLocal("tool.minlevel.combat") + " " + this.level);
			if(ScapecraftItems.toolLevels.get(this) != null)
			{
				lines.add(StatCollector.translateToLocal("tool.minlevel." + toolClass) + " " + ScapecraftItems.toolLevels.get(this));
			}

			if(itemStack.getTagCompound() != null && itemStack.getTagCompound().hasKey("source"))
			{
				lines.add(itemStack.getTagCompound().getString("source"));
			}
			lines.add("Uses remaining: " + (this.getMaxDamage(itemStack) - itemStack.getMetadata()));
		}
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity target)
	{
		return Scapecraft.requireLevels && Stats.getLevel(player, Stat.ATTACK) < this.level && !player.capabilities.isCreativeMode;
	}

	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
	{
		if(entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) entityLiving;
			return Scapecraft.requireLevels && skill != null && ScapecraftItems.toolLevels.containsKey(this) && !player.capabilities.isCreativeMode && Stats.getLevel(player, Stat.ATTACK) < this.level && Stats.getLevel(player, skill) < ScapecraftItems.toolLevels.get(this);
		}
		return false;
	}
}
