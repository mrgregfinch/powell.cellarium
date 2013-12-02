package powell.rasterland.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import powell.rasterland.Rasterland;
import powell.rasterland.network.ClientProxy;

public class TestBlock extends Block 
{
    public TestBlock(int par1) 
    {
            super(par1, Material.glass);
          this.setLightOpacity(15);
            setStepSound(Block.soundStoneFootstep);
            setCreativeTab(Rasterland.tabRasterland);
            setHardness(5F);
            setResistance(5F);
            setTextureName("rasterland:disc_rev02");
            setUnlocalizedName("testBlock");
    }
    
    @Override
	public boolean isBlockSolidOnSide(World world, int x, int y, int z, ForgeDirection side)
	{
		return true;
	}

	/**
	 * Determines if a torch can be placed on the top surface of this block.
	 * Useful for creating your own block that torches can be on, such as
	 * fences.
	 *
	 * @param world
	 * The current world
	 * @param x
	 * X Position
	 * @param y
	 * Y Position
	 * @param z
	 * Z Position
	 * @return True to allow the torch to be placed
	 */
	@Override
	public boolean canPlaceTorchOnTop(World world, int x, int y, int z) 
	{
		return true;
	}

	@Override
	public boolean renderAsNormalBlock() 
	{
		return false;
	}

	@Override
	public boolean isOpaqueCube() 
	{
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderType() 
	{
		return ClientProxy.renderTestType;
	}
}
