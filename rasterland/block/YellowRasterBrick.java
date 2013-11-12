package powell.rasterland.block;

import net.minecraft.block.Block;

public class YellowRasterBrick extends RasterBlock
{

	public YellowRasterBrick(int par1)
	{
		super(par1);
		setUnlocalizedName("yellowRasterBrick");
		setTextureName("rasterland:yellowRasterBrick");
		this.belowBlock = Block.stoneBrick;
	}

}
