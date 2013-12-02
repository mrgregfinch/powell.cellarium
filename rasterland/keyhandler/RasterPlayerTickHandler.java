package powell.rasterland.keyhandler;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayer;
import powell.rasterland.entity.EntityRasterBike;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class RasterPlayerTickHandler implements ITickHandler
{
	private final EnumSet<TickType> ticksToGet;

	public RasterPlayerTickHandler(EnumSet<TickType> ticksToGet)
	{
		this.ticksToGet = ticksToGet;
	}
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{
		playerTick((EntityPlayer)tickData[0]);
		
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public EnumSet<TickType> ticks()
	{
		return ticksToGet;
	}

	@Override
	public String getLabel()
	{
		return "RasterPlayerTickHandler";
	}
	
	public static void playerTick(EntityPlayer player)
	{
		if(player.isRiding() && player.ridingEntity instanceof EntityRasterBike)
		{
			System.out.println("Yes we are here");
		}
	}

}
