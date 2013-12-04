package powell.games.entity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import powell.games.block.Blocks;
import powell.games.entity.tileentity.*;

public class TTTEntity extends Entity
{
	private int turn;
	

	public TTTEntity(World par1World)
	{
		super(par1World);
		turn = 0;
	}
	
	public TTTEntity(World world, int x, int y, int z)
	{
		super(world);
		turn = 0;
		
		for(int xx = 0; xx < 3; xx++)
		{
			for(int zz = 0; zz < 3; zz++)
			{
				System.out.println("X " + (x+xx) + " Y " + y + " Z " + (z+zz));
				world.setBlock(x, y, z + zz, Blocks.tttBlock.blockID);
				TTTBlockEntity bleh = (TTTBlockEntity)world.getBlockTileEntity(x, y, z +zz);
				bleh.registerBoard(this);
			}
			y++;
		}
	}

	@Override
	protected void entityInit()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbttagcompound)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbttagcompound)
	{
		// TODO Auto-generated method stub
		
	}
	
	public boolean getPlay()
	{
		return (turn++ % 2) == 0;
	}

}
