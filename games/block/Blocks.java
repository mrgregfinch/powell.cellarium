package powell.games.block;

import net.minecraft.block.Block;
import powell.games.entity.tileentity.TTTBlockEntity;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks
{
	public static Block tttBlock;
	
	public static void init()
	{
		tttBlock = new TTTBlock(1442);
	}
	
	public static void load()
	{
		GameRegistry.registerBlock(tttBlock, "tttBlock");
		LanguageRegistry.addName(tttBlock, "Tic Tac Toe Block");
	}
	
	public static void registerTileEntities() 
	{
		GameRegistry.registerTileEntity(TTTBlockEntity.class, "tttBlockEntity");
	}
}
