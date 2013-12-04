package powell.games.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import powell.games.Games;
import powell.games.entity.TTTEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TTTItem extends Item
{
	public TTTItem(int par1)
	{
		super(par1);
		this.maxStackSize = 1;
		this.setCreativeTab(Games.tabGames);
		this.setUnlocalizedName("tttItem");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister)//updateIcons
	{
		this.itemIcon = iconRegister.registerIcon("games:tictactoe");
	}


//	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer player)
//	{
//
//		return par1ItemStack;
//
//
//	}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        int i1 = par3World.getBlockId(par4, par5, par6);
        
        System.out.println("Block id is " + i1);
        par3World.spawnEntityInWorld(new TTTEntity(par3World, par4, par5 + 1, par6));
        
        return true;

//        if (i1 == Block.snow.blockID && (par3World.getBlockMetadata(par4, par5, par6) & 7) < 1)
//        {
//            par7 = 1;
//        }
//        else if (i1 != Block.vine.blockID && i1 != Block.tallGrass.blockID && i1 != Block.deadBush.blockID)
//        {
//            if (par7 == 0)
//            {
//                --par5;
//            }
//
//            if (par7 == 1)
//            {
//                ++par5;
//            }
//
//            if (par7 == 2)
//            {
//                --par6;
//            }
//
//            if (par7 == 3)
//            {
//                ++par6;
//            }
//
//            if (par7 == 4)
//            {
//                --par4;
//            }
//
//            if (par7 == 5)
//            {
//                ++par4;
//            }
//        }
//
//        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
//        {
//            return false;
//        }
//        else if (par1ItemStack.stackSize == 0)
//        {
//            return false;
//        }
//        else
//        {
//            if (par3World.canPlaceEntityOnSide(this.spawnID, par4, par5, par6, false, par7, (Entity)null, par1ItemStack))
//            {
//                Block block = Block.blocksList[this.spawnID];
//                int j1 = block.onBlockPlaced(par3World, par4, par5, par6, par7, par8, par9, par10, 0);
//
//                if (par3World.setBlock(par4, par5, par6, this.spawnID, j1, 3))
//                {
//                    if (par3World.getBlockId(par4, par5, par6) == this.spawnID)
//                    {
//                        Block.blocksList[this.spawnID].onBlockPlacedBy(par3World, par4, par5, par6, par2EntityPlayer, par1ItemStack);
//                        Block.blocksList[this.spawnID].onPostBlockPlaced(par3World, par4, par5, par6, j1);
//                    }
//
//                    par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block.stepSound.getPlaceSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
//                    --par1ItemStack.stackSize;
//                }
//            }
//
//            return true;
//        }
    }
}