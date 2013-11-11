package powell.rasterland.biome;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import powell.rasterland.block.Blocks;

public class BiomeTestBiome extends BiomeGenBase
{

	public BiomeTestBiome(int par1)
	{
		super(par1);
		this.topBlock = (byte)Blocks.rasterBlock.blockID;
        
		// TODO Auto-generated constructor stub
	}

}
