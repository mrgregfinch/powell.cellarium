package powell.rasterland.item;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items
{
	public static Item voidPowder;
	public static Item disc;
	
	public static void init()
	{
		voidPowder = new VoidPowder(9000);
		disc = new Disc(9001);
	}
	
	public static void load()
	{
		GameRegistry.registerItem(voidPowder, "voidPowder");
		LanguageRegistry.addName(voidPowder,"Void Powder");
		
		GameRegistry.registerItem(disc,"disc");
		LanguageRegistry.addName(disc, "Raster Disc");
	}
}
