package powell.rasterland.biome;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.world.biome.BiomeGenBase;


public class Biomes
{
	public static BiomeGenBase test;
	public static BiomeGenBase red;
	public static BiomeGenBase orange;
	public static BiomeGenBase yellow;
	public static BiomeGenBase green;
	public static BiomeGenBase blue;
	public static BiomeGenBase purple;
	
	
	public static void preInit()
	{
		test = new BiomeTestBiome(150).setBiomeName("Test").setMinMaxHeight(0.23F, 0.22F);
		red = new RedBiome(151).setBiomeName("Red").setMinMaxHeight(0.23F, 0.22F);
		orange = new OrangeBiome(152).setBiomeName("Orange").setMinMaxHeight(0.23F, 0.22F);
		yellow = new YellowBiome(153).setBiomeName("Yellow").setMinMaxHeight(0.23F, 0.22F);
		green = new GreenBiome(154).setBiomeName("Green").setMinMaxHeight(0.23F, 0.22F);
		blue = new BlueBiome(155).setBiomeName("Blue").setMinMaxHeight(0.23F, 0.22F);
		purple = new PurpleBiome(156).setBiomeName("Purple").setMinMaxHeight(0.23F, 0.22F);
	}
	
	public static void load()
	{
//		GameRegistry.addBiome(test);
//		GameRegistry.addBiome(red);
//		GameRegistry.addBiome(orange);
//		GameRegistry.addBiome(yellow);
//		GameRegistry.addBiome(green);
//		GameRegistry.addBiome(blue);
//		GameRegistry.addBiome(purple);
	}
}
