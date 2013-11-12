package powell.rasterland.block;

import net.minecraft.block.Block;

public class OrangeRasterBrick extends RasterBlock
{

	public OrangeRasterBrick(int par1)
	{
		super(par1);
		setUnlocalizedName("orangeRasterBrick");
		setTextureName("rasterland:orangeRasterBrick");
		this.belowBlock = Block.stoneBrick;
	}

}
