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
	public static Item ingotFrame;
	public static Item tearsIngot;
	
	public static void init(CellariumConfiguration main)
	{
		Property reaperHiltId = main.getItem("reaperHilt.id", DefaultProps.REAPER_HILT);		
		reaperHilt = new ReaperHilt(reaperHiltId.getInt());
		
		Property ingotFrameId = main.getItem("ingotFrame.id", DefaultProps.INGOT_FRAME);
		ingotFrame = new IngotFrame(ingotFrameId.getInt());
		
		Property tearsIngotId = main.getItem("tearsIngot.id", DefaultProps.TEARS_INGOT);
		tearsIngot = new TearsIngot(tearsIngotId.getInt());
	}
	
	public static void load()
	{
		GameRegistry.registerItem(reaperHilt, "reaperHilt");
        LanguageRegistry.addName(reaperHilt, "Hilt for The Reaper");
        
        GameRegistry.registerItem(ingotFrame, "ingotFrame");
        LanguageRegistry.addName(ingotFrame, "Obsidian Ingot Frame");
        
        GameRegistry.registerItem(tearsIngot, "tearsIngot");
        LanguageRegistry.addName(tearsIngot, "Ingot of Children's Tears");
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
