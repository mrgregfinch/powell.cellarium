package powell.rasterland.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import powell.rasterland.Rasterland;
import powell.rasterland.entity.RasterWallTileEntity;
import powell.rasterland.network.ClientProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RasterWall extends BlockWall implements ITileEntityProvider
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
	@SideOnly(Side.CLIENT)
	public int getRenderType() 
	{
		return ClientProxy.rasterWallRenderType;
	}

	@SideOnly(Side.CLIENT)
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


	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new RasterWallTileEntity();
	}
	
	/**
     * Called on server worlds only when the block has been replaced by a different block ID, or the same block with a
     * different metadata value, but before the new metadata value is set. Args: World, x, y, z, old block ID, old
     * metadata
     */
	@Override
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        super.breakBlock(par1World, par2, par3, par4, par5, par6);
        par1World.removeBlockTileEntity(par2, par3, par4);
    }

}
