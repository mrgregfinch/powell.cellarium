package powell.cellarium.block;

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
		setUnlocalizedName("voidblock");
		setHardness(0.5F);
		setStepSound(Block.soundGravelFootstep);
		setCreativeTab(Cellarium.tabCellarium);
	}	
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		
		//block texture
		blockIcon = iconRegister.registerIcon("cellarium" + ":" + "voidblock");
		
	}

}
