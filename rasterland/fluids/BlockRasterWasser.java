package powell.rasterland.fluids;

import powell.rasterland.Rasterland;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockRasterWasser extends BlockFluidClassic
{
	public BlockRasterWasser(int id)
	{
		super(id, Fluids.rasterWasser, Material.water);
		Fluids.rasterWasser.setBlockID(id);
		setUnlocalizedName("blockRasterWasser");
		setCreativeTab(Rasterland.tabRasterland);
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
	

	@Override
	protected void flowIntoBlock(World world, int x, int y, int z, int meta)
    {
        if (meta < 0) return;
        if (displaceIfPossible(world, x, y, z))
        {
//        	if(world.getBlockId(x, y, z) == Cellarium.blockBoilingBlood.blockID && world.getBlockMetadata(x, y, z) == 0)
//        		world.setBlock(x, y, z, Cellarium.bloodStone.blockID);
//        	else
//        		world.setBlock(x, y, z, this.blockID, meta, 3);
        }
    }
}
