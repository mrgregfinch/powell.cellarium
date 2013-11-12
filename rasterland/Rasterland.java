package powell.rasterland;


import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.DimensionManager;
import powell.rasterland.biome.Biomes;
import powell.rasterland.block.Blocks;
import powell.rasterland.fluids.Fluids;
import powell.rasterland.item.Items;
import powell.rasterland.network.CommonProxy;
import powell.rasterland.world.RasterlandWorldProvider;
import powell.rasterland.world.WorldProviderVoid;
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

	public static CreativeTabs tabRasterland = new CreativeTabs("tabRasterland") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Block.glowStone, 1, 0);
		}
	};

	public static final int DIMENSIONID = 7;
	
	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide="powell.rasterland.network.ClientProxy", serverSide="powell.rasterland.network.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler // used in 1.6.2
	//@PreInit    // used in 1.5.2
	public void preInit(FMLPreInitializationEvent event) 
	{
		proxy.preInit();
		Fluids.init();
		Blocks.init();
		Items.init();
		Biomes.preInit();
	}


	@EventHandler // used in 1.6.2
	//@Init       // used in 1.5.2
	public void load(FMLInitializationEvent event) 
	{
		Fluids.load();
		Blocks.load();
		Items.load();
		Biomes.load();
		
		//LanguageRegistry.addName(tabRasterland,"Rasterland");
		
		//DimensionManager.registerProviderType(DIMENSIONID, WorldProviderVoid.class, false);//original working (1 biome)
		DimensionManager.registerProviderType(DIMENSIONID, RasterlandWorldProvider.class, false);
		DimensionManager.registerDimension(DIMENSIONID, DIMENSIONID);
	}

	@EventHandler // used in 1.6.2
	//@PostInit   // used in 1.5.2
	public void postInit(FMLPostInitializationEvent event) 
	{
		// Stub Method
	}
}
