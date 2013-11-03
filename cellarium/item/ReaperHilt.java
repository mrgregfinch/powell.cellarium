package powell.cellarium.item;

import powell.cellarium.Cellarium;
import net.minecraft.item.Item;

public class ReaperHilt extends Item
{
	public ReaperHilt(int id)
	{
		super(id);
		setMaxStackSize(1);
		setCreativeTab(Cellarium.tabCellarium);
		setUnlocalizedName("reaperHilt");
		setTextureName("cellarium:hilt_theReaper");
	}
}
