package scapecraft.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import scapecraft.compat.Compat;

import java.util.ArrayList;

/**
 * Created by mraof on 2016 March 02.
 */
public class WorldProtectionHandler
{
    private static WorldProtectionHandler instance;

    public static WorldProtectionHandler getInstance()
    {
        return instance;
    }

    public WorldProtectionHandler()
    {
        instance = this;
    }

    private ArrayList<Region> regions = new ArrayList<Region>();

    @SubscribeEvent
    public void onPlayerBreakSpeed(PlayerEvent.BreakSpeed event)
    {
        if(event.block instanceof IRegionBlock)
        {
            ((IRegionBlock) event.block).onPlayerBreakBlock(event);
        }
        else
        {
            Region region = getRegion(event.entity.dimension, event.x, event.y, event.z);
            if (region != null && !region.isEditable())
            {
                event.newSpeed = -1;
            }
        }
    }


    @SubscribeEvent
    public void onPlayerDrop(PlayerDropsEvent event)
    {
        Region region = getRegion(event.entityPlayer.dimension, (int) event.entityPlayer.posX, (int) event.entityPlayer.posY, (int) event.entityPlayer.posZ);
        if(region != null && region.getKeepInventorySize() > 0)
        {
            for(int i = 0; i < region.getKeepInventorySize() && i < event.drops.size(); i++)
            {
                event.entityPlayer.inventory.addItemStackToInventory(event.drops.get(i).getEntityItem());
            }
        }
    }

    @SubscribeEvent
    public void onBucketFill(FillBucketEvent event)
    {
        Region region = getRegion(event.entity.dimension, event.target.blockX, event.target.blockY, event.target.blockZ);
        if (region != null && !region.isEditable())
        {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onItemFrameAttack(ItemFrameEvent.Attack event)
    {
        Region region = getRegion(event.world.provider.dimensionId, event.x, event.y, event.z);
        if((region != null) && !region.isEditable() && !(event.source.getEntity() instanceof EntityPlayer && ((EntityPlayer) event.source.getEntity()).capabilities.isCreativeMode))
        {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onPlayerBreakBlock(BlockEvent.BreakEvent event)
    {
        Region region = getRegion(event.getPlayer().dimension, event.x, event.y, event.z);
        if(!(event.getPlayer().worldObj.getBlock(event.x, event.y, event.z) instanceof IRegionBlock) && (region != null) && !region.isEditable() && !event.getPlayer().capabilities.isCreativeMode)
        {
            event.setCanceled(true);
        }
    }
    @SubscribeEvent
    public void onPlayerPlaceBlock(BlockEvent.PlaceEvent event)
    {
        Region region = getRegion(event.player.dimension, event.x, event.y, event.z);
        if(region != null && !region.isEditable() && !event.player.capabilities.isCreativeMode)
        {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onItemFramePlace(ItemFrameEvent.Place event)
    {
        Region region = getRegion(event.entityPlayer.dimension, event.x, event.y, event.z);
        if(region != null && !region.isEditable() && !event.entityPlayer.capabilities.isCreativeMode)
        {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onItemFrameInteract(ItemFrameEvent.Interact event)
    {
        Region region = getRegion(event.entityPlayer.dimension, event.x, event.y, event.z);
        if(region != null && !region.isEditable() && !event.entityPlayer.capabilities.isCreativeMode)
        {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onLivingAttack(LivingAttackEvent event)
    {
        Region targetRegion = getRegion(event.entity.dimension, (int) event.entity.posX, (int) event.entity.posY, (int) event.entity.posZ);
        Region sourceRegion = (event.source.getEntity() == null) ? null : getRegion(event.source.getEntity().dimension, (int) event.source.getEntity().posX, (int) event.source.getEntity().posY, (int) event.source.getEntity().posZ);
        if(event.source.getEntity() instanceof EntityPlayer && event.entity instanceof EntityPlayer)
        {
            if(!(((targetRegion == null) || targetRegion.pvp) && ((sourceRegion == null) || sourceRegion.pvp)))
            {
                event.setCanceled(true);
            }
        }
        else if((event.source.getEntity() instanceof EntityPlayer) != (event.entity instanceof EntityPlayer))
        {
            if(!(((targetRegion == null) || targetRegion.pve) && ((sourceRegion == null) || sourceRegion.pve)))
            {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public void onLivingUpdateEvent(LivingUpdateEvent event)
    {
        if ((event.entityLiving instanceof EntityPlayer) && !event.entityLiving.worldObj.isRemote && ((MinecraftServer.getServer().getTickCounter() % 10) == 0) && !((EntityPlayer) event.entityLiving).capabilities.isCreativeMode)
        {
            Region region = getRegion(event.entityLiving.dimension, (int) event.entityLiving.posX, (int) event.entityLiving.posY, (int) event.entityLiving.posZ);
            if (region.isNoEntry())
            {
                event.entityLiving.attackEntityFrom(DamageSource.outOfWorld, event.entityLiving.getMaxHealth() / 10);
                ((EntityPlayer) event.entityLiving).addChatMessage(new ChatComponentText("§4You are not allowed here, return or die"));
            }
            if(Compat.dynmap)
            {
                scapecraft.compat.dynmap.DynmapHandler.api.assertPlayerInvisibility(event.entityLiving.getCommandSenderName(), region.getPvp(), "Scapecraft");
            }
        }
    }

    public Region getRegion(int dimension, int x, int y, int z)
    {
        Region region = getRegionByName("default");
        int tier = -1;
        for (Region currentRegion : regions)
        {
            int currentTier = currentRegion.regionTier(dimension, x, y, z);
            if (currentTier > tier)
            {
                region = currentRegion;
                tier = currentTier;
            }
        }
        return region;
    }

    public Region getRegionByName(String name)
    {
        for(Region region : regions)
        {
            if(region.getName().equalsIgnoreCase(name))
            {
                return region;
            }
        }
        return null;
    }

    public void addRegion(String name)
    {
        regions.add(new Region(name));
    }

    public void deleteRegion(String name)
    {
        for(int i = 0; i < regions.size(); i++)
        {
            if(regions.get(i).getName().equalsIgnoreCase(name))
            {
                regions.remove(i);
                return;
            }
        }
    }

    public ArrayList<Region> getRegions()
    {
        return regions;
    }

    public static class Region
    {
        private boolean pvp = true; //Allow players to damage each other
        private boolean pve = true; //Allow mobs and players to fight
        private boolean editable = true; //Editable outside of creative mode by ops
        private boolean noEntry = false; //Only enterable by ops
        private int keepInventorySize = 0; //Keep certain number of items in inventory
        public ArrayList<int[]> areas; //Areas, dimension, xMin, xMax, yMin, yMax, zMin, zMax, tier
        private String name;

        public Region(String name)
        {
            this.areas = new ArrayList<int[]>();
            this.name = name;
        }

        public int regionTier(int dimension, int x, int y, int z)
        {
            int tier = -1;
            for(int[] area : areas)
            {
                if(area[0] == dimension && area[1] <= x && area[2] >= x && area[3] <= y && area[4] >= y && area[5] <= z && area[6] >= z && area[7] > tier)
                {
                    tier = area[7];
                }
            }
            return tier;
        }

        public boolean isEditable()
        {
            return editable;
        }

        public void setEditable(boolean editable)
        {
            this.editable = editable;
        }

        public boolean isNoEntry()
        {
            return noEntry;
        }

        public void setNoEntry(boolean noEntry)
        {
            this.noEntry = noEntry;
        }

        public void addArea(int dimension, int xMin, int xMax, int yMin, int yMax, int zMin, int zMax, int tier)
        {
            areas.add(new int[]{dimension, xMin, xMax, yMin, yMax, zMin, zMax, tier});
        }

        public ArrayList<int[]> getAreas()
        {
            return areas;
        }
        public void writeToNBT(NBTTagCompound tagCompound)
        {
            tagCompound.setBoolean("pvp", pvp);
            tagCompound.setBoolean("pve", pve);
            tagCompound.setBoolean("editable", editable);
            tagCompound.setInteger("keepInventorySize", keepInventorySize);
            tagCompound.setString("name", name);
            NBTTagList areaList = new NBTTagList();
            for(int[] area : areas)
            {
                NBTTagIntArray areaNBT = new NBTTagIntArray(area);
                areaList.appendTag(areaNBT);
            }
            tagCompound.setTag("areas", areaList);
        }

        public Region(NBTTagCompound tagCompound)
        {
            this.pvp = tagCompound.getBoolean("pvp");
            this.pve = tagCompound.getBoolean("pve");
            this.editable = tagCompound.getBoolean("editable");
            this.keepInventorySize = tagCompound.getInteger("keepInventorySize");
            this.areas = new ArrayList<int[]>();
            this.name = tagCompound.getString("name");
            if(this.name.isEmpty())
            {
                this.name = "ERR_" + WorldProtectionHandler.getInstance().regions.size();
            }
            NBTTagList areaList = tagCompound.getTagList("areas", 11);
            for(int i = 0; i < areaList.tagCount(); i++)
            {
                areas.add(areaList.getIntArrayAt(i));
            }
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public boolean getPve()
        {
            return pve;
        }

        public void setPve(boolean pve)
        {
            this.pve = pve;
        }

        public boolean getPvp()
        {
            return pvp;
        }

        public void setPvp(boolean pvp)
        {
            this.pvp = pvp;
        }

        public int getKeepInventorySize()
        {
            return keepInventorySize;
        }

        public void setKeepInventorySize(int keepInventorySize)
        {
            this.keepInventorySize = keepInventorySize;
        }
    }

    public interface IRegionBlock
    {
        void onPlayerBreakBlock(PlayerEvent.BreakSpeed event);
    }

    public void writeToNBT(NBTTagCompound tagCompound)
    {
        NBTTagList tagList = new NBTTagList();
        for(Region region : instance.regions)
        {
            NBTTagCompound regionCompound = new NBTTagCompound();
            region.writeToNBT(regionCompound);
            tagList.appendTag(regionCompound);
        }
        tagCompound.setTag("regions", tagList);
    }

    public void readFromNBT(NBTTagCompound tagCompound)
    {
        regions.clear();
        NBTTagList tagList = tagCompound.getTagList("regions", 10);
        for(int i = 0; i < tagList.tagCount(); i++)
        {
            Region region = new Region(tagList.getCompoundTagAt(i));
            regions.add(region);
        }
        if(getRegionByName("default") == null)
        {
            regions.add(0, new Region("default"));
        }
    }
}
