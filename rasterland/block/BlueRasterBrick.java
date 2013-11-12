package powell.rasterland.block;

import net.minecraft.block.Block;

public class BlueRasterBrick extends RasterBlock
{

	public BlueRasterBrick(int par1)
	{
		super(par1);
		setUnlocalizedName("blueRasterBrick");
		setTextureName("rasterland:blueRasterBrick");
		this.belowBlock = Block.stoneBrick;
	}

}
