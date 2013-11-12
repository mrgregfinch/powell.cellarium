package powell.rasterland.biome;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import powell.rasterland.block.Blocks;

public class GreenBiome extends BiomeGenBase
{

	public GreenBiome(int par1)
	{
		super(par1);
		this.topBlock = (byte)Blocks.greenRasterBlock.blockID;
        
		// TODO Auto-generated constructor stub
	}

}
