package powell.games.item;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items
{
	public static Item ttt;
	
	public static void init()
	{
		ttt = new TTTItem(9500);
	}
	
	public static void load()
	{
		GameRegistry.registerItem(ttt,"tttItem");
		LanguageRegistry.addName(ttt, "Tic Tac Toe");
		
	}
}

