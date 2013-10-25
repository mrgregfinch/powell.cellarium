package powell.cellarium;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="CellariumID", name="Cellarium", version="0.0.0")
@NetworkMod(clientSideRequired=true)

public class Cellarium 
{
	// The instance of your mod that Forge uses.
	@Instance(value = "CellariumID")
	public static Cellarium instance;
	
	//trying custom tab
	public static CreativeTabs tabCellarium = new CreativeTabs("tabCellarium") {
        public ItemStack getIconItemStack() {
                return new ItemStack(Item.eyeOfEnder, 1, 0);
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
		// Stub Method
	}

	@EventHandler // used in 1.6.2
	//@Init       // used in 1.5.2
	public void load(FMLInitializationEvent event) 
	{
		proxy.registerRenderers();
		//Sets name for Custom Tab
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabCellarium", "en_US", "Cellarium");
	}

	@EventHandler // used in 1.6.2
	//@PostInit   // used in 1.5.2
	public void postInit(FMLPostInitializationEvent event) 
	{
		// Stub Method
	}
}
