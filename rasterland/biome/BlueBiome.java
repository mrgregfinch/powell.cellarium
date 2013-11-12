package powell.rasterland.biome;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import powell.rasterland.block.Blocks;

public class BlueBiome extends BiomeGenBase
{

	public BlueBiome(int par1)
	{
		super(par1);
		this.topBlock = (byte)Blocks.blueRasterBlock.blockID;
        
		// TODO Auto-generated constructor stub
	}

}
