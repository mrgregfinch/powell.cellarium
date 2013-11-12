package powell.rasterland.biome;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import powell.rasterland.block.Blocks;

public class PurpleBiome extends BiomeGenBase
{

	public PurpleBiome(int par1)
	{
		super(par1);
		this.topBlock = (byte)Blocks.purpleRasterBlock.blockID;
        
		// TODO Auto-generated constructor stub
	}

}
