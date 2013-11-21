package powell.rasterland.block;

import powell.rasterland.Rasterland;
import powell.rasterland.network.ClientProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class RasterWall extends BlockWall
{
	public Block belowBlock = Block.glass;

	public RasterWall(int par1, Block par2Block)
	{
		super(par1, par2Block);
		setStepSound(Block.soundGlassFootstep);
       // setTextureName("rasterland:rasterWallGreen");
        setUnlocalizedName("rasterWallGreen");
		setCreativeTab(Rasterland.tabRasterland);
		setHardness(5F);
		setResistance(5F);
		this.setLightOpacity(15);
	}
	
	
	@Override
	public boolean isBlockSolidOnSide(World world, int x, int y, int z, ForgeDirection side)
	{
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)
    {
        return Blocks.rasterWallBase.getBlockTextureFromSide(par1);
    }
	
	
	/**
     * Return whether an adjacent block can connect to a wall.
     */
	@Override
    public boolean canConnectWallTo(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        int l = par1IBlockAccess.getBlockId(par2, par3, par4);

        if (l != this.blockID )
        {
            Block block = Block.blocksList[l];
            return block != null && block.blockMaterial.isOpaque() && block.renderAsNormalBlock() ? block.blockMaterial != Material.pumpkin : false;
        }
        else
        {
            return true;
        }
    }
	
	@Override
	public int getRenderBlockPass()
	{
		return 1;
	}
	
	@Override
	public int getRenderType() 
	{
		return ClientProxy.rasterWallRenderType;
	}

	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z) 
	{
		if (ClientProxy.rasterWallRenderStage == 0) 
		{
			Block block = blocksList[world.getBlockId(x, y, z)];
			if (block != null && block != this) 
			{
				return block.getLightValue(world, x, y, z);
			}
			return lightValue[blockID];
		} 
		else 
		{
			return 15;
		}
	}

}
