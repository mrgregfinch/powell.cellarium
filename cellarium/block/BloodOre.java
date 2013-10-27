package powell.cellarium.block;

import powell.cellarium.Cellarium;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BloodOre extends Block
{
	public BloodOre(int id)
	{
		super(id, Material.rock);
		setHardness(20.0F); //harder than diamond
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName("bloodOre");
		setCreativeTab(Cellarium.tabCellarium);
		setTextureName("cellarium:bloodOre");
	}
	
	
}
