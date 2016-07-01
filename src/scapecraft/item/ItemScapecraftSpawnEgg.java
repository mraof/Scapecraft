package scapecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.Facing;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import scapecraft.Scapecraft;
import scapecraft.entity.EntityScapecraft;
import scapecraft.entity.ScapecraftEntities;

import java.util.ArrayList;
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
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote && itemStack.getMetadata() < ScapecraftEntities.entities.size())
		{
			Block block = world.getBlock(x, y, z);
			x += Facing.offsetsXForSide[side];
			y += Facing.offsetsYForSide[side];
			z += Facing.offsetsZForSide[side];
			double yOffset = (side == 1 && block.getRenderType() == 11) ? 0.5D : 0D;

			EntityScapecraft entity = ScapecraftEntities.spawnScapecraftEntity(ScapecraftEntities.entities.get(itemStack.getMetadata()), world);
			if(entity == null)
			{
				return false;
			}

			entity.setLocationAndAngles(x + 0.5D, y + yOffset, z + 0.5D, 0F, 0F);
			entity.onSpawnWithEgg(null);
			if(itemStack.hasTagCompound() && itemStack.getTagCompound().hasKey("entityName"))
			{
				String name = itemStack.getTagCompound().getString("entityName");
				int index;
				ArrayList<String> args = new ArrayList<String>();
				while((index = name.indexOf(' ')) != -1)
				{
					args.add(name.substring(0, index));
					name = name.substring(index + 1);
				}
				args.add(name);
				entity.onSpawnerSpawn(args);
			}
			world.spawnEntityInWorld(entity);
			entity.playLivingSound();

			if (!player.capabilities.isCreativeMode)
			{
				--itemStack.stackSize;
			}
		}
		return true;
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
			target.attackEntityFrom(new EntityDamageSource("entityPlayer", attacker), (float) ScapecraftEntities.entityObjects.get(stack.getMetadata()).getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue());
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
				 stack.setMetadata(newMeta);
			 }
		 }
		 else
		 {
			 if(!stack.hasTagCompound())
			 {
				 stack.setTagCompound(new NBTTagCompound());
			 }
			 stack.getTagCompound().setString("mob", ScapecraftEntities.entities.get(stack.getMetadata()));
		 }
	}

	public static ItemStack setMob(ItemStack stack, String mobName)
	{
		stack.setMetadata(ScapecraftEntities.entities.indexOf(mobName));
		checkStack(stack);
		return stack;
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack)
	{
		if(stack.getMetadata() < ScapecraftEntities.entityObjects.size())
		{
			return StatCollector.translateToLocalFormatted("item.scapecraftSpawnEgg.name", ScapecraftEntities.entityObjects.get(stack.getMetadata()).getCommandSenderName());
		}
		else
		{
			return stack.toString();
		}
	}
}
