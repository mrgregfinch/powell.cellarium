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
	//public static Block awesomeOre;
	//public static Block rasterBlock;
	public static Block redRasterBlock;
	public static Block orangeRasterBlock;
	public static Block yellowRasterBlock;
	public static Block greenRasterBlock;
	public static Block blueRasterBlock;
	public static Block purpleRasterBlock;
	public static Block blackRasterBlock;
	public static Block whiteRasterBlock;
	
	public static Block redRasterBrick;
	public static Block orangeRasterBrick;
	public static Block yellowRasterBrick;
	public static Block greenRasterBrick;
	public static Block blueRasterBrick;
	public static Block purpleRasterBrick;
	
	public static Block blueRasterDirt;
	public static Block testBlock;
	
	public static Block rasterWallBase;
	public static Block rasterWall;

	//private static final String[] awesomeColors = { "White", "Orange", "Magenta", "Light-Blue", "Yellow", "Lime", "Pink", "Gray", "Light-Gray", "Cyan", "Purple", "Blue", "Brown", "Green", "Red", "Black" };
	private static final String[] RASTER_COLOR_NAMES = { "red", "orange", "yellow", "green", "blue", "purple"};



	public static void init()
	{
		blockTeleporter = new BlockTeleporter(2000);
		//awesomeOre = new BlockAwesomeOre(3587).setHardness(5F).setResistance(5F).setCreativeTab(Rasterland.tabRasterland).setUnlocalizedName("AwesomeOre");

		//	rasterBlock = new RasterBlock(211).setHardness(5F).setResistance(5F).setCreativeTab(Rasterland.tabRasterland).setUnlocalizedName("rasterBlock");
		redRasterBlock = new RedRasterBlock(211);
		orangeRasterBlock = new OrangeRasterBlock(212);
		yellowRasterBlock = new YellowRasterBlock(213);
		greenRasterBlock = new GreenRasterBlock(214);
		blueRasterBlock = new BlueRasterBlock(215);
		purpleRasterBlock = new PurpleRasterBlock(216);
		
		redRasterBrick = new RedRasterBrick(217);
		orangeRasterBrick = new OrangeRasterBrick(218);
		yellowRasterBrick = new YellowRasterBrick(219);
		greenRasterBrick = new GreenRasterBrick(220);
		blueRasterBrick = new BlueRasterBrick(221);
		purpleRasterBrick = new PurpleRasterBrick(222);
		
		blueRasterDirt = new BlueRasterDirt(223);
		blackRasterBlock = new BlackRasterBlock(224);
		whiteRasterBlock = new WhiteRasterBlock(225);
		
		testBlock = new TestBlock(226);
		rasterWallBase = new RasterWallBase(1946);
		rasterWall = new RasterWall(1947, rasterWallBase);
	}

	public static void load()
	{
		GameRegistry.registerBlock(blockTeleporter, "blockTeleporter");
		LanguageRegistry.addName(blockTeleporter, "Block for Teleportation");

//		GameRegistry.registerBlock(awesomeOre, ItemAwesomeOre.class ,"awesomeOre");
//		for (int i = 0; i < 16; i++) 
//			LanguageRegistry.addName(new ItemStack(awesomeOre, 1, i), awesomeColors[new ItemStack(awesomeOre, 1, i).getItemDamage()] + " Neon Ore");

		//		GameRegistry.registerBlock(rasterBlock, ItemRasterBlock.class, "rasterBlock");
		//		for(int i = 0; i < 6; i++)
		//			LanguageRegistry.addName(new ItemStack(rasterBlock, 1, i), RASTER_COLOR_NAMES[new ItemStack(rasterBlock, 1, i).getItemDamage()] + "Raster Block");


		GameRegistry.registerBlock(redRasterBlock,"redRasterBlock");
		LanguageRegistry.addName(redRasterBlock, "Red Raster Block"); 
		
		GameRegistry.registerBlock(orangeRasterBlock,"orangeRasterBlock");
		LanguageRegistry.addName(orangeRasterBlock, "Orange Raster Block");
		
		GameRegistry.registerBlock(yellowRasterBlock,"yellowRasterBlock");
		LanguageRegistry.addName(yellowRasterBlock, "Yellow Raster Block");
		
		GameRegistry.registerBlock(greenRasterBlock,"greenRasterBlock");
		LanguageRegistry.addName(greenRasterBlock, "Green Raster Block");
		
		GameRegistry.registerBlock(blueRasterBlock,"blueRasterBlock");
		LanguageRegistry.addName(blueRasterBlock, "Blue Raster Block");

		GameRegistry.registerBlock(purpleRasterBlock,"purpleRasterBlock");
		LanguageRegistry.addName(purpleRasterBlock, "Purple Raster Block");
		
		GameRegistry.registerBlock(redRasterBrick, "redRasterBrick");
		LanguageRegistry.addName(redRasterBrick, "Red Raster Brick");
		
		GameRegistry.registerBlock(orangeRasterBrick, "orangeRasterBrick");
		LanguageRegistry.addName(orangeRasterBrick, "Orange Raster Brick");
		
		GameRegistry.registerBlock(yellowRasterBrick, "yellowRasterBrick");
		LanguageRegistry.addName(yellowRasterBrick, "Yellow Raster Brick");
		
		GameRegistry.registerBlock(greenRasterBrick, "greenRasterBrick");
		LanguageRegistry.addName(greenRasterBrick, "Green Raster Brick");
		
		GameRegistry.registerBlock(blueRasterBrick, "blueRasterBrick");
		LanguageRegistry.addName(blueRasterBrick, "Blue Raster Brick");
		
		GameRegistry.registerBlock(purpleRasterBrick, "purpleRasterBrick");
		LanguageRegistry.addName(purpleRasterBrick, "Purple Raster Brick");
		
		GameRegistry.registerBlock(blueRasterDirt,"blueRasterDirt");
		LanguageRegistry.addName(blueRasterDirt,"Blue Raster Dirt");
		
		GameRegistry.registerBlock(blackRasterBlock,"blackRasterBlock");
		LanguageRegistry.addName(blackRasterBlock, "Black Raster Block");
		
		GameRegistry.registerBlock(whiteRasterBlock,"whiteRasterBlock");
		LanguageRegistry.addName(whiteRasterBlock,"White Raster Block");
		
		GameRegistry.registerBlock(testBlock,"testBlock");
		LanguageRegistry.addName(testBlock,"Test Block");
		
		GameRegistry.registerBlock(rasterWallBase, "rasterWallBase");
		LanguageRegistry.addName(rasterWallBase, "Raster Wall Base");
		
		GameRegistry.registerBlock(rasterWall, "rasterWall");
		LanguageRegistry.addName(rasterWall, "Raster Wall");
	}
}
