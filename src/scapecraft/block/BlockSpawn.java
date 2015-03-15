package scapecraft.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import scapecraft.Scapecraft;
import scapecraft.network.MobSpawnerGuiPacket;
import scapecraft.tileentity.TileEntityScapecraftMobSpawner;
import scapecraft.entity.ScapecraftEntities;
import scapecraft.item.ScapecraftItems;

public class BlockSpawn extends BlockContainer
{
	public BlockSpawn()
	{
		super(Material.rock);
		this.setCreativeTab(Scapecraft.tabScapecraftBlock);
		setHardness(200000.0F);
		setResistance(5000.0F);
		this.setTextureName("minecraft:stone");
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
				MobSpawnerGuiPacket packet = new MobSpawnerGuiPacket(world.getTileEntity(x, y, z));
				Scapecraft.network.sendTo(packet, (EntityPlayerMP) player);
			}
			return true;
		}
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return createTileEntity(world, metadata);
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata)
	{
		TileEntityScapecraftMobSpawner tileEntity = new TileEntityScapecraftMobSpawner();
		return tileEntity;
	}
}
