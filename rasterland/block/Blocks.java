package powell.rasterland.block;

import powell.rasterland.Rasterland;
import powell.rasterland.item.ItemRasterBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;



public class Blocks
{
	public static Block blockTeleporter;
	public static Block blockTeleporterFire;
	public static Block awesomeOre;
	public static Block rasterBlock;
	
	private static final String[] awesomeColors = { "White", "Orange", "Magenta", "Light-Blue", "Yellow", "Lime", "Pink", "Gray", "Light-Gray", "Cyan", "Purple", "Blue", "Brown", "Green", "Red", "Black" };
	private static final String[] RASTER_COLOR_NAMES = { "red", "orange", "yellow", "green", "blue", "purple"};


	
	public static void init()
	{
		blockTeleporter = new BlockTeleporter(2000);
		awesomeOre = new BlockAwesomeOre(3587).setHardness(5F).setResistance(5F).setCreativeTab(Rasterland.tabRasterland).setUnlocalizedName("AwesomeOre");
        
		rasterBlock = new RasterBlock(3588).setHardness(5F).setResistance(5F).setCreativeTab(Rasterland.tabRasterland).setUnlocalizedName("rasterBlock");
		
	}
	
	public static void load()
	{
		GameRegistry.registerBlock(blockTeleporter, "blockTeleporter");
		LanguageRegistry.addName(blockTeleporter, "Block for Teleportation");
		
		GameRegistry.registerBlock(awesomeOre, ItemAwesomeOre.class ,"awesomeOre");
		 for (int i = 0; i < 16; i++) 
             LanguageRegistry.addName(new ItemStack(awesomeOre, 1, i), awesomeColors[new ItemStack(awesomeOre, 1, i).getItemDamage()] + " Neon Ore");
        
		GameRegistry.registerBlock(rasterBlock, ItemRasterBlock.class, "rasterBlock");
		for(int i = 0; i < 6; i++)
			LanguageRegistry.addName(new ItemStack(rasterBlock, 1, i), RASTER_COLOR_NAMES[new ItemStack(rasterBlock, 1, i).getItemDamage()] + "Raster Block");
         
	}
}
