package scapecraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scapecraft.Scapecraft;
import scapecraft.entity.EntityScapecraft;
import scapecraft.entity.ScapecraftEntities;

import java.util.List;

public class ItemScapecraftSpawnEgg extends Item
{
	public ItemScapecraftSpawnEgg()
	{
		this.setUnlocalizedName("scapecraftSpawnEgg");
		this.setCreativeTab(Scapecraft.tabScapecraftMisc);
		this.setHasSubtypes(true);
	}

	@Override
	public EnumActionResult onItemUse(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if (world.isRemote)
		{
			return EnumActionResult.SUCCESS;
		}
		checkStack(itemStack);
		if (!player.canPlayerEdit(pos.offset(facing), facing, itemStack) || itemStack.stackSize == 0)
		{
			return EnumActionResult.FAIL;
		}

		pos = pos.offset(facing);

		EntityScapecraft entity = ScapecraftEntities.spawnScapecraftEntity(ScapecraftEntities.entities.get(itemStack.getMetadata()), world);
		if(entity == null)
		{
			return EnumActionResult.FAIL;
		}

		entity.setLocationAndAngles(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, 0F, 0F);
		entity.onInitialSpawn(world.getDifficultyForLocation(pos), null);

		world.spawnEntityInWorld(entity);
		entity.playLivingSound();

		if (!player.capabilities.isCreativeMode)
		{
			--itemStack.stackSize;
		}
		return EnumActionResult.SUCCESS;
	}

	@SideOnly(Side.CLIENT)
	@Override
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void getSubItems(Item item, CreativeTabs tab, List subItems)
	{
		for(int id = 0; id < ScapecraftEntities.entities.size(); id++)
		{
			subItems.add(new ItemStack(this, 1, id));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		checkStack(par1ItemStack);
		return getUnlocalizedName() + "." + ScapecraftEntities.entities.get(par1ItemStack.getMetadata());
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
	{
		checkStack(stack);
		if(attacker instanceof EntityPlayer && ((EntityPlayer) attacker).capabilities.isCreativeMode)
		{
			target.attackEntityFrom(new EntityDamageSource("entityPlayer", attacker), (float) ScapecraftEntities.entityObjects.get(stack.getMetadata()).getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue());
		}
		return true;
	}

	public static void checkStack(ItemStack stack)
	{
		if(stack.hasTagCompound() && !stack.getTagCompound().getString("mob").isEmpty())
		{
			int newMeta = ScapecraftEntities.entities.indexOf(stack.getTagCompound().getString("mob"));
			if(newMeta != -1)
			{
				stack.setItemDamage(newMeta);
			}
		}
		else
		{
			if(stack.getItemDamage() >= ScapecraftEntities.entities.size())
			{
				stack.stackSize = 0;
				return;
			}
			if(!stack.hasTagCompound())
			{
				stack.setTagCompound(new NBTTagCompound());
			}
			stack.getTagCompound().setString("mob", ScapecraftEntities.entities.get(stack.getMetadata()));
		}
	}

	public static ItemStack setMob(ItemStack stack, String mobName)
	{
		stack.setItemDamage(ScapecraftEntities.entities.indexOf(mobName));
		checkStack(stack);
		return stack;
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack)
	{
		if(stack.getMetadata() < ScapecraftEntities.entityObjects.size())
		{
			return I18n.translateToLocalFormatted("item.scapecraftSpawnEgg.name", ScapecraftEntities.entityObjects.get(stack.getMetadata()).getName());
		}
		else
		{
			return stack.toString();
		}
	}
}
