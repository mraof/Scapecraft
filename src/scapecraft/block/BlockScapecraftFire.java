package scapecraft.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import scapecraft.Scapecraft;
import scapecraft.tileentity.TileEntityFire;

import java.util.Random;



public class BlockScapecraftFire extends BlockContainer
{
	public BlockScapecraftFire()
	{
		super(Material.rock);
		this.setCreativeTab(Scapecraft.tabScapecraftBlock);
		this.setBlockBounds(0.4F, 0.0F, 0.4F, 0.6F, 0.5F, 0.6F);
		this.setTextureName("scapecraft:Fire");
		this.setUnlocalizedName("scapecraftFire");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntityFire();
	}


	@Override
	public int getRenderType()
	{
		return -1;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	@Override
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{


		float f = (float)par2 + 0.5F;
		float f1 = (float)par3 + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
		float f2 = (float)par4 + 0.5F;
		float f3 = 0.52F;
		float f4 = par5Random.nextFloat() * 0.6F - 0.3F;


		par1World.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
		par1World.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
		par1World.spawnParticle("smoke", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
		par1World.spawnParticle("flame", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
		par1World.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
		par1World.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);              
		par1World.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
		par1World.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
	}

	@Override
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		par5Entity.motionY = 0.55D;
		par5Entity.motionZ = 0.4D;
	}
}
