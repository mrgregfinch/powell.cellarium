package powell.cellarium.block;

import powell.cellarium.Cellarium;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockBoilingBlood extends BlockFluidClassic
{
	private Icon iconStill;
	private Icon iconFlowing;
	
	public BlockBoilingBlood(int id)
	{
		super(id, Cellarium.boilingBlood, Material.lava);
		Cellarium.boilingBlood.setBlockID(id);
		setUnlocalizedName("blockBoilingBlood");
		setCreativeTab(Cellarium.tabCellarium);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta)
	{
		if (side <= 1)
			return iconStill;
		else
			return iconFlowing;
	}
	
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{

		//block texture
		iconStill = iconRegister.registerIcon("cellarium:boilingBloodStill");
		iconFlowing = iconRegister.registerIcon("cellarium:boilingBloodFlow");
		getFluid().setIcons(iconStill, iconFlowing);

	}
}
