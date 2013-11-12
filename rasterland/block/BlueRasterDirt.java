package powell.rasterland.block;

import net.minecraft.block.Block;

public class BlueRasterDirt extends RasterBlock
{

	public BlueRasterDirt(int par1)
	{
		super(par1);
		setUnlocalizedName("blueRasterDirt");
		setTextureName("rasterland:blueRasterDirt");
		this.belowBlock = Block.dirt;
	}

}
