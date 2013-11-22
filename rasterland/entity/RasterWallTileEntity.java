package powell.rasterland.entity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class RasterWallTileEntity extends TileEntity
{
	private int timer;
	
	public RasterWallTileEntity()
	{
		this.timer = 600;
	}
	
	@Override
	public void updateEntity()
	{
		if(timer == 0 && !worldObj.isRemote)
		{
			worldObj.setBlockToAir(xCoord, yCoord, zCoord);
			worldObj.removeBlockTileEntity(xCoord, yCoord, zCoord);
		}
		else
			timer--;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		
		compound.setShort("RasterWallTimer", (short)timer);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		
		timer = compound.getShort("RasterWallTimer");
	}
}
