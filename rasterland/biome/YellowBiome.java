package powell.rasterland.biome;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import powell.rasterland.block.Blocks;

public class YellowBiome extends BiomeGenBase
{

	public YellowBiome(int par1)
	{
		super(par1);
		this.topBlock = (byte)Blocks.yellowRasterBlock.blockID;
		this.fillerBlock = (byte)Blocks.yellowRasterBlock.blockID;
		// TODO Auto-generated constructor stub
	}

}
