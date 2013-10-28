package powell.cellarium.item;

import net.minecraft.item.Item;

public class LogoItem extends Item
{
	public LogoItem(int id)
	{
		super(id);
		setTextureName("cellarium:cellariumLogo");
		setMaxStackSize(1);
		setUnlocalizedName("logoItem");
	}
}
