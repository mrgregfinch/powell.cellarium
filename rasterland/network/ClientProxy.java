package powell.rasterland.network;

import net.minecraftforge.common.MinecraftForge;
import powell.rasterland.entity.EntityDisc;
import powell.rasterland.entity.EntityRasterBike3;
import powell.rasterland.event.RasterlandSoundEventHandler;
import powell.rasterland.render.RenderRasterBike2;
import powell.rasterland.render.RenderRasterBlock;
import powell.rasterland.render.RenderRasterDisc2;
import powell.rasterland.render.RenderRasterWall;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
//	public static int awesomeOreRenderType;
//	public static int awesomeOreRenderStage = 0;

	public static int rasterBlockRenderType;
	public static int rasterBlockRenderStage = 0;
	
	public static int rasterWallRenderType;
	public static int rasterWallRenderStage = 0;
	
	public static int renderTestType;

	@Override
	public void preInit()
	{
//		awesomeOreRenderType = RenderingRegistry.getNextAvailableRenderId();
//		RenderingRegistry.registerBlockHandler(new RenderAwesomeOre());

		rasterBlockRenderType = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderRasterBlock());
		
		rasterWallRenderType = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderRasterWall());
		
		
		renderTestType = RenderingRegistry.getNextAvailableRenderId();
		
		MinecraftForge.EVENT_BUS.register(new RasterlandSoundEventHandler());
	}


	@Override
	public void registerRenderers() 
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityDisc.class, new RenderRasterDisc2());
		RenderingRegistry.registerEntityRenderingHandler(EntityRasterBike3.class, new RenderRasterBike2());
	}

}
