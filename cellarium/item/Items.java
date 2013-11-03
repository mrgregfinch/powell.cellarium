package powell.cellarium.item;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Property;
import powell.cellarium.CellariumConfiguration;
import powell.cellarium.DefaultProps;

public class Items
{
	public static Item reaperHilt;
	
	public static void init(CellariumConfiguration main)
	{
		Property reaperHiltId = main.getItem("reaperHilt.id", DefaultProps.REAPER_HILT);
		
		reaperHilt = new ReaperHilt(reaperHiltId.getInt());
	}
	
	public static void load()
	{
		GameRegistry.registerItem(reaperHilt, "reaperHilt");
        LanguageRegistry.addName(reaperHilt, "Hilt for The Reaper");
	}
	
	public static void createRecipes()
	{
		 ItemStack obsidianStack = new ItemStack(Block.obsidian);
	     //ItemStack bloodIngotStack = new ItemStack(bloodIngot);
	     ItemStack boneStack = new ItemStack(Item.bone);

	     GameRegistry.addRecipe(new ItemStack(reaperHilt), 	"w  ",
	    		 											" w ", 
	    		 											"x w",
	                'x', obsidianStack, 'w', boneStack);
	}
}
