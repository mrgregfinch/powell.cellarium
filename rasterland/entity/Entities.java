package powell.rasterland.entity;

import powell.rasterland.Rasterland;
import cpw.mods.fml.common.registry.EntityRegistry;

public class Entities
{
	private static int modEntityID = 0;
	
	public static void init()
	{
		EntityRegistry.registerModEntity(EntityDisc.class, "Raster Disc", ++modEntityID, Rasterland.instance, 64, 10, true);
	}
}
