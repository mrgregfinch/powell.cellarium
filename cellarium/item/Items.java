package powell.cellarium.item;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Property;
import powell.cellarium.Cellarium;
import powell.cellarium.CellariumConfiguration;
import powell.cellarium.DefaultProps;

public class Items
{
	public static Item reaperHilt;
	public static Item reaperBlade;
	public static Item theReaper;
	public static Item sorrowfelHilt;
	public static Item sorrowfelBlade;
	public static Item sorrowfel;
	public static Item ingotFrame;
	public static Item tearsIngot;
	
	public static void init(CellariumConfiguration main)
	{
		Property reaperHiltId = main.getItem("reaperHilt.id", DefaultProps.REAPER_HILT);		
		reaperHilt = new ReaperHilt(reaperHiltId.getInt());
		
		Property reaperBladeId = main.getItem("repaerBlade.id", DefaultProps.REAPER_BLADE);
		reaperBlade = new ReaperBlade(reaperBladeId.getInt());
		
		Property theReaperId = main.getItem("theReaper.id", DefaultProps.THE_REAPER);
		theReaper = new TheReaper(theReaperId.getInt());
		
		Property sorrowfelHiltId = main.getItem("sorrowfelHilt.id", DefaultProps.SORROWFEL_HILT);		
		sorrowfelHilt = new SorrowfelHilt(sorrowfelHiltId.getInt());
		
		Property sorrowfelBladeId = main.getItem("sorrowfelBlade.id", DefaultProps.SORROWFEL_BLADE);
		sorrowfelBlade = new SorrowfelBlade(sorrowfelBladeId.getInt());
		
		Property ingotFrameId = main.getItem("ingotFrame.id", DefaultProps.INGOT_FRAME);
		ingotFrame = new IngotFrame(ingotFrameId.getInt());
		
		Property tearsIngotId = main.getItem("tearsIngot.id", DefaultProps.TEARS_INGOT);
		tearsIngot = new TearsIngot(tearsIngotId.getInt());
	}
	
	public static void load()
	{
		GameRegistry.registerItem(reaperHilt, "reaperHilt");
        LanguageRegistry.addName(reaperHilt, "Hilt of The Reaper");
        
        GameRegistry.registerItem(reaperBlade, "reaperBlade");
        LanguageRegistry.addName(reaperBlade, "Blade of The Reaper");
        
        GameRegistry.registerItem(theReaper, "theReaper");
        LanguageRegistry.addName(theReaper, "The Reaper");
        
        GameRegistry.registerItem(sorrowfelHilt, "sorrowfelHilt");
        LanguageRegistry.addName(sorrowfelHilt, "The Hilt of Sorrowfel");
        
        GameRegistry.registerItem(sorrowfelBlade, "sorrowfelBlade");
        LanguageRegistry.addName(sorrowfelBlade, "The Blade of Sorrowfel");
        
        GameRegistry.registerItem(ingotFrame, "ingotFrame");
        LanguageRegistry.addName(ingotFrame, "Obsidian Ingot Frame");
        
        GameRegistry.registerItem(tearsIngot, "tearsIngot");
        LanguageRegistry.addName(tearsIngot, "Ingot of Children's Tears");
	}
	
	public static void createRecipes()
	{
		 ItemStack obsidianStack = new ItemStack(Block.obsidian);
	     ItemStack bloodIngotStack = new ItemStack(Cellarium.bloodIngot);
	     ItemStack boneStack = new ItemStack(Item.bone);
	     ItemStack tearsIngotStack = new ItemStack(tearsIngot);

	     GameRegistry.addRecipe(new ItemStack(reaperHilt), 	"w  ",
	    		 											" w ", 
	    		 											"x w",
	                'x', obsidianStack, 'w', boneStack);
	     
	     GameRegistry.addRecipe(new ItemStack(reaperBlade),	"  x",
	    		 											" x ", 
	    		 											"   ",
	    		 	'x', bloodIngotStack);
	     
	     GameRegistry.addRecipe(new ItemStack(theReaper), 	"  y",
	    		 											" y ", 
	    		 											"x  ",
	                'x', new ItemStack(reaperHilt), 'y', new ItemStack(reaperBlade));
	     
	     GameRegistry.addRecipe(new ItemStack(sorrowfelBlade),	"  x",
	    		 												" x ", 
	    		 												"   ",
	    		 	'x', tearsIngotStack);
	}
}
