package scapecraft.item;

import java.util.List;
import java.util.Set;

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
import scapecraft.Stats;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemScapecraftTool extends ItemTool
{
	protected ScapecraftToolMaterial toolMaterial;
	protected float damageVsEntity;
	protected String toolClass;

	public ItemScapecraftTool(float damageVsEntity, ScapecraftToolMaterial toolMaterial, Set<Block> effectiveBlocks)
	{
		super(0, ToolMaterial.GOLD, effectiveBlocks); //None of these arguments matter, but extending ItemTool is needed for enchantments
		this.setMaxDurability(toolMaterial.getMaxUses());
		this.efficiencyOnProperMaterial = toolMaterial.getEfficiencyOnProperMaterial();
		this.damageVsEntity = damageVsEntity + toolMaterial.getDamageVsEntity();
		this.setCreativeTab(Scapecraft.tabScapecraftTool);
		this.toolMaterial = toolMaterial;
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

	public ScapecraftToolMaterial getScapecraftToolMaterial()
	{
		return toolMaterial;
	}

	@Override
	public String getToolMaterialName()
	{
		return this.toolMaterial.toString();
	}

	@Override
	public boolean getIsRepairable(ItemStack toolStack, ItemStack materialStack)
	{
		return this.toolMaterial.getBaseItemForRepair() == materialStack.getItem();
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
			lines.add(StatCollector.translateToLocal("tool.minlevel.combat") + " " + toolMaterial.getMinLevel());
			if(ScapecraftItems.toolLevels.get(this) != null)
			{
				lines.add(StatCollector.translateToLocal("tool.minlevel." + toolClass) + " " + ScapecraftItems.toolLevels.get(this));
			}
		}
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity target)
	{
		if(Scapecraft.requireLevels && Stats.getCombatLevel(player) < this.toolMaterial.getMinLevel() && !player.capabilities.isCreativeMode)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
	{
		if(entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) entityLiving;
			return Scapecraft.requireLevels && ScapecraftItems.toolLevels.containsKey(this) && !player.capabilities.isCreativeMode && Stats.getCombatLevel(player) < this.toolMaterial.getMinLevel() && Stats.getMiningLevel(player) < ScapecraftItems.toolLevels.get(this);
		}
		return false;
	}
}
