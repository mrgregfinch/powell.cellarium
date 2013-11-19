package powell.rasterland.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityDisc extends EntityThrowable
{

	public EntityDisc(World par1World)
	{
		super(par1World);
	}

	public EntityDisc(World par1World, EntityLivingBase par2EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase);
	}
	
	
	public EntityDisc(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6);
	}
	
	
	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	protected void onImpact(MovingObjectPosition movObjPos)
	{
		if (movObjPos.entityHit != null)
		{
			float discDamage = 2;
			
			movObjPos.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), discDamage);
		}
		for (int i = 0; i < 8; ++i)
		{
			this.worldObj.spawnParticle("crit", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
		}
		if (!this.worldObj.isRemote)
		{
			this.setDead();
		}
	}


}
