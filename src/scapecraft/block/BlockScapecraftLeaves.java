package scapecraft.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import scapecraft.Scapecraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockScapecraftLeaves extends BlockLeaves
{
	protected IIcon[] icons = new IIcon[2];
	protected Block sapling;
	protected Item fruit = null;
	
	public BlockScapecraftLeaves(Block sapling)
	{
		super();
		this.setCreativeTab(Scapecraft.tabScapecraftBlock);
		this.sapling = sapling;
	}

	public BlockScapecraftLeaves(Block sapling, Item fruit)
	{
		this(sapling);
		this.fruit = fruit;
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		return this.icons[1]; //TODO transparent leaves
	}

	@Override
	public String[] func_150125_e()
	{
		return new String[] {"leaves"};
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		System.out.println(this.getTextureName());
		icons[0] = iconRegister.registerIcon(this.getTextureName());
		icons[1] = iconRegister.registerIcon(this.getTextureName() + "Opaque");
	}

	@Override
        protected void func_150124_c(World world, int x, int y, int z, int metadata, int chance)
	{
		if(world.rand.nextInt(chance) == 0 && fruit != null)
			this.dropBlockAsItem(world, x, y, z, new ItemStack(fruit));
	}

	@Override
	public Item getItemDropped(int meta, Random random, int fortune)
	{
		return Item.getItemFromBlock(sapling);
	}

	@Override
	public int getBlockColor()
	{
		return 0xFFFFFF;
	}

	@Override
	public int getRenderColor(int meta)
	{
		return 0xFFFFFF;
	}

	@Override
	public int colorMultiplier(IBlockAccess worldIn, int x, int y, int z)
	{
		return 0xFFFFFF;
	}
}
