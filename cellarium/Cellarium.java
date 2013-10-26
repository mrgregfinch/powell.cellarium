package powell.cellarium;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.ItemFluidContainer;
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
	public static boolean displayclear = true;
	
	//Custom Fluids/Blocks/Items
	public static Fluid tearsOfChildren;
	public static BlockFluidClassic blockTearsOfChildren;
	public static Block genericDirt;
	public static ItemFluidContainer bucketOfTears;
	//end Custom
	
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
		//Create Fluids First
		tearsOfChildren = new TearsOfChildren();
		//end Fluids
		//create Blocks
		blockTearsOfChildren = (BlockFluidClassic) new BlockTearsOfChildren(777).setUnlocalizedName("blockTearsOfChildren").setCreativeTab(tabCellarium);
		genericDirt = new GenericBlock(500, Material.ground)
        .setHardness(0.5F).setStepSound(Block.soundGravelFootstep)
        .setUnlocalizedName("genericDirt");
		//end Blocks
		//create Items
		bucketOfTears = (ItemFluidContainer) new BucketOfTears(778,777).setUnlocalizedName("bucketOfTears").setCreativeTab(tabCellarium);
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
		GameRegistry.registerBlock(blockTearsOfChildren, "blockTearsOfChildren");
		
		LanguageRegistry.addName(genericDirt, "Generic Dirt");
        MinecraftForge.setBlockHarvestLevel(genericDirt, "shovel", 0);
        GameRegistry.registerBlock(genericDirt, "genericDirt");
        
        GameRegistry.registerItem(bucketOfTears, "bucketOfTears");
        LanguageRegistry.addName(bucketOfTears, "Bucket of Tears");
        //FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack(Cellarium.tearsOfChildren.getUnlocalizedName(), FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketOfTears), new ItemStack(Item.bucketEmpty));
		
	}

	@EventHandler // used in 1.6.2
	//@PostInit   // used in 1.5.2
	public void postInit(FMLPostInitializationEvent event) 
	{
		// Stub Method
	}
}
