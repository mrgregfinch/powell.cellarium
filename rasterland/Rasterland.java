package powell.rasterland;


import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import powell.rasterland.network.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid=ModInfo.ID, name=ModInfo.NAME, version=ModInfo.VERSION)
@NetworkMod(channels = {ModInfo.CHANNEL}, clientSideRequired=true)


public class Rasterland
{
	// The instance of your mod that Forge uses.
	@Instance(value = ModInfo.ID)
	public static Rasterland instance;

	public static CreativeTabs tabCellarium = new CreativeTabs("tabRasterland") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Block.glowStone, 1, 0);
		}
	};


	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide="powell.rasterland.network.ClientProxy", serverSide="powell.rasterland.network.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler // used in 1.6.2
	//@PreInit    // used in 1.5.2
	public void preInit(FMLPreInitializationEvent event) 
	{

	}


	@EventHandler // used in 1.6.2
	//@Init       // used in 1.5.2
	public void load(FMLInitializationEvent event) 
	{

	}

	@EventHandler // used in 1.6.2
	//@PostInit   // used in 1.5.2
	public void postInit(FMLPostInitializationEvent event) 
	{
		// Stub Method
	}
}
