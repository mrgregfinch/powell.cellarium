package powell.rasterland.block;

import java.util.List;

import powell.rasterland.network.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockAwesomeOre extends BlockOre {

    private Icon[] blockColors = new Icon[16];

    public Block belowBlock = Block.stone;

    public BlockAwesomeOre(int par1) {
            super(par1);
            this.setLightOpacity(15);
    }

    @Override
    public Icon getIcon(int par1, int par2) {
            return blockColors[par2];
    }
    
    @Override
public boolean isBlockSolidOnSide(World world, int x, int y, int z, ForgeDirection side){
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
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
            return true;
    }

    @Override
    public boolean renderAsNormalBlock() {
            return false;
    }

    @Override
    public boolean isOpaqueCube() {
            return false;
    }

    @Override
    public int getRenderType() {
            return ClientProxy.awesomeOreRenderType;
    }

    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
            if (ClientProxy.awesomeOreRenderStage == 0) {
                    Block block = blocksList[world.getBlockId(x, y, z)];
                    if (block != null && block != this) {
                            return block.getLightValue(world, x, y, z);
                    }
                    return lightValue[blockID];
            } else {
                    return 15;
            }
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood
     * returns 4 blocks)
     */
    @Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
            par3List.add(new ItemStack(par1, 1, 0));
            par3List.add(new ItemStack(par1, 1, 1));
            par3List.add(new ItemStack(par1, 1, 2));
            par3List.add(new ItemStack(par1, 1, 3));
            par3List.add(new ItemStack(par1, 1, 4));
            par3List.add(new ItemStack(par1, 1, 5));
            par3List.add(new ItemStack(par1, 1, 6));
            par3List.add(new ItemStack(par1, 1, 7));
            par3List.add(new ItemStack(par1, 1, 8));
            par3List.add(new ItemStack(par1, 1, 9));
            par3List.add(new ItemStack(par1, 1, 10));
            par3List.add(new ItemStack(par1, 1, 11));
            par3List.add(new ItemStack(par1, 1, 12));
            par3List.add(new ItemStack(par1, 1, 13));
            par3List.add(new ItemStack(par1, 1, 14));
            par3List.add(new ItemStack(par1, 1, 15));
    }

    @Override
    public int damageDropped(int par1) {
            return par1;
    }

    /**
     * When this method is called, your block should register all the icons it
     * needs with the given IconRegister. This is the only chance you get to
     * register icons.
     */
    @Override
    public void registerIcons(IconRegister par1IconRegister) {
            blockColors[0] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreWhite");
            blockColors[1] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreOrange");
            blockColors[2] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreMagenta");
            blockColors[3] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreLBlue");
            blockColors[4] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreYellow");
            blockColors[5] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreLime");
            blockColors[6] = par1IconRegister.registerIcon("rasterland:awesomeOrePink");
            blockColors[7] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreGray");
            blockColors[8] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreLGray");
            blockColors[9] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreCyan");
            blockColors[10] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOrePurple");
            blockColors[11] = par1IconRegister.registerIcon("rasterland:awesomeOreBlue");
            blockColors[12] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreBrown");
            blockColors[13] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreGreen");
            blockColors[14] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreRed");
            blockColors[15] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreBlack");
    }


}
