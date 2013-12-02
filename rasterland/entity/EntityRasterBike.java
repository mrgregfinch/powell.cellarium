package powell.rasterland.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityRasterBike extends EntityLivingBase
{  private boolean field_70279_a;
private double speedMultiplier;

	public EntityRasterBike(World par1World)
	{
		super(par1World);
//		 this.field_70279_a = true;
//	        this.speedMultiplier = 0.07D;
//	        this.preventEntitySpawning = true;
		this.setSize(0.98F, 0.7F);
       // this.yOffset = this.height / 2.0F;
	}
	
	public EntityRasterBike(World par1World, double par2, double par4, double par6)
    {
        this(par1World);
        this.setPosition(par2 +.5, par4 + 1.5, par6 +.5);
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
        this.prevPosX = par2 +.5;
        this.prevPosY = par4 +1.5;
        this.prevPosZ = par6 +.5;
    }

	
	
	@Override
	public ItemStack getHeldItem()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getCurrentItemOrArmor(int i)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCurrentItemOrArmor(int i, ItemStack itemstack)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public ItemStack[] getLastActiveItems()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
//	 protected void entityInit()
//	    {
//	        this.dataWatcher.addObject(17, new Integer(0));
//	        this.dataWatcher.addObject(18, new Integer(1));
//	        this.dataWatcher.addObject(19, new Float(0.0F));
//	    }
	
	@Override
	 public AxisAlignedBB getCollisionBox(Entity par1Entity)
	    {
			if(par1Entity != riddenByEntity)
				return par1Entity.boundingBox;
			else
				return null;
	    }

	    /**
	     * returns the bounding box for this entity
	     */
	@Override    
	public AxisAlignedBB getBoundingBox()
	    {
	        return this.boundingBox;
	    }

	    /**
	     * Returns true if this entity should push and be pushed by other entities when colliding.
	     */
	    public boolean canBePushed()
	    {
	        return true;
	    }

	    
	    public double getMountedYOffset()
	    {
	        return (double)this.height * 0.0D - 0.30000001192092896D;
	    }
	    
	    @Override
	    public boolean canBeCollidedWith()
	    {
	        return !this.isDead;
	    }
	    
	    public void updateRiderPosition()
	    {
	        if (this.riddenByEntity != null)
	        {
	            double d0 = Math.cos((double)this.rotationYaw * Math.PI / 180.0D) * 0.4D;
	            double d1 = Math.sin((double)this.rotationYaw * Math.PI / 180.0D) * 0.4D;
	            this.riddenByEntity.setPosition(this.posX + d0, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ + d1);
	        }
	    }
	    
	    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {}

	    /**
	     * (abstract) Protected helper method to read subclass entity data from NBT.
	     */
	    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {}

	    @SideOnly(Side.CLIENT)
	    public float getShadowSize()
	    {
	        return 0.0F;
	    }

	    /**
	     * First layer of player interaction
	     */
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
	                par1EntityPlayer.mountEntity(this);
	            }

	            return true;
	        }
	    }
	    
	    public void setForwardDirection(int par1)
	    {
	        this.dataWatcher.updateObject(18, Integer.valueOf(par1));
	    }

	    /**
	     * Gets the forward direction of the entity.
	     */
	    public int getForwardDirection()
	    {
	        return this.dataWatcher.getWatchableObjectInt(18);
	    }

	    private void testMovement()
	    {
	    	this.prevPosX = this.posX;
	        this.prevPosY = this.posY;
	        this.prevPosZ = this.posZ;
	        
	        if(this.onGround && ((EntityLivingBase)this.riddenByEntity).motionY > 0)
	        {
	        	System.out.println("jump pressed ??");
	        }
	        
	        
	    }
	    
	    public void onUpdate()
	    {
	        super.onUpdate();
	        
	        if(this.riddenByEntity == null)
	        {
	        	worldObj.removeEntity(this);
	        }
	        else
	        {
	        	this.testMovement();
	        }
	    }
	    
	    public void moveEntityWithHeading(float par1, float par2)
	    {
	    	if(this.riddenByEntity != null)
	        {
	        double d0 = this.posX;
	        double d1 = this.posY;
	        double d2 = this.posZ;

//	        if (this.capabilities.isFlying && this.ridingEntity == null)
//	        {
//	            double d3 = this.motionY;
//	            float f2 = this.jumpMovementFactor;
//	            this.jumpMovementFactor = this.capabilities.getFlySpeed();
//	            super.moveEntityWithHeading(par1, par2);
//	            this.motionY = d3 * 0.6D;
//	            this.jumpMovementFactor = f2;
//	        }
//	        else
	        
	        
	        
	        this.prevRotationYaw = this.rotationYaw = this.riddenByEntity.rotationYaw;
            this.rotationPitch = this.riddenByEntity.rotationPitch * 0.5F;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
	        
	        
	        { par1 = ((EntityLivingBase)this.riddenByEntity).moveStrafing * 0.5F;
            par2 = ((EntityLivingBase)this.riddenByEntity).moveForward;
	            super.moveEntityWithHeading(par1, par2);
	        }
	        
	        
	        
	        }

	      //  this.addMovementStat(this.posX - d0, this.posY - d1, this.posZ - d2);
	    }
	    
	    
	    public void setDamageTaken(float par1)
	    {
	        //this.dataWatcher.updateObject(19, Float.valueOf(par1));
	    }

	    /**
	     * Gets the damage taken from the last hit.
	     */
	    public float getDamageTaken()
	    {
	        return 0;// this.dataWatcher.getWatchableObjectFloat(19);
	    }
	    
	    public void setTimeSinceHit(int par1)
	    {
	        //this.dataWatcher.updateObject(17, Integer.valueOf(par1));
	    }

	    /**
	     * Gets the time since the last hit.
	     */
	    public int getTimeSinceHit()
	    {
	        return 0;//this.dataWatcher.getWatchableObjectInt(17);
	    }
	    
	  

}
