package powell.cellarium;

import powell.cellarium.block.BlockVoid;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraftforge.common.MinecraftForge;
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
	// The instance of your mod that Forge uses.
	@Instance(value = "CellariumID")
	public static Cellarium instance;
	
	//Block List
	public static Block blockVoid;
	//End Block List
	
	//trying custom tab
	public static CreativeTabs tabCellarium = new CreativeTabs("tabCellarium") {
        public ItemStack getIconItemStack() {
                return new ItemStack(Item.eyeOfEnder, 1, 0);
        }
};
	//end tab

	//register block
	public void registerBlock(Block block, String string, String name, String tool, int level){
		GameRegistry.registerBlock(block, string);
		LanguageRegistry.addName(block, name);
		MinecraftForge.setBlockHarvestLevel(block, tool, level);
	}
	//register Item
	public void registerItem(Item item, String string, String name){
		GameRegistry.registerItem(item, string);
		LanguageRegistry.addName(item, name);
	}
	
	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide="powell.cellarium.client.ClientProxy", serverSide="powell.cellarium.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler // used in 1.6.2
	public void preInit(FMLPreInitializationEvent event) 
	{
		//Block Creation
		//Create Void Block
		blockVoid = new BlockVoid(4000, Material.ground);
		//End Block Creation
		
		// Stub Method
	}

	@EventHandler // used in 1.6.2
	public void load(FMLInitializationEvent event) 
	{
		proxy.registerRenderers();
		
		//Sets name for Custom Tab
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabCellarium", "en_US", "Cellarium");
		
		//Block Registration List
		//void block registration
		registerBlock(blockVoid, blockVoid.getUnlocalizedName(), "Block O Void", null, 0); 
		//End Block Registration List
	}

	@EventHandler // used in 1.6.2
	public void postInit(FMLPostInitializationEvent event) 
	{
		// Stub Method
	}
}
