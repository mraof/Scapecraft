package scapecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import scapecraft.Scapecraft;
import scapecraft.client.gui.GuiHandler;
import scapecraft.entity.ScapecraftEntities;
import scapecraft.item.ScapecraftItems;
import scapecraft.network.TileEntityGuiPacket;
import scapecraft.tileentity.TileEntityScapecraftMobSpawner;

public class BlockSpawn extends BlockContainer
{
	public BlockSpawn()
	{
		super(Material.rock);
		this.setCreativeTab(Scapecraft.tabScapecraftBlock);
		setHardness(200000.0F);
		setResistance(5000.0F);
		this.setTextureName("minecraft:portal");
		this.setUnlocalizedName("scapecraftSpawner");
	}

	@Override
	public boolean canProvidePower()
	{
		return true;
	}

	@Override
	public int isProvidingWeakPower(IBlockAccess world, int x, int y, int z, int side)
	{
		return world.getBlockMetadata(x, y, z) * 15;
	}

	@Override
	public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int side)
	{
		return world.getBlockMetadata(x, y, z) * 15;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float subX, float subY, float subZ)
	{
		if(player.capabilities.isCreativeMode && !player.isSneaking())
		{
			if(!world.isRemote)
			{
				if(player.getHeldItem() != null && player.getHeldItem().getItem() == ScapecraftItems.scapecraftSpawnEgg)
				{
					((TileEntityScapecraftMobSpawner) world.getTileEntity(x, y, z)).entityName = ScapecraftEntities.entities.get(player.getHeldItem().getMetadata());
				}
				TileEntityGuiPacket packet = new TileEntityGuiPacket(world.getTileEntity(x, y, z), GuiHandler.GuiId.SPAWNER);
				Scapecraft.network.sendTo(packet, (EntityPlayerMP) player);
			}
			return true;
		}
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess worldIn, int x, int y, int z, int side)
	{
		if(Minecraft.getMinecraft().thePlayer.capabilities.isCreativeMode || y == 0)
		{
			return this.blockIcon;
		}
		return worldIn.getBlock(x, y - 1, z).getIcon(worldIn, x, y - 1, z, side);
	}

	@Override
	public int colorMultiplier(IBlockAccess world, int x, int y, int z)
	{
		if(y > 0)
		{
			return world.getBlock(x, y - 1, z).colorMultiplier(world, x, y - 1, z);
		}
		return getRenderColor(world.getBlockMetadata(x, y, z));
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return createTileEntity(world, metadata);
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata)
	{
		return new TileEntityScapecraftMobSpawner();
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player)
	{
		TileEntity te = world.getTileEntity(x, y, z);
		if(te == null)
		{
			System.out.printf("Mob spawner at %d, %d, %d in dimension %d is null, this should not happen\n", x, y, z, world.provider.dimensionId);
			return null;
		}

		ItemStack stack = new ItemStack(this);
		stack.setTagCompound(new NBTTagCompound());
		te.writeToNBT(stack.getTagCompound());
		return stack;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase placer, ItemStack stack)
	{
		if(stack.hasTagCompound())
		{
			TileEntity tileEntity = world.getTileEntity(x, y, z);
			tileEntity.readFromNBT(stack.getTagCompound());
			tileEntity.xCoord = x;
			tileEntity.yCoord = y;
			tileEntity.zCoord = z;
		}
	}
}
