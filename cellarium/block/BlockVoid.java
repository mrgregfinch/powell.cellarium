package powell.cellarium.block;

import powell.cellarium.Cellarium;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

// basic block
public class BlockVoid extends Block {

	public BlockVoid(int id, Material material) {
		super(id, material);
		
		// Block Attributes
		setUnlocalizedName("voidblock");
		setHardness(0.5F);
		setStepSound(Block.soundGravelFootstep);
		setCreativeTab(Cellarium.tabCellarium);
	}	

}
