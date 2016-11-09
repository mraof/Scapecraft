package scapecraft;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CommonProxy
{
	public HashMap<String, Long> cache;
	public File cacheDir;
	public HashMap<String, byte[]> textureData;

	public void registerPreInit() {}

	public void setCacheDir(File cacheDir)
	{
		this.cacheDir = cacheDir;
		if(!this.cacheDir.isDirectory())
		{
			this.cacheDir.delete();
		}
		cacheDir.mkdirs();
		File cacheFile = new File(cacheDir, "cache");
		cache = new HashMap<String, Long>();
		if(cacheFile.exists())
		{
			try
			{
				BufferedReader reader = new BufferedReader(new FileReader(cacheFile));
				String line;
				while ((line = reader.readLine()) != null)
				{
					int index = line.indexOf(' ');
					if(index != -1)
					{
						cache.put(line.substring(0, index), Long.parseLong(line.substring(index + 1)));
					}
				}
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	public void registerRenderers(){}
	public void registerMobRenderer(NBTTagCompound tagCompound){}

	public void cacheResource(ResourceLocation location, byte[] data, long cacheId)
	{
		//TODO add a way to add new resources on the server
		if(cacheId == -1)
		{
			cacheId = System.currentTimeMillis();
		}
		cache.put(location.toString(), cacheId);
		File file = new File(cacheDir, String.format("%s/%s/%s", "assets", location.getResourceDomain(), location.getResourcePath()));
		try
		{
			file.getParentFile().mkdirs();
			file.delete();
			file.createNewFile();
			BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
			outputStream.write(data);
			outputStream.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void saveCache()
	{
		File cacheFile = new File(cacheDir, "cache");
		cacheFile.delete();
		try
		{
			cacheFile.createNewFile();
			PrintWriter out = new PrintWriter(cacheFile);
			for (Map.Entry<String, Long> entry : cache.entrySet())
			{
				out.println(String.format("%s %d", entry.getKey(), entry.getValue()));
			}
			out.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
