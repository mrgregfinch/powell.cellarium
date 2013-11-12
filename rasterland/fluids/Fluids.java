package powell.rasterland.fluids;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;

public class Fluids
{
	public static Fluid rasterWasser;
	public static Block blockRasterWasser;
	
	
	public static void init()
	{
		rasterWasser = new RasterWasser();
		blockRasterWasser = new BlockRasterWasser(2734);
	}
	
	public static void load()
	{
		GameRegistry.registerBlock(blockRasterWasser,"blockRasterWasser");
		LanguageRegistry.addName(blockRasterWasser, "Rasterland Wasser");
	}
}
