package powell.games.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import powell.games.Games;
import powell.games.entity.tileentity.TTTBlockEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TTTBlock extends BlockContainer
{
	private Icon full;
	private Icon x;
	private Icon o;
	private boolean showX;
	private boolean showO;

	public TTTBlock(int par1)
	{
		super(par1, Material.rock);
		setStepSound(Block.soundStoneFootstep);
		setCreativeTab(Games.tabGames);
		setHardness(500000F);
		setResistance(500000F);
		setUnlocalizedName("tttBlock");
		showX = showO = false;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{

		//block texture
		blockIcon = iconRegister.registerIcon("games:tictactoe");
		x = iconRegister.registerIcon("games:x");
		o = iconRegister.registerIcon("games:o");

	}

//	@Override
//	@SideOnly(value = Side.CLIENT)
//	public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int dir)
//	{
//		if(showX)
//			return this.x;
//		else if(showO)
//			return this.o;
//		else
//			return blockIcon;
//	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		if(!showX && !showO)
		{
			System.out.println("was right clicked");
			//showX = true;
			TTTBlockEntity be = (TTTBlockEntity)par1World.getBlockTileEntity(par2, par3, par4);
			be.makePlay(par1World);
			
		}
		
		
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TTTBlockEntity();
	}
	
	@Override
	public Icon getIcon(int side, int meta) 
	{
		//System.out.println("inside getIcon with meta " + meta);
		return meta == 0 ? blockIcon : meta == 1 ? x  : o;
	}



}
