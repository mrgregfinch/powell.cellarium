package powell.rasterland.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import powell.rasterland.properties.RasterizedPlayer;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class RasterlandPacketHandler implements IPacketHandler
{
	// Don't need to do anything here.
	public RasterlandPacketHandler() 
	{

	}

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
	{
		// This is a good place to parse through channels if you have multiple channels
		if (packet.channel.equals("rasterizedPlayer")) 
		{
			handleExtendedProperties(packet, player);
		}
	}

	// Making different methods to handle each channel helps keep things tidy:
	private void handleExtendedProperties(Packet250CustomPayload packet, Player player)
	{
		DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
		RasterizedPlayer props = RasterizedPlayer.get((EntityPlayer) player);

		// Everything we read here should match EXACTLY the order in which we wrote it
		// to the output stream in our ExtendedPlayer sync() method.
		try 
		{
			props.setMaxEnergy(inputStream.readInt());
			props.setCurrentEnergy(inputStream.readInt());
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			return;
		}
		// Just so you can see in the console that it's working:
		System.out.println("[PACKET] Mana from packet: " + props.getEnergy() + "/" + props.getMaxEnergy());
	}

}
