package powell.cellarium.item;

import net.minecraft.item.Item;
import powell.cellarium.Cellarium;

public class SorrowfelHilt extends Item
{
	public SorrowfelHilt(int id)
	{
		super(id);
		setMaxStackSize(1);
		setCreativeTab(Cellarium.tabCellarium);
		setUnlocalizedName("sorrowfelHilt");
		setTextureName("cellarium:sorrowfelHilt");
	}
}
