package powell.rasterland.block;

import net.minecraft.block.Block;

public class RedRasterBrick extends RasterBlock
{

	public RedRasterBrick(int par1)
	{
		super(par1);
		setUnlocalizedName("redRasterBrick");
		setTextureName("rasterland:redRasterBrick");
		this.belowBlock = Block.stoneBrick;
	}

}
