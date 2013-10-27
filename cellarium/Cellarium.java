package powell.cellarium;

import java.util.logging.Logger;
import java.io.*;
import powell.cellarium.block.BlockBlood;
import powell.cellarium.block.BlockBoilingBlood;
import powell.cellarium.block.BlockTearsOfChildren;
import powell.cellarium.block.BloodOre;
import powell.cellarium.block.BloodStone;
import powell.cellarium.block.PresenceOfPowell;
import powell.cellarium.fluids.Blood;
import powell.cellarium.fluids.BoilingBlood;
import powell.cellarium.fluids.TearsOfChildren;
import powell.cellarium.item.BloodIngot;
import powell.cellarium.item.BucketOfBlood;
import powell.cellarium.item.BucketOfBoilingBlood;
import powell.cellarium.item.BucketOfTears;
import powell.cellarium.item.LogoItem;
import powell.cellarium.item.TheReaper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.ItemFluidContainer;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
//import cpw.mods.fml.common.Mod.PreInit;    // used in 1.5.2
//import cpw.mods.fml.common.Mod.Init;       // used in 1.5.2
//import cpw.mods.fml.common.Mod.PostInit;   // used in 1.5.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="CellariumID", name="Cellarium", version="0.0.0")
@NetworkMod(clientSideRequired=true)

public class Cellarium 
{
	//public static boolean displayclear = true;
	
	public static CellariumConfiguration mainConfiguration;
	public static final Logger cLog = Logger.getLogger("Cellarium");
	//Custom Fluids/Blocks/Items
	public static Fluid tearsOfChildren;
	public static Fluid blood;
	public static Fluid boilingBlood;
	
	public static BlockFluidClassic blockTearsOfChildren;
	public static BlockFluidClassic blockBlood;
	public static BlockFluidClassic blockBoilingBlood;
	
	public static Block genericDirt;
	public static Block bloodStone;
	public static Block bloodOre;
	public static Block presenceOfPowell;
	
	public static ItemFluidContainer bucketOfTears;
	public static ItemFluidContainer bucketOfBlood;
	public static ItemFluidContainer bucketOfBoilingBlood;
	
	public static Item bloodIngot;
	public static Item logoItem;
	public static Item theReaper;
	
	//end Custom
	
	// The instance of your mod that Forge uses.
	@Instance(value = "CellariumID")
	public static Cellarium instance;
	
	//trying custom tab
	public static CreativeTabs tabCellarium = new CreativeTabs("tabCellarium") {
        public ItemStack getIconItemStack() {
                return new ItemStack(logoItem, 1, 0);
        }
};
	//end tab

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide="powell.cellarium.client.ClientProxy", serverSide="powell.cellarium.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler // used in 1.6.2
	//@PreInit    // used in 1.5.2
	public void preInit(FMLPreInitializationEvent event) 
	{
		
		cLog.setParent(FMLLog.getLogger());
		cLog.info("Starting Cellarium " /*+ add verison info here in future*/);
		cLog.info("Copyright (c) Danickar, 2013");
		
		mainConfiguration = new CellariumConfiguration(new File(event.getModConfigurationDirectory(), "Cellarium/main.conf"));
		try 
		{
			mainConfiguration.load();
		
		
		
		}
		finally 
		{
			if (mainConfiguration.hasChanged()) 
			{
				mainConfiguration.save();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		// Stub Method
		//Create Fluids First
		tearsOfChildren = new TearsOfChildren();
		blood = new Blood();
		boilingBlood = new BoilingBlood();
		//end Fluids
		//create Blocks
		blockTearsOfChildren = (BlockFluidClassic) new BlockTearsOfChildren(777).setUnlocalizedName("blockTearsOfChildren").setCreativeTab(tabCellarium);
		blockBlood = (BlockFluidClassic) new BlockBlood(775).setUnlocalizedName("blockBlood").setCreativeTab(tabCellarium);
		blockBoilingBlood = (BlockFluidClassic) new BlockBoilingBlood(773).setUnlocalizedName("blockBoilingBlood").setCreativeTab(tabCellarium);
		
		genericDirt = new GenericBlock(500, Material.ground)
        .setHardness(0.5F).setStepSound(Block.soundGravelFootstep)
        .setUnlocalizedName("genericDirt").setCreativeTab(tabCellarium);
		
		presenceOfPowell = new PresenceOfPowell(790);
		
		bloodStone = new BloodStone(791);
		bloodOre = new BloodOre(792);
		
		//end Blocks
		//create Items
		bucketOfTears = (ItemFluidContainer) new BucketOfTears(778,777).setUnlocalizedName("bucketOfTears").setCreativeTab(tabCellarium);
		bucketOfBlood = (ItemFluidContainer) new BucketOfBlood(776,775).setUnlocalizedName("bucketOfBlood").setCreativeTab(tabCellarium);
		bucketOfBoilingBlood = (ItemFluidContainer) new BucketOfBoilingBlood(774,773).setUnlocalizedName("bucketOfBoilingBlood").setCreativeTab(tabCellarium);
		
		bloodIngot = new BloodIngot(7777);
		logoItem = new LogoItem(7778);
		theReaper = new TheReaper(7800);
		//end Items
	}

	@EventHandler // used in 1.6.2
	//@Init       // used in 1.5.2
	public void load(FMLInitializationEvent event) 
	{
		proxy.registerRenderers();
		//Sets name for Custom Tab
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabCellarium", "en_US", "Cellarium");
		//LanguageRegistry.addName(tearsOfChildren, "Tears of Children"); //seems to cause a NullPointer Exception
		
		
		LanguageRegistry.addName(blockTearsOfChildren, "Tears Of Children");
		LanguageRegistry.addName(blockBlood, "Blood");
		LanguageRegistry.addName(blockBoilingBlood, "Boiling Blood");
		
		GameRegistry.registerBlock(blockTearsOfChildren, "blockTearsOfChildren");
		GameRegistry.registerBlock(blockBlood, "blockBlood");
		GameRegistry.registerBlock(blockBoilingBlood,"blockBoilingBlood");
		
		LanguageRegistry.addName(genericDirt, "Generic Dirt");
        MinecraftForge.setBlockHarvestLevel(genericDirt, "shovel", 0);
        GameRegistry.registerBlock(genericDirt, "genericDirt");
        
        GameRegistry.registerItem(bucketOfTears, "bucketOfTears");
        LanguageRegistry.addName(bucketOfTears, "Bucket of Tears");
        
        GameRegistry.registerItem(bucketOfBlood, "bucketOfBlood");
        LanguageRegistry.addName(bucketOfBlood, "Bucket Of Blood");
        
        GameRegistry.registerItem(bucketOfBoilingBlood, "bucketOfBoilingBlood");
        LanguageRegistry.addName(bucketOfBoilingBlood, "Bucket of Boiling Blood");
        
        GameRegistry.registerBlock(presenceOfPowell, "presenceOfPowell");
        LanguageRegistry.addName(presenceOfPowell, "Presence of Powell");
        
        GameRegistry.registerBlock(bloodStone,"bloodStone");
        LanguageRegistry.addName(bloodStone, "Blood Stone");
        MinecraftForge.setBlockHarvestLevel(bloodStone, "pickaxe", 3);
        
        GameRegistry.registerBlock(bloodOre, "bloodOre");
        LanguageRegistry.addName(bloodOre, "Blood Ore");
        MinecraftForge.setBlockHarvestLevel(bloodOre, "pickaxe", 3);
        
        GameRegistry.registerItem(bloodIngot, "bloodIngot");
        LanguageRegistry.addName(bloodIngot, "Blood Ingot");
        FurnaceRecipes.smelting().addSmelting(bloodOre.blockID, new ItemStack(bloodIngot), 1.0f);
        
        GameRegistry.registerItem(logoItem, "logoItem");
        LanguageRegistry.addName(logoItem, "Logo Item");
        
        GameRegistry.registerItem(theReaper, "theReaper");
        LanguageRegistry.addName(theReaper, "The Reaper");
        
        
        
        //Recipe Section
        ItemStack obsidianStack = new ItemStack(Block.obsidian);
        ItemStack bloodIngotStack = new ItemStack(bloodIngot);

        GameRegistry.addRecipe(new ItemStack(theReaper), " y ", "xyx", " x ",
                'x', obsidianStack, 'y', bloodIngotStack);
        //end Recipes
        
        //FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack(Cellarium.tearsOfChildren.getUnlocalizedName(), FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketOfTears), new ItemStack(Item.bucketEmpty));
		
	}

	@EventHandler // used in 1.6.2
	//@PostInit   // used in 1.5.2
	public void postInit(FMLPostInitializationEvent event) 
	{
		// Stub Method
	}
}
