package scapecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

import scapecraft.Scapecraft;
import scapecraft.Stats;
import scapecraft.tileentity.TileEntityBlockSpawner;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBlockSpawner extends Block implements ITileEntityProvider
{
	public Block fullBlock;
	int xp;
	public int regenTime;
	public int fullSize = 15;
	public String stat = "mining";

	public BlockBlockSpawner(Block fullBlock, int regenTime, int xp)
	{
		super(fullBlock.getMaterial());
		this.fullBlock = fullBlock;
		this.setUnlocalizedName(fullBlock.getUnlocalizedName().substring(5) + "Spawn");
		this.setCreativeTab(Scapecraft.tabScapecraftBlock);
		this.regenTime = regenTime * 20;
		this.xp = xp;
		this.setHarvestLevel(fullBlock.getHarvestTool(0), fullBlock.getHarvestLevel(0));
	}

	public BlockBlockSpawner(Block fullBlock, int regenTime)
	{
		this(fullBlock, regenTime, 0);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		if(fullBlock.getCollisionBoundingBoxFromPool(world, x, y, z) == null)
			return null;
		float height = ((float) world.getBlockMetadata(x, y, z) + 1F) / 16F;
		return AxisAlignedBB.getBoundingBox(x + this.minX, y + this.minY, z + this.minZ, x + this.maxX, y + height, z + this.maxZ);
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

	public int getRenderType()
	{
		return fullBlock.getRenderType();
	}

	@Override
	public void setBlockBoundsForItemRender()
	{
		setBlockBoundsForDepth(15);
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z)
	{
		this.setBlockBoundsForDepth(blockAccess.getBlockMetadata(x, y, z));
	}

	protected void setBlockBoundsForDepth(int metadata)
	{
		float height = (1 + metadata) / 16.0F;
		if(fullBlock.getBlockBoundsMaxY() < 1.0F)
			height = (float) fullBlock.getBlockBoundsMaxY();
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, height, 1.0F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
		return side == 1 ? true : super.shouldSideBeRendered(blockAccess, x, y, z, side);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta)
	{
		return fullBlock.getIcon(side, 0);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) 
	{
		return createTileEntity(world, metadata);
	}
	@Override
	public TileEntity createTileEntity(World world, int metadata) 
	{
		return new TileEntityBlockSpawner();
	}
	
	@Override
	public boolean hasTileEntity(int metadata)
	{
		return true;
	}

	@Override
	public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z, boolean willHarvest)
	{
		if(player.capabilities.isCreativeMode || willHarvest && (!(world.getTileEntity(x, y, z) instanceof TileEntityBlockSpawner) || ((TileEntityBlockSpawner) world.getTileEntity(x, y, z)).uses == 0))
			return world.setBlockToAir(x, y, z);
		return true;
	}

	@Override
	public boolean canHarvestBlock(EntityPlayer player, int meta)
	{
		return player.capabilities.isCreativeMode || meta == 15 && ForgeHooks.canHarvestBlock(fullBlock, player, meta);
	}

	@Override
	public void harvestBlock(World worldIn, EntityPlayer player, int x, int y, int z, int meta)
	{
		player.addStat(StatList.mineBlockStatArray[getIdFromBlock(this)], 1);
		player.addExhaustion(0.025F);

		harvesters.set(player);
		int i1 = EnchantmentHelper.getFortuneModifier(player);
		fullBlock.dropBlockAsItem(worldIn, x, y, z, meta, i1);
		harvesters.set(null);

		Stats.addXp(player, stat, xp);

		TileEntityBlockSpawner te = (TileEntityBlockSpawner) worldIn.getTileEntity(x, y, z);
		if(te == null)
		{
			System.out.printf("Spawner at %d, %d, %d in dimension %d for %s is null, this should not happen\n", x, y, z, worldIn.provider.dimensionId, this.fullBlock.getUnlocalizedName());
			return;
		}

		te.startTime = 0; //Reset start time
		if(te.uses != 0)
		{
			if(te.uses > 0)
				te.uses--;
			te.growing = true;
			worldIn.setBlockMetadataWithNotify(x, y, z, 0, 3);
		}
	}

	@Override
	public float getBlockHardness(World world, int x, int y, int z)
	{
		return world.getBlockMetadata(x, y, z) < fullSize ? -1F : fullBlock.getBlockHardness(world, x, y, z);
	}

	@Override
	public void onBlockExploded(World world, int x, int y, int z, Explosion explosion)
	{
		//Don't get destroyed, don't do anything
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase placer, ItemStack itemStack)
	{
		int uses = itemStack.getMetadata();
		if(uses == 0)
		{
			if(placer instanceof EntityPlayer && ((EntityPlayer)placer).capabilities.isCreativeMode)
			{
				uses = -1;
			}
			else
			{
				uses = 50;
			}
		}
		((TileEntityBlockSpawner) world.getTileEntity(x, y, z)).uses = uses;
		//System.out.println(((TileEntityBlockSpawner) world.getTileEntity(x, y, z)).uses); 
	}

	public void onFullyGrown(World world, int x, int y, int z)
	{
	}

	public int getRegenTime()
	{
		return regenTime;
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
	{
		TileEntityBlockSpawner te = (TileEntityBlockSpawner) world.getTileEntity(x, y, z);
		if(te == null)
		{
			System.out.printf("Spawner at %d, %d, %d in dimension %d for %s is null, this should not happen\n", x, y, z, world.provider.dimensionId, this.fullBlock.getUnlocalizedName());
			return null;
		}

		return new ItemStack(this, 1, te.uses);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
	}
}
