package powell.rasterland.block;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;



public class Blocks
{
	public static Block blockTeleporter;
	public static Block blockTeleporterFire;
	
	public static void init()
	{
		blockTeleporter = new BlockTeleporter(2000);
	}
	
	public static void load()
	{
		GameRegistry.registerBlock(blockTeleporter, "blockTeleporter");
		LanguageRegistry.addName(blockTeleporter, "Block for Teleportation");
	}
}
