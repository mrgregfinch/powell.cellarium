package powell.cellarium.item;

import net.minecraft.item.Item;
import powell.cellarium.Cellarium;

public class ReaperBlade extends Item
{
	public ReaperBlade(int id)
	{
		super(id);
		setMaxStackSize(2);
		setCreativeTab(Cellarium.tabCellarium);
		setUnlocalizedName("reaperBlade");
		setTextureName("cellarium:reaperBlade");
	}
}
