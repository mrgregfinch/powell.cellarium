package powell.rasterland.block;

import java.util.Random;

import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class TeleporterVoid extends Teleporter
{
	private final WorldServer WORLDSERVERINSTANCE;
	private final Random RAND;

	public TeleporterVoid(WorldServer par1WorldServer)
	{
		super(par1WorldServer);
		// TODO Auto-generated constructor stub
		WORLDSERVERINSTANCE = par1WorldServer;
		RAND = new Random(WORLDSERVERINSTANCE.getSeed());
	}

}
