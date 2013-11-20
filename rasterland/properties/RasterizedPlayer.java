package powell.rasterland.properties;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class RasterizedPlayer implements IExtendedEntityProperties
{
	//property identifier
	public final static String EXT_PROP_NAME = "RasterizedPlayer";

	//entity that owns the property
	private final EntityPlayer player;

	private int currentEnergy;
	private int maxEnergy;

	public RasterizedPlayer(EntityPlayer p)
	{
		this.player = p;
		this.currentEnergy = this.maxEnergy = 100;
	}

	//for convenience and to make code look nicer
	public static final void register(EntityPlayer player)
	{
		player.registerExtendedProperties(RasterizedPlayer.EXT_PROP_NAME, new RasterizedPlayer(player));
	}

	//for convenience and to make code look nicer
	public static final RasterizedPlayer get(EntityPlayer player)
	{
		return (RasterizedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
	}

	@Override
	public void saveNBTData(NBTTagCompound compound)
	{
		//create tag compound that saves the properties
		NBTTagCompound properties = new NBTTagCompound();

		properties.setInteger("CurrentEnergy", this.currentEnergy);
		properties.setInteger("MaxEnergy", this.maxEnergy);

		//adds custom tag to the player's tag
		compound.setTag(EXT_PROP_NAME, properties);

	}

	@Override
	public void loadNBTData(NBTTagCompound compound)
	{
		// Here we fetch the unique tag compound we set for this class of Extended Properties
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);

		// Get our data from the custom tag compound
		this.currentEnergy = properties.getInteger("CurrentEnergy");
		this.maxEnergy = properties.getInteger("MaxEnergy");

		// Just so you know it's working, add this line:
		System.out.println("[Rasterland] Energy from NBT: " + this.currentEnergy + "/" + this.maxEnergy);

	}

	@Override
	public void init(Entity entity, World world)
	{
		//use of this method is unknown?

	}

	//methods for interacting with energy
	public void restoreEnergy(int x)
	{
		this.currentEnergy += x;

		if(this.currentEnergy > this.maxEnergy)
			this.currentEnergy = this.maxEnergy;
		
		this.sync();
	}

	public boolean maxEnergy()
	{
		return this.currentEnergy == this.maxEnergy;
	}

	public boolean consumeEnergy(int x)
	{
		if((this.currentEnergy - x) >= 0)
		{
			this.currentEnergy -= x;
			this.sync();
			return true;
		}
		else
			return false;
	}

	public int getEnergy()
	{
		return this.currentEnergy;
	}

	public int getMaxEnergy()
	{
		// TODO Auto-generated method stub
		return this.maxEnergy;
	}

	public void setMaxEnergy(int readInt)
	{
		this.maxEnergy = readInt;	
		this.sync();
	}

	public void setCurrentEnergy(int readInt)
	{
		this.currentEnergy = readInt;
		this.sync();
	}

	/**
	 * Sends a packet to the client containing information stored on the server
	 * for ExtendedPlayer
	 */
	public final void sync()
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
		DataOutputStream outputStream = new DataOutputStream(bos);

		// We'll write max mana first so when we set current mana client
		// side, it doesn't get set to 0 (see methods below)
		try 
		{
			outputStream.writeInt(this.maxEnergy);
			outputStream.writeInt(this.currentEnergy);
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}

		Packet250CustomPayload packet = new Packet250CustomPayload("rasterizedPlayer", bos.toByteArray());

		// We only want to send from the server to the client
		if (FMLCommonHandler.instance().getEffectiveSide().isServer()) 
		{
			EntityPlayerMP player1 = (EntityPlayerMP) player;
			PacketDispatcher.sendPacketToPlayer(packet, (Player) player1);
		}
	}

}
