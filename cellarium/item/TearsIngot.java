package powell.cellarium.item;

import net.minecraft.item.Item;
import powell.cellarium.Cellarium;

public class TearsIngot extends Item
{
	public TearsIngot(int id)
	{
		super(id);
		setMaxStackSize(64);
		setCreativeTab(Cellarium.tabCellarium);
		setUnlocalizedName("tearsIngot");
		setTextureName("cellarium:tearsIngot");
	}
}