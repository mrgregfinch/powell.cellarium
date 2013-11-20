package powell.rasterland.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import powell.rasterland.properties.RasterizedPlayer;

public class RasterizedPlayerEventHandler
{
	@ForgeSubscribe
	public void onEntityConstructing(EntityConstructing event)
	{
		//null check to make sure properties are only registered once per entity
		if(event.entity instanceof EntityPlayer && RasterizedPlayer.get((EntityPlayer)event.entity) == null)
		{
			RasterizedPlayer.register((EntityPlayer) event.entity);
		}

		if(event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(RasterizedPlayer.EXT_PROP_NAME) == null)
		{
			event.entity.registerExtendedProperties(RasterizedPlayer.EXT_PROP_NAME, new RasterizedPlayer((EntityPlayer)event.entity));
		}
	}

	@ForgeSubscribe
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{
		//Only need to synchronize when the world is remote (i.e. we're on the server side)
		// and only for player entities, as that's what we need for the GuiManaBar
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer)
			RasterizedPlayer.get((EntityPlayer) event.entity).sync();
	}
}
