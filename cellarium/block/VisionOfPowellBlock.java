package powell.cellarium.block;

import powell.cellarium.Cellarium;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class VisionOfPowellBlock extends Block
{
	public VisionOfPowellBlock(int id)
	{
		super(id, Material.rock);
		setUnlocalizedName("visionOfPowellBlock");
		setCreativeTab(Cellarium.tabCellarium);
		setTextureName("cellarium:visionOfPowellBlock");
	}
}
