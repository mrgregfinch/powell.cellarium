package powell.cellarium.item;

import net.minecraft.item.Item;
import powell.cellarium.Cellarium;

public class BloodIngot extends Item
{
	public BloodIngot(int id)
	{
		super(id);
		setMaxStackSize(64);
		setCreativeTab(Cellarium.tabCellarium);
		setUnlocalizedName("bloodIngot");
		setTextureName("cellarium:bloodIngot");
	}
}
