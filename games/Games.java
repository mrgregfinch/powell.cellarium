package powell.games;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import powell.games.item.Items;
import powell.games.network.CommonProxy;
import powell.games.block.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid=ModInfo.ID, name=ModInfo.NAME, version=ModInfo.VERSION)
@NetworkMod(channels = {"gamesChannel"}, clientSideRequired=true, serverSideRequired = true)


public class Games
{
	// The instance of your mod that Forge uses.
	@Instance(value = ModInfo.ID)
	public static Games instance;

	public static CreativeTabs tabGames = new CreativeTabs("tabGames") 
	{
		public ItemStack getIconItemStack() 
		{
			return new ItemStack(Block.glowStone, 1, 0);
		}
	};

	public static final int DIMENSIONID = 7;

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide="powell.games.network.ClientProxy", serverSide="powell.games.network.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler // used in 1.6.2
	//@PreInit    // used in 1.5.2
	public void preInit(FMLPreInitializationEvent event) 
	{
		Items.init();
		Blocks.init();
	}


	@EventHandler // used in 1.6.2
	//@Init       // used in 1.5.2
	public void load(FMLInitializationEvent event) 
	{
		Items.load();
		Blocks.load();
		Blocks.registerTileEntities();
	}

	@EventHandler // used in 1.6.2
	//@PostInit   // used in 1.5.2
	public void postInit(FMLPostInitializationEvent event) 
	{
		// Stub Method

	}
}
