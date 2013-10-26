package powell.cellarium;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockTearsOfChildren extends BlockFluidClassic
{
	public BlockTearsOfChildren(int id)
	{
		super(id, Cellarium.tearsOfChildren, Material.water);
		Cellarium.tearsOfChildren.setBlockID(id);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta)
	{
		return Block.waterMoving.getIcon(side, meta);
	}
	
	/*
	@Override
	public int colorMultiplier(IBlockAccess iblockaccess, int x, int y, int z)
	{
		return 0x66FF00; //HEX color to change water color
	}*/
	
	@Override
	public int getLightValue(IBlockAccess iBlockAccess, int x, int y, int z)
	{
		return maxScaledLight;
	}
}
