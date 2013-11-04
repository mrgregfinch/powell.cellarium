package powell.cellarium.item;

import net.minecraft.item.Item;
import powell.cellarium.Cellarium;

public class IngotFrame extends Item
{
	public IngotFrame(int id)
	{
		super(id);
		setMaxStackSize(64);
		setCreativeTab(Cellarium.tabCellarium);
		setUnlocalizedName("ingotFrame");
		setTextureName("cellarium:ingotFrame");
	}

}
