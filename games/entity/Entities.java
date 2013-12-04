package powell.games.entity;


import powell.games.Games;
import cpw.mods.fml.common.registry.EntityRegistry;

public class Entities
{
	private static int modEntityID = 0;
	
	public static void init()
	{
		EntityRegistry.registerModEntity(TTTEntity.class, "Tic Tac Toe Game", ++modEntityID, Games.instance, 64, 10, true);
	}
}

