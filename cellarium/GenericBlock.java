package powell.cellarium;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class GenericBlock extends Block
{
	private Icon clear;
	
	public GenericBlock (int id, Material material)
	{
		super(id, material);
		setCreativeTab(Cellarium.tabCellarium);
	}
	
	 //public void getSubBlocks(int id, CreativeTabs ctabs, List par3List)
	   // {
	    //    par3List.add(new ItemStack(id, 1, 0));

	   // }
	
    /* @SideOnly(Side.CLIENT)
     public void registerIcons(IconRegister iconRegister){
    	 
             //block texture
             blockIcon = iconRegister.registerIcon("cellarium:voidblock");
             clear = iconRegister.registerIcon("cellarium:block");
             
     }
     
     @Override
     @SideOnly(value = Side.CLIENT)
     public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int dir)
     {
             if (Cellarium.displayclear)
                     return clear;
             else
                     return blockIcon;
     }*/
}
