package powell.rasterland.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import powell.rasterland.Rasterland;

public class RasterWallBase extends RasterBlock
{

	public RasterWallBase(int par1)
	{
		super(par1, Material.glass);
        setStepSound(Block.soundGlassFootstep);
        setTextureName("rasterland:rasterWallGreen");
        setUnlocalizedName("rasterWallBaseGreen");
        this.belowBlock = Block.glass;
	}
	
	@Override
	public int getRenderBlockPass()
	{
		return 1;
	}

}
