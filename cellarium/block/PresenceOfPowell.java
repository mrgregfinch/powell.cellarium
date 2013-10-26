package powell.cellarium.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import powell.cellarium.Cellarium;
import powell.cellarium.block.material.POPMaterial;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class PresenceOfPowell extends Block
{
	private Icon clear;
	
	public PresenceOfPowell(int id)
	{
		super(id, new POPMaterial());
		setLightValue(1.0f);
		setUnlocalizedName("presenceOfPowell");
		setCreativeTab(Cellarium.tabCellarium);
		//setTextureName("cellarium:presenceOfPowell");
		setBlockBounds(0.0F,0.0F,0.0F,1.0F,1.0F,1.0F);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	{
		return null;
	}

	//makes sure the block sides do not cause adjoining blocks to become transparent as well
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	  @SideOnly(Side.CLIENT)
	     public void registerIcons(IconRegister iconRegister){
	    	 
	             //block texture
	             blockIcon = iconRegister.registerIcon("cellarium:cellariumLogo");
	             clear = iconRegister.registerIcon("cellarium:presenceOfPowell");
	             
	     }
	     
	     @Override
	     @SideOnly(value = Side.CLIENT)
	     public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int dir)
	     {
	             if (Cellarium.displayclear)
	                     return clear;
	             else
	                     return blockIcon;
	     }
	
	
	/*
	@Override
    public boolean renderAsNormalBlock()
{
    return false;
}
	@Override
	public void registerIcons(IconRegister icon)
	{
	this.blockIcon = icon.registerIcon("your_mod_id_lower_case:your_icon_texture_name");
	}
*/

}
