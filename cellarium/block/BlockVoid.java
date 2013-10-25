package powell.cellarium.block;

import powell.cellarium.Cellarium;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

// basic block
public class BlockVoid extends Block {

	public BlockVoid(int id, Material material) {
		super(id, material);
		
		this.setCreativeTab(Cellarium.tabCellarium);
	}

}
