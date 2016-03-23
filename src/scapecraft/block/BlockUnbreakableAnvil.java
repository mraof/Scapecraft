package scapecraft.block;

import net.minecraft.block.BlockAnvil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.S2DPacketOpenWindow;
import net.minecraft.world.World;
import scapecraft.Scapecraft;
import scapecraft.inventory.ContainerUnbreakingRepair;

public class BlockUnbreakableAnvil extends BlockAnvil
{
	public BlockUnbreakableAnvil()
	{
		this.setHardness(5.0F);
		this.setStepSound(soundTypeAnvil);
		this.setUnlocalizedName("unbreakableAnvil");
		this.setResistance(2000.0F);
		this.setCreativeTab(Scapecraft.tabScapecraftBlock);
	}

	@Override
	public boolean onBlockActivated(World worldIn, int x, int y, int z, EntityPlayer player, int side, float subX, float subY, float subZ)
	{
		if (worldIn.isRemote)
		{
			return true;
		}
		else
		{
			EntityPlayerMP playerMP = (EntityPlayerMP) player;
			playerMP.getNextWindowId();
			playerMP.playerNetServerHandler.sendPacket(new S2DPacketOpenWindow(playerMP.currentWindowId, 8, "Repairing", 9, true));
			playerMP.openContainer = new ContainerUnbreakingRepair(playerMP.inventory, playerMP.worldObj, x, y, z, playerMP);
			playerMP.openContainer.windowId = playerMP.currentWindowId;
			playerMP.openContainer.onCraftGuiOpened(playerMP);
			return true;
		}
	}
}
