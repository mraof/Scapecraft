package scapecraft.client.renderer.texture;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import scapecraft.util.Stat;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by mraof on 2016 March 02.
 */
public class TextureStat extends TextureAtlasSprite
{
    private final Stat stat;
    private static final ResourceLocation statIcons = new ResourceLocation("scapecraft", "textures/gui/StatIcons.png");
    private IResourceManager manager;

    public TextureStat(String name, Stat stat)
    {
        super(name);
        this.stat = stat;
    }

    @Override
    public boolean hasCustomLoader(IResourceManager manager, ResourceLocation location)
    {
        return true;
    }

    @Override
    public boolean load(IResourceManager manager, ResourceLocation location)
    {
        BufferedImage[] bufferedImages = new BufferedImage[1];
        try
        {
            int offset = stat.ordinal() + 2;
            bufferedImages[0] = ImageIO.read(manager.getResource(statIcons).getInputStream());
            int size = bufferedImages[0].getWidth() / 16;
            bufferedImages[0] = bufferedImages[0].getSubimage((offset % 16) * size, (offset / 16) * size, size, size);
            for(int x = 0; x < bufferedImages[0].getWidth(); x++)
            {
                for(int y = 0; y < bufferedImages[0].getHeight(); y++)
                {
                    bufferedImages[0].setRGB(x, y, bufferedImages[0].getRGB(x, y) & 0x7FFFFFFF); // 50% transparency
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
            return true;
        }
        loadSprite(bufferedImages, null, Minecraft.getMinecraft().gameSettings.anisotropicFiltering > 1);
        return false;
    }
}
