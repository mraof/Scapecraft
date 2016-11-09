package scapecraft.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import scapecraft.Scapecraft;
import scapecraft.client.gui.GuiHandler;
import scapecraft.entity.ScapecraftEntities;
import scapecraft.item.ScapecraftItems;
import scapecraft.network.TileEntityGuiPacket;
import scapecraft.tileentity.TileEntityScapecraftMobSpawner;

import javax.annotation.Nullable;

public class BlockSpawn extends BlockContainer
{
	public BlockSpawn()
	{
		super(Material.ROCK);
		this.setCreativeTab(Scapecraft.tabScapecraftBlock);
		setHardness(200000.0F);
		setResistance(5000.0F);
		this.setUnlocalizedName("scapecraftSpawner");
	}

//TODO provide redstone power when all are spawned

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if(player.capabilities.isCreativeMode && !player.isSneaking())
		{
			if(!world.isRemote)
			{
				if(player.getHeldItem(hand) != null && player.getHeldItem(hand).getItem() == ScapecraftItems.scapecraftSpawnEgg)
				{
					((TileEntityScapecraftMobSpawner) world.getTileEntity(pos)).entityName = ScapecraftEntities.entities.get(player.getHeldItem(hand).getMetadata());
				}
				TileEntityGuiPacket packet = new TileEntityGuiPacket(world.getTileEntity(pos), GuiHandler.GuiId.SPAWNER);
				Scapecraft.network.sendTo(packet, (EntityPlayerMP) player);
			}
			return true;
		}
		return false;
	}

//TODO disguise as the block underneath except in creative

	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return createTileEntity(world, this.getDefaultState());
	}


	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
	{
		TileEntity te = world.getTileEntity(pos);
		if(te == null)
		{
			System.out.printf("Mob spawner at %s in dimension %d is null, this should not happen\n", pos, world.provider.getDimension());
			return null;
		}

		ItemStack stack = new ItemStack(this);
		stack.setTagCompound(new NBTTagCompound());
		te.writeToNBT(stack.getTagCompound());
		return stack;
	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		if(stack.hasTagCompound())
		{
			TileEntity tileEntity = world.getTileEntity(pos);
			tileEntity.readFromNBT(stack.getTagCompound());
			tileEntity.setPos(pos);
		}
	}
}
