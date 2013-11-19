package powell.rasterland.network;

import powell.rasterland.entity.EntityDisc;
import powell.rasterland.item.Items;
import powell.rasterland.render.*;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	public static int awesomeOreRenderType;
	public static int awesomeOreRenderStage = 0;

	public static int rasterBlockRenderType;
	public static int rasterBlockRenderStage = 0;

	@Override
	public void preInit()
	{
		awesomeOreRenderType = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderAwesomeOre());

		rasterBlockRenderType = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderRasterBlock());
	}


	@Override
	public void registerRenderers() 
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityDisc.class, new RenderThrownDisc(Items.disc));
	}

}
