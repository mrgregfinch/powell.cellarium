package powell.rasterland.item;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items
{
	public static Item disc;
	public static Item rasterStick;
	
	public static void init()
	{
		disc = new Disc(9001);
		rasterStick = new RasterStick(9002);
	}
	
	public static void load()
	{
		GameRegistry.registerItem(disc,"disc");
		LanguageRegistry.addName(disc, "Raster Disc");
		
		GameRegistry.registerItem(rasterStick, "rasterStick");
		LanguageRegistry.addName(rasterStick, "Raster Stick");
	}
}
