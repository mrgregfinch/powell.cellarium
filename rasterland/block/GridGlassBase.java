package powell.rasterland.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GridGlassBase extends Block
{
	public GridGlassBase(int par1)
	{
		super(par1, Material.glass);
        setStepSound(Block.soundGlassFootstep);
        setTextureName("rasterland:gridGlassBase");
        setUnlocalizedName("gridGlassBase");
	}
	
	@Override
	public int getRenderBlockPass()
	{
		return 1;
	}

}
