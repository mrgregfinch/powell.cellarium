package powell.rasterland.biome;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.world.biome.BiomeGenBase;

public class Biomes
{
	public static BiomeGenBase test;
	
	
	public static void preInit()
	{
		test = new BiomeTestBiome(150).setBiomeName("Test").setMinMaxHeight(0.23F, 0.22F);
	}
	
	public static void load()
	{
		GameRegistry.addBiome(test);
	}
}
