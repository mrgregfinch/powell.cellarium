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
		red = new RedBiome(151).setBiomeName("Red").setMinMaxHeight(2.0F, 0.0F);//nether?
		orange = new OrangeBiome(152).setBiomeName("Orange").setMinMaxHeight(-0.2F, 0.1F);//swampland
		yellow = new YellowBiome(153).setBiomeName("Yellow").setMinMaxHeight(0.1F, 0.2F);//desert
		green = new GreenBiome(154).setBiomeName("Green").setMinMaxHeight(0.8F, 0.4F);//plains
		blue = new BlueBiome(155).setBiomeName("Blue").setMinMaxHeight(0.05F, 0.8F);//taiga
		purple = new PurpleBiome(156).setBiomeName("Purple").setMinMaxHeight(0.3F, 1.5F);//extreme hills values
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
