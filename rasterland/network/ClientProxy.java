package powell.rasterland.network;

import net.minecraftforge.common.MinecraftForge;
import powell.rasterland.entity.EntityDisc;
import powell.rasterland.event.RasterlandSoundEventHandler;
import powell.rasterland.item.Items;
import powell.rasterland.render.RenderAwesomeOre;
import powell.rasterland.render.RenderRasterBlock;
import powell.rasterland.render.RenderRasterWall;
import powell.rasterland.render.RenderThrownDisc;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	public static int awesomeOreRenderType;
	public static int awesomeOreRenderStage = 0;

	public static int rasterBlockRenderType;
	public static int rasterBlockRenderStage = 0;
	
	public static int rasterWallRenderType;
	public static int rasterWallRenderStage = 0;

	@Override
	public void preInit()
	{
		awesomeOreRenderType = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderAwesomeOre());

		rasterBlockRenderType = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderRasterBlock());
		
		rasterWallRenderType = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderRasterWall());
		
		MinecraftForge.EVENT_BUS.register(new RasterlandSoundEventHandler());
	}


	@Override
	public void registerRenderers() 
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityDisc.class, new RenderThrownDisc(Items.disc));
	}

}
