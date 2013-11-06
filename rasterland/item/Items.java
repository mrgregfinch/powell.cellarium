package powell.rasterland.item;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items
{
	public static Item voidPowder;
	
	public static void init()
	{
		voidPowder = new VoidPowder(9000);
	}
	
	public static void load()
	{
		GameRegistry.registerItem(voidPowder, "voidPowder");
		LanguageRegistry.addName(voidPowder,"Void Powder");
	}
}
