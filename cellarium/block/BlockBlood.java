package powell.cellarium.block;

import powell.cellarium.Cellarium;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockBlood extends BlockFluidClassic
{
	public BlockBlood(int id)
	{
		super(id, Cellarium.blood, Material.water);
		Cellarium.blood.setBlockID(id);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta)
	{
		return Block.waterMoving.getIcon(side, meta);
	}
	
	
	@Override
	public int colorMultiplier(IBlockAccess iblockaccess, int x, int y, int z)
	{
		return 0x9b1c0f; //HEX color to change water color
	}
	
	/*
	@Override
	public int getLightValue(IBlockAccess iBlockAccess, int x, int y, int z)
	{
		return maxScaledLight;
	}*/
}
