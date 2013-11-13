package powell.rasterland.biome;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import powell.rasterland.block.Blocks;

public class RedBiome extends BiomeGenBase
{

	public RedBiome(int par1)
	{
		super(par1);
		this.topBlock = (byte)Blocks.redRasterBlock.blockID;
		this.fillerBlock = (byte)Blocks.redRasterBlock.blockID;
		// TODO Auto-generated constructor stub
	}

}
