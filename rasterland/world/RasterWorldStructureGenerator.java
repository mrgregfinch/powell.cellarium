package powell.rasterland.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import powell.rasterland.Rasterland;
import powell.rasterland.biome.Biomes;
import powell.rasterland.biome.YellowBiome;
import powell.rasterland.structure.RasterTestStructure;
import cpw.mods.fml.common.IWorldGenerator;

public class RasterWorldStructureGenerator implements IWorldGenerator

{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.dimensionId)
		{
			case Rasterland.DIMENSIONID: generateRasterland(world, random, chunkX*16, chunkZ*16);
			break;
		}
		
	}
	
	private void generateRasterland(World world, Random rand, int chunkX, int chunkZ)
	{
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(chunkX, chunkZ);
		 
		  if((biome instanceof YellowBiome))// then add ||BiomeGenXYZ if you want more.
		  {
			  System.out.println("inside the yellow generate");
		                for(int x = 0;x<2;x++)
		                {
		                 int i = chunkX + rand.nextInt(16);
		                 int k = chunkZ + rand.nextInt(16);
		                 int j = world.getHeightValue(i, k);
		                 new RasterTestStructure().generate(world, rand, i, j, k);
		                }
		  }

	}

}
