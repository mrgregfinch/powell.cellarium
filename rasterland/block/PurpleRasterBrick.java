package powell.rasterland.block;

import net.minecraft.block.Block;

public class PurpleRasterBrick extends RasterBlock
{

	public PurpleRasterBrick(int par1)
	{
		super(par1);
		setUnlocalizedName("purpleRasterBrick");
		setTextureName("rasterland:purpleRasterBrick");
		this.belowBlock = Block.stoneBrick;
	}

}
