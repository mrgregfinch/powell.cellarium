package powell.rasterland.event;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class RasterlandSoundEventHandler
{
	@ForgeSubscribe
	public void onSound(SoundLoadEvent event)
	{
		event.manager.addSound("rasterland:discThrow.ogg");
		event.manager.addSound("rasterland:discGlow.ogg");
		event.manager.addSound("rasterland:discThrowShort.ogg");
		event.manager.addSound("rasterland:discGlowShort.ogg");
	}
}
