package powell.rasterland;


import java.util.EnumSet;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import powell.rasterland.biome.Biomes;
import powell.rasterland.block.Blocks;
import powell.rasterland.entity.Entities;
import powell.rasterland.event.RasterizedPlayerEventHandler;
import powell.rasterland.fluids.Fluids;
import powell.rasterland.gui.EnergyBarGui;
import powell.rasterland.item.Items;
import powell.rasterland.keyhandler.RasterBikeKeyHandler;
import powell.rasterland.keyhandler.RasterPlayerTickHandler;
import powell.rasterland.network.CommonProxy;
import powell.rasterland.network.RasterlandPacketHandler;
import powell.rasterland.world.RasterWorldStructureGenerator;
import powell.rasterland.world.RasterlandWorldProvider;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid=ModInfo.ID, name=ModInfo.NAME, version=ModInfo.VERSION)
@NetworkMod(channels = {"rasterlandChan", "rasterizedPlayer"}, clientSideRequired=true, serverSideRequired = true, 
		packetHandler = RasterlandPacketHandler.class)


public class Rasterland
{
	// The instance of your mod that Forge uses.
	@Instance(value = ModInfo.ID)
	public static Rasterland instance;

	public static CreativeTabs tabRasterland = new CreativeTabs("tabRasterland") 
	{
		public ItemStack getIconItemStack() 
		{
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
		MinecraftForge.EVENT_BUS.register(new RasterizedPlayerEventHandler());
		
		Fluids.load();
		Blocks.load();
		Blocks.registerTileEntities();
		Items.load();
		Biomes.load();
		Entities.init();
		
		//LanguageRegistry.addName(tabRasterland,"Rasterland");
		
		//DimensionManager.registerProviderType(DIMENSIONID, WorldProviderVoid.class, false);//original working (1 biome)
		DimensionManager.registerProviderType(DIMENSIONID, RasterlandWorldProvider.class, false);
		DimensionManager.registerDimension(DIMENSIONID, DIMENSIONID);
		GameRegistry.registerWorldGenerator(new RasterWorldStructureGenerator());
		
		proxy.registerRenderers();
		
		
		
		//test key code
//		KeyBinding[] key = {new KeyBinding("Name of Key", Minecraft.getMinecraft().gameSettings.keyBindRight.keyCode)};
//		boolean[] repeat = {false};
//		KeyBindingRegistry.registerKeyBinding(new RasterBikeKeyHandler(key, repeat));
//		
//		TickRegistry.registerTickHandler(new RasterPlayerTickHandler(EnumSet.of(TickType.PLAYER)), Side.SERVER);
	}

	@EventHandler // used in 1.6.2
	//@PostInit   // used in 1.5.2
	public void postInit(FMLPostInitializationEvent event) 
	{
		// Stub Method
		if (FMLCommonHandler.instance().getEffectiveSide().isClient())
			MinecraftForge.EVENT_BUS.register(new EnergyBarGui(Minecraft.getMinecraft()));

	}
}
