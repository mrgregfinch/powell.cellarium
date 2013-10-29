package powell.cellarium.block;

import powell.cellarium.Cellarium;
import powell.cellarium.gui.VisionOfPowellGUI;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class VisionOfPowellBlock extends Block
{
	public VisionOfPowellBlock(int id)
	{
		super(id, Material.rock);
		setUnlocalizedName("visionOfPowellBlock");
		setCreativeTab(Cellarium.tabCellarium);
		setTextureName("cellarium:visionOfPowellBlock");
	}
	
	@Override
	 public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
		new VisionOfPowellGUI(1);
        return false;
    }
}
