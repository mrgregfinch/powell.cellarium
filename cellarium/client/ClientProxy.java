package powell.cellarium.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import powell.cellarium.CommonProxy;

public class ClientProxy extends CommonProxy 
{


	@Override
	public void registerRenderers() 
	{
		// This is for rendering entities and so forth later on
	}


	@Override
	public int addArmor(String armor)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
}
