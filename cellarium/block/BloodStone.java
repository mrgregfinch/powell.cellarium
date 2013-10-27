package powell.cellarium.block;

import java.util.Random;

import powell.cellarium.Cellarium;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BloodStone extends Block
{
	public BloodStone(int id)
	{
		super(id, Material.rock);
		setHardness(40.0F); //harder than diamond
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName("bloodStone");
		setCreativeTab(Cellarium.tabCellarium);
		setTextureName("cellarium:bloodStone");
	}
	
	public int idDropped(int metadata, Random random, int fortune)
	{
		return Cellarium.bloodOre.blockID;
	}
}
