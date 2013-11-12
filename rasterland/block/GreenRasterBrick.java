package powell.rasterland.block;

import net.minecraft.block.Block;

public class GreenRasterBrick extends RasterBlock
{

	public GreenRasterBrick(int par1)
	{
		super(par1);
		setUnlocalizedName("greenRasterBrick");
		setTextureName("rasterland:greenRasterBrick");
		this.belowBlock = Block.stoneBrick;
	}

}
