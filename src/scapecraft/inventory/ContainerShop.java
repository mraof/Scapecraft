package scapecraft.inventory;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.item.ItemStack;
import scapecraft.Scapecraft;
import scapecraft.client.gui.GuiHandler;
import scapecraft.economy.EconomyHandler;
import scapecraft.economy.market.Listing;
import scapecraft.entity.EntityDrop;

import java.util.Collection;

/**
 * Created by mraof on 2016 March 02.
 */
public class ContainerShop extends ContainerScapecraft
{
    public static final int SECTION_SIZE = 14;
    public Listing[] listings = new Listing[SECTION_SIZE * 2];
    public int tabs = 0;
    public int tabNumber;
    int tabOffset;
    private final int srcX;
    private final int srcY;
    private final int srcZ;

    public ContainerShop(InventoryPlayer inventoryPlayer, Collection<Listing> listings, int tabNumber, int srcX, int srcY, int srcZ)
    {
        super(new InventoryScapecraft(SECTION_SIZE * 2));
        this.tabNumber = tabNumber;
        this.srcX = srcX;
        this.srcY = srcY;
        this.srcZ = srcZ;
        xOffset = 44;
        yOffset = 141;
        addPlayerInventory(inventoryPlayer);
        int buyingOffset = 0 - SECTION_SIZE * tabNumber;
        int sellingOffset = SECTION_SIZE - SECTION_SIZE * tabNumber;
        int buyingTabs = 0;
        int sellingTabs = 0;
        tabOffset = 0;
        //System.out.println(listings);
        InventoryScapecraft inventoryTabs = new InventoryScapecraft(9);
        for(Listing listing : listings)
        {
            if (!listing.selling)
            {
                if(sellingOffset % SECTION_SIZE == 0)
                {
                    if (sellingTabs - tabOffset >= 9)
                    {
                        if(tabNumber < sellingTabs - 4)
                        {
                            continue;
                        }
                        for (int i = 1; i < 9; i++)
                        {
                            inventoryTabs.setInventorySlotContents(i - 1, inventoryTabs.getStackInSlot(i));
                        }
                        tabOffset++;
                    }
                    if(sellingTabs >= tabOffset && inventoryTabs.getStackInSlot(sellingTabs - tabOffset) == null)
                    {
                        inventoryTabs.setInventorySlotContents(sellingTabs - tabOffset, listing.stack);
                    }
                    sellingTabs++;
                }
                if (sellingOffset >= SECTION_SIZE && sellingOffset < SECTION_SIZE * 2)
                {
                    inventoryScapecraft.setInventorySlotContents(sellingOffset, listing.stack);
                    this.listings[sellingOffset] = listing;
                }
                sellingOffset++;
            }
            else
            {
                if(buyingOffset % SECTION_SIZE == 0)
                {
                    if (buyingTabs - tabOffset == 9)
                    {
                        if(tabNumber < buyingTabs - 4)
                        {
                            continue;
                        }
                        for (int i = 1; i < 9; i++)
                        {
                            inventoryTabs.setInventorySlotContents(i - 1, inventoryTabs.getStackInSlot(i));
                        }
                        tabOffset++;
                    }
                    if(buyingTabs >= tabOffset && inventoryTabs.getStackInSlot(buyingTabs - tabOffset) == null)
                    {
                        inventoryTabs.setInventorySlotContents(buyingTabs - tabOffset, listing.stack);
                    }
                    buyingTabs++;
                }
                if (buyingOffset >= 0 && buyingOffset < SECTION_SIZE)
                {
                    inventoryScapecraft.setInventorySlotContents(buyingOffset, listing.stack);
                    this.listings[buyingOffset] = listing;
                }
                buyingOffset++;
            }
        }
        tabs = sellingTabs > buyingOffset ? sellingTabs - tabOffset : buyingTabs - tabOffset;
        if(tabs == 1)
        {
            inventoryTabs.setInventorySlotContents(0, null);
        }
        //System.out.println(tabs + " " + tabNumber);
        for(int y = 0; y < 2; y++)
        {
            for(int x = 0; x < SECTION_SIZE / 2; x++)
            {
                addSlotToContainer(new SlotPreview(inventoryScapecraft, x + y * SECTION_SIZE / 2, 8 + x * 36, 16 + y * 27));
            }
        }
        for(int y = 0; y < 2; y++)
        {
            for(int x = 0; x < SECTION_SIZE / 2; x++)
            {
                addSlotToContainer(new SlotPreview(inventoryScapecraft, SECTION_SIZE + x + y * SECTION_SIZE / 2, 8 + x * 36, 86 + y * 27));
            }
        }
        for(int x = 0; x < 9; x++)
        {
            addSlotToContainer(new SlotPreview(inventoryTabs, x, 6 + x * 26, -18));
        }
        //System.out.println(inventoryScapecraft);
        //System.out.println(inventorySlots);
    }

    public void addListener(IContainerListener listener)
    {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, this.inventoryScapecraft);
    }

/*    @Override
    public void onCraftGuiOpened(ICrafting iCrafting)
    {
        super.onCraftGuiOpened(iCrafting);
        for(int i = 0; i < SECTION_SIZE * 2; i++)
        {
            if(listings[i] != null)
            {
                iCrafting.sendProgressBarUpdate(this, i, listings[i].price);
                iCrafting.sendProgressBarUpdate(this, i + SECTION_SIZE * 2, listings[i].stock);
            }
        }
        iCrafting.sendProgressBarUpdate(this, -1, tabNumber - tabOffset);
        iCrafting.sendProgressBarUpdate(this, -2, tabs);
    }*/

    @Override
    public void updateProgressBar(int index, int value)
    {
        if(index >= SECTION_SIZE * 2)
        {
            listings[index - SECTION_SIZE * 2].stock = value;
        }
        else if(index >= 0)
        {
            listings[index] = new Listing(value, null, false);
        }
        else
        {
            switch (index)
            {
                case -1:
                    tabNumber = value;
                    break;
                case -2:
                    tabs = value;
                    break;
            }

        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotNum)
    {
        return null;
    }

    @Override
    public ItemStack slotClick(int slotId, int clickedButton, ClickType type, EntityPlayer player)
    {
        if(slotId < PLAYER_INV_SIZE)
        {
            return super.slotClick(slotId, clickedButton, type, player);
        }
        if(!player.worldObj.isRemote)
        {
            slotId -= PLAYER_INV_SIZE;
            if(slotId < SECTION_SIZE * 2)
            {
                Listing listing = listings[slotId];
                if(listing == null)
                {
                    return null;
                }
                ItemStack stack = listing.stack;
                //System.out.println(stack + " " + slotId + " " + listing);
                int oldStock = listing.stock;
                if(clickedButton == 2 && player.capabilities.isCreativeMode)
                {
                    listing.stock--;
                }
                if (listing.selling)
                {
                    if (stack != null && EconomyHandler.getBalance(player.getUniqueID()) >= listing.price)
                    {
                        stack = stack.copy();
                        if(listing.buy())
                        {
                            EconomyHandler.deposit(player.getUniqueID(), -listing.price);
                            if (!player.inventory.addItemStackToInventory(stack))
                            {
                                EntityDrop entityDrop = new EntityDrop(player.worldObj);
                                EntityItem entityItem = new EntityItem(player.worldObj, player.posX, player.posY, player.posZ, stack);
                                entityItem.setPickupDelay(0);
                                entityDrop.addItem(entityItem);
                                entityDrop.owner = player.getName();
                                entityDrop.setPosition(player.posX, player.posY, player.posZ);
                                player.worldObj.spawnEntityInWorld(entityDrop);
                            }
                            ((EntityPlayerMP) player).isChangingQuantityOnly = false;
                            detectAndSendChanges();
                        }
                    }
                }
                else
                {
                    if (stack != null)
                    {
                        for (int i = 0; i < PLAYER_INV_SIZE; i++)
                        {
                            if (player.inventory.getStackInSlot(i) != null && stack.isItemEqual(player.inventory.getStackInSlot(i)) && player.inventory.getStackInSlot(i).stackSize >= stack.stackSize)
                            {
                                if(listing.buy())
                                {
                                    player.inventory.decrStackSize(i, stack.stackSize);
                                    EconomyHandler.deposit(player.getUniqueID(), listing.price);
                                    ((EntityPlayerMP) player).isChangingQuantityOnly = false;
                                    detectAndSendChanges();
                                }
                                break;
                            }
                        }
                    }
                }
                if(oldStock != 0 && listing.stock == 0)
                {
                    inventoryScapecraft.setInventorySlotContents(slotId, null);
                    ((EntityPlayerMP) player).isChangingQuantityOnly = false;
                    detectAndSendChanges();
                }
            }
            else if((slotId -= SECTION_SIZE * 2) < tabs && slotId + tabOffset != tabNumber)
            {
                this.tabNumber = slotId + tabOffset;
                player.openGui(Scapecraft.instance, GuiHandler.GuiId.SHOP.ordinal(), player.worldObj, srcX, srcY, srcZ);
            }
        }
        return null;
    }
}
