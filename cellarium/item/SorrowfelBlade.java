package powell.cellarium.item;

import net.minecraft.item.Item;
import powell.cellarium.Cellarium;

public class SorrowfelBlade extends Item
{
	public SorrowfelBlade(int id)
	{
		super(id);
		setMaxStackSize(2);
		setCreativeTab(Cellarium.tabCellarium);
		setUnlocalizedName("sorrowfelBlade");
		setTextureName("cellarium:sorrowfelBlade");
	}
}
