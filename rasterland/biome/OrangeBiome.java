package powell.rasterland.biome;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import powell.rasterland.block.Blocks;

public class OrangeBiome extends BiomeGenBase
{

	public OrangeBiome(int par1)
	{
		super(par1);
		this.topBlock = (byte)Blocks.orangeRasterBlock.blockID;
		this.fillerBlock = (byte)Blocks.orangeRasterBlock.blockID;
		// TODO Auto-generated constructor stub
	}

}
