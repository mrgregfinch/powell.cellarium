package powell.cellarium.block;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import powell.cellarium.Cellarium;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

// basic block
public class BlockVoid extends Block {

	public BlockVoid(int id, Material material) {
		super(id, material);
		
		// Block Attributes
		this.setUnlocalizedName("voidblock");
		this.setHardness(0.5F);
		this.setStepSound(Block.soundGravelFootstep);
		this.setCreativeTab(Cellarium.tabCellarium);
		
		setTextureName("cellarium:voidblock");
		
	}	
	
	
}
