package scapecraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.resources.FolderResourcePack;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.client.resources.data.PackMetadataSection;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

/**
 * Created by mraof on 2016 March 02.
 */
@SideOnly(Side.CLIENT)
public class DynamicResourcePack implements IResourcePack
{
    //Just treat the cache folder as a resource pack
    private FolderResourcePack folderResourcePack;

    public void setCacheDir(File cacheDir)
    {
        this.folderResourcePack = new FolderResourcePack(cacheDir);
    }

    @Override
    public InputStream getInputStream(ResourceLocation resourceLocation) throws IOException
    {
        return this.folderResourcePack.getInputStream(resourceLocation);
    }

    @Override
    public boolean resourceExists(ResourceLocation resourceLocation)
    {
        return this.folderResourcePack.resourceExists(resourceLocation);
    }

    @Override
    public Set getResourceDomains()
    {
        return this.folderResourcePack.getResourceDomains();
    }

    @Override
    public IMetadataSection getPackMetadata(IMetadataSerializer p_135058_1_, String p_135058_2_) throws IOException
    {
        try
        {
            return this.folderResourcePack.getPackMetadata(p_135058_1_, p_135058_2_);
        }
        catch (FileNotFoundException e)
        {
            if("pack".equals(p_135058_2_))
            {
                return new PackMetadataSection(new ChatComponentText("Scapecraft Dynamic"), 1);
            }
        }
        return null;
    }

    @Override
    public BufferedImage getPackImage() throws IOException
    {
        return this.folderResourcePack.getPackImage();
    }

    @Override
    public String getPackName()
    {
        return "Scapecraft Dynamic";
    }
}
