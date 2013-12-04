package powell.games.entity.tileentity;

import powell.games.entity.TTTEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TTTBlockEntity extends TileEntity
{
	private boolean turn;
	private boolean played;
	private TTTEntity board;

	public TTTBlockEntity()
	{
		turn = true;
		played = false;
	}

	public void makePlay(World world)
	{
		if(!played)
		{
			System.out.println("in the make play");
			turn = board.getPlay();
			world.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, turn ? 1 : 2, 3);
			played = !played;
		}


	}

	@Override
	public void writeToNBT(NBTTagCompound compound) 
	{
		super.writeToNBT(compound);

	}

	@Override
	public void readFromNBT(NBTTagCompound compound) 
	{
		super.readFromNBT(compound);

	}

	public void registerBoard(TTTEntity b)
	{
		board = b;
	}
}
