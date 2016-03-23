package scapecraft.block;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import scapecraft.tileentity.TileEntityDungeonDoor;
import scapecraft.world.gen.dungeon.Dungeon;

public class BlockDungeonDoor extends BlockScapecraft implements ITileEntityProvider
{
	public BlockDungeonDoor()
	{
		super(Material.glass);
		this.setBlockUnbreakable();
		this.setUnlocalizedName("dungeonDoor");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return createTileEntity(world, metadata);
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata)
	{
		if(metadata == 0)
		{
			return new TileEntityDungeonDoor();
		}
		else
		{
			return null;
		}
	}

	@Override
	public boolean hasTileEntity(int metadata)
	{
		return true;
	}

	@Override
	public void onBlockExploded(World world, int x, int y, int z, Explosion explosion)
	{
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase placer, ItemStack itemStack)
	{
		if(itemStack.getMetadata() != 0)
		{
			world.setBlock(x, y, z, this, 1, 3);
		}
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float subX, float subY, float subZ)
	{
		if(!world.isRemote)
		{
			System.out.println(side);
			switch(side)
			{
				case 2:
					z += 12;
					break;
				case 3:
					z -= 12;
					break;
				case 4:
					x += 12;
					break;
				case 5:
					x -= 12;
					break;
			}
			for(Dungeon dungeon : Dungeon.dungeons)
			{
				System.out.printf("%d %d %d, %d %d %d\n", dungeon.minX, x, dungeon.maxX, dungeon.minZ, z, dungeon.maxZ);
				if(x >= dungeon.minX && x <= dungeon.maxX && z >= dungeon.minZ && z <= dungeon.maxZ)
				{
					dungeon.generateRoom(x, z);
					break;
				}
			}
			long nanotime = System.nanoTime();
			nanotime = System.nanoTime() - nanotime;
			System.out.println(nanotime);
		}
		return true;
	}
}
