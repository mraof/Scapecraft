package scapecraft.client;

import net.minecraft.client.resources.FolderResourcePack;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.MetadataSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.image.BufferedImage;
import java.io.File;
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
    public Set<String> getResourceDomains()
    {
        return this.folderResourcePack.getResourceDomains();
    }

    @Override
    public <T extends IMetadataSection> T getPackMetadata(MetadataSerializer p_135058_1_, String p_135058_2_) throws IOException
    {
        return this.folderResourcePack.getPackMetadata(p_135058_1_, p_135058_2_);
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
