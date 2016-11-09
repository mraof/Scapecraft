package scapecraft.event;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import scapecraft.compat.Compat;
import scapecraft.entity.EntityDrop;

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
        if(event.getState().getBlock() instanceof IRegionBlock)
        {
            ((IRegionBlock) event.getState().getBlock()).onPlayerBreakBlock(event);
        }
        else
        {
            Region region = getRegion(event.getEntity().dimension, event.getPos());
            if (region != null && !region.isEditable())
            {
                event.setNewSpeed(-1);
            }
        }
    }

    @SubscribeEvent
    public void onBucketFill(FillBucketEvent event)
    {
        Region region = getRegion(event.getEntity().dimension, event.getTarget().getBlockPos());
        if (region != null && !region.isEditable())
        {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onItemFrameAttack(ItemFrameEvent.Attack event)
    {
        Region region = getRegion(event.getWorld().provider.getDimension(), event.getPos());
        if((region != null) && !region.isEditable() && !(event.getSource().getEntity() instanceof EntityPlayer && ((EntityPlayer) event.getSource().getEntity()).capabilities.isCreativeMode))
        {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onPlayerBreakBlock(BlockEvent.BreakEvent event)
    {
        Region region = getRegion(event.getPlayer().dimension, event.getPos());
        if(!(event.getPlayer().worldObj.getBlockState(event.getPos()).getBlock() instanceof IRegionBlock) && (region != null) && !region.isEditable() && !event.getPlayer().capabilities.isCreativeMode)
        {
            event.setCanceled(true);
        }
    }
    @SubscribeEvent
    public void onPlayerPlaceBlock(BlockEvent.PlaceEvent event)
    {
        Region region = getRegion(event.getPlayer().dimension, event.getPos());
        if(region != null && !region.isEditable() && !event.getPlayer().capabilities.isCreativeMode)
        {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onItemFramePlace(ItemFrameEvent.Place event)
    {
        Region region = getRegion(event.getEntityPlayer().dimension, event.getPos());
        if(region != null && !region.isEditable() && !event.getEntityPlayer().capabilities.isCreativeMode)
        {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onItemFrameInteract(ItemFrameEvent.Interact event)
    {
        Region region = getRegion(event.getEntityPlayer().dimension, event.getPos());
        if(region != null && !region.isEditable() && !event.getEntityPlayer().capabilities.isCreativeMode)
        {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onLivingAttack(LivingAttackEvent event)
    {
        Region targetRegion = getRegion(event.getEntity().dimension, event.getEntity().getPosition());
        Region sourceRegion = (event.getSource().getEntity() == null) ? null : getRegion(event.getSource().getEntity().dimension, event.getSource().getEntity().getPosition());
        if(event.getSource().getEntity() instanceof EntityPlayer && event.getEntity() instanceof EntityPlayer)
        {
            if(!(((targetRegion == null) || targetRegion.pvp) && ((sourceRegion == null) || sourceRegion.pvp)))
            {
                event.setCanceled(true);
            }
        }
        else if((event.getSource().getEntity() instanceof EntityPlayer) != (event.getEntity() instanceof EntityPlayer))
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
        if ((event.getEntityLiving() instanceof EntityPlayer) && !event.getEntityLiving().worldObj.isRemote && ((FMLCommonHandler.instance().getMinecraftServerInstance().getTickCounter() % 10) == 0) && !((EntityPlayer) event.getEntityLiving()).capabilities.isCreativeMode)
        {
            Region region = getRegion(event.getEntityLiving().dimension, event.getEntityLiving().getPosition());
            if (region.isNoEntry())
            {
                event.getEntityLiving().attackEntityFrom(DamageSource.outOfWorld, event.getEntityLiving().getMaxHealth() / 10);
                event.getEntityLiving().addChatMessage(new TextComponentString("§4You are not allowed here, return or die"));
            }
            if(Compat.dynmap)
            {
                scapecraft.compat.dynmap.DynmapHandler.api.assertPlayerInvisibility(event.getEntityLiving().getName(), region.getPvp(), "Scapecraft");
            }
        }
    }

    @SubscribeEvent
    public void onPlayerDrops(PlayerDropsEvent event)
    {
        Region region = getRegion(event.getEntityPlayer().dimension, event.getEntityPlayer().getPosition());
        if(!event.getDrops().isEmpty())
        {
            /*if(region.getKeepInventorySize() > 0)
            {
                for(int i = 0; i < region.getKeepInventorySize() && !event.getDrops().isEmpty(); i++)
                {
                    event.getEntityPlayer().inventory.addItemStackToInventory(event.getDrops().remove(0).getEntityItem().copy());
                }
            }*/
            if(!region.getPvp())
            {
                EntityDrop entityDrop = new EntityDrop(event.getEntityPlayer().worldObj);
                for (EntityItem entityItem : event.getDrops())
                {
                    entityDrop.addItem(entityItem);
                }
                entityDrop.owner = event.getEntityPlayer().getName();
                entityDrop.setPosition(event.getDrops().get(0).posX, event.getDrops().get(0).posY, event.getDrops().get(0).posZ);
                entityDrop.forceSpawn = true;
                if(event.getEntityPlayer().worldObj.spawnEntityInWorld(entityDrop))
                {
                    event.setCanceled(true);
                }
            }
        }
    }

    public Region getRegion(int dimension, BlockPos pos)
    {
        Region region = getRegionByName("default");
        int tier = -1;
        for (Region currentRegion : regions)
        {
            int currentTier = currentRegion.regionTier(dimension, pos);
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

        public int regionTier(int dimension, BlockPos pos)
        {
            int tier = -1;
            for(int[] area : areas)
            {
                if(area[0] == dimension && area[1] <= pos.getX() && area[2] >= pos.getX() && area[3] <= pos.getY() && area[4] >= pos.getY() && area[5] <= pos.getZ() && area[6] >= pos.getZ() && area[7] > tier)
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
            int tmp;
            if(xMin > xMax)
            {
                tmp = xMax;
                xMax = xMin;
                xMin = tmp;
            }
            if(yMin > yMax)
            {
                tmp = yMax;
                yMax = yMin;
                yMin = tmp;
            }
            if(zMin > zMax)
            {
                tmp = zMax;
                zMax = zMin;
                zMin = tmp;
            }
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
            tagCompound.setBoolean("noEntry", noEntry);
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
            this.noEntry = tagCompound.getBoolean("noEntry");
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
