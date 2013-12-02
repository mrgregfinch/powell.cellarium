package powell.rasterland.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityRasterBike3 extends Entity
{
	private int timeSinceRight =0;
	private int timeSinceLeft = 0;
	private int timeSinceForward = 0;
	private int timeSinceBackward = 0;
	private double velocity;
	private double maxVelocity = 5;
	private double velocityBoost = 0;
	int direction = 0;

	public EntityRasterBike3(World par1World)
	{
		super(par1World);
		setSize(1.5F, 0.6F);
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

	@Override
	public AxisAlignedBB getBoundingBox() 
	{
		return boundingBox;
	}	

	@Override
	public AxisAlignedBB getCollisionBox(Entity entity)
	{
		if (entity != riddenByEntity) 
		{
			return entity.boundingBox;
		}
		else
		{
			return null;
		}
	}	

	@Override
	public boolean canBeCollidedWith()
	{
		return !isDead;
	}	

	public boolean interactFirst(EntityPlayer par1EntityPlayer)
	{
		if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != par1EntityPlayer)
		{
			return true;
		}
		else
		{
			if (!this.worldObj.isRemote)
			{
				par1EntityPlayer.rotationYaw = this.rotationYaw;
				par1EntityPlayer.rotationPitch = this.rotationPitch;
				par1EntityPlayer.mountEntity(this);
			}

			return true;
		}
	}

	@Override
	public double getMountedYOffset() 
	{
		return -0.35;
	}


	@Override
	public void onUpdate()
	{
		if(timeSinceRight > 0)
			timeSinceRight--;
		if(timeSinceLeft > 0)
			timeSinceLeft--;
		if(timeSinceForward > 0)
			timeSinceForward--;
		if(timeSinceBackward >0)
			timeSinceBackward--;

		super.onUpdate();
		if(!worldObj.isRemote && this.riddenByEntity != null)
		{
			
			if(Minecraft.getMinecraft().gameSettings.keyBindForward.pressed && timeSinceForward == 0)
			{
				System.out.println("Forward was pressed");
				if(velocity < maxVelocity)
					velocity = velocity + .1 + velocityBoost;
			}
			if(Minecraft.getMinecraft().gameSettings.keyBindRight.pressed && timeSinceRight == 0)
			{
				System.out.println("Right was pressed");
				this.setRotation(this.rotationYaw + 90, this.rotationPitch);
				timeSinceRight = 10;
				direction = direction < 3 ? ++direction : 0;System.out.println("Direction = " + direction);
			}
			if(Minecraft.getMinecraft().gameSettings.keyBindLeft.pressed && timeSinceLeft == 0)
			{
				System.out.println("Left was pressed");
				this.setRotation(this.rotationYaw - 90, this.rotationPitch);
				timeSinceLeft = 10;
				direction = direction > 0 ? --direction : 3;System.out.println("Direction = " + direction);
			}
			if(Minecraft.getMinecraft().gameSettings.keyBindBack.pressed && timeSinceBackward == 0)
			{
				System.out.println("Backward was pressed");
				if(velocity > 0)
					velocity = velocity - .1;
			}

		}

		if(this.riddenByEntity != null)
		{
			this.riddenByEntity.rotationYaw = this.rotationYaw;
		}
		
		switch(direction)
		{
			case 0: setPosition(posX, posY + motionY, posZ + velocity);
					break;
			case 1:	setPosition(posX - velocity, posY + motionY, posZ);
					break;
			case 2:	setPosition(posX, posY + motionY, posZ - velocity);
					break;
			case 3: setPosition(posX + velocity, posY + motionY, posZ);
					break;
		}


	}


}
