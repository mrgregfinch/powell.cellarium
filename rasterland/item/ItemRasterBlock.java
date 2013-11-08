package powell.rasterland.item;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemRasterBlock extends ItemBlock
{
	private static final String[] subNames = { "red", "orange", "yellow", "green", "blue", "purple"};

    public ItemRasterBlock(int par1) {
            super(par1);
            this.setHasSubtypes(true);
    }

    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
    @Override
    public int getMetadata(int par1) {
            return par1;
    }

    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack) {
            return getUnlocalizedName() + "." + subNames[par1ItemStack.getItemDamage()];
    }

}
