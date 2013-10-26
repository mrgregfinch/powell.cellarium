package powell.cellarium;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fluids.ItemFluidContainer;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;

public class BucketOfTears extends ItemFluidContainer
{
	private int isFull;

	public BucketOfTears(int id, int par2)
	{
		super(id);
		this.isFull = par2;
		MinecraftForge.EVENT_BUS.register(this);
		setTextureName("cellarium:bucketOfTears");
	}


	//Most of this is based off Mazetar's Tutorial
	@Override
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
	{
		MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, true);

		if (movingobjectposition == null)
		{
			return item;
		}
		else
		{
			FillBucketEvent event = new FillBucketEvent(player, item, world, movingobjectposition);
			if (MinecraftForge.EVENT_BUS.post(event))
			{
				return item;
			}

			if (event.getResult() == Event.Result.ALLOW)
			{
				if (player.capabilities.isCreativeMode)
				{
					return item;
				}

				if (--item.stackSize <= 0)
				{
					return event.result;
				}

				if (!player.inventory.addItemStackToInventory(event.result))
				{
					player.dropPlayerItem(event.result);
				}

				return item;
			}

			if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
			{
				int x = movingobjectposition.blockX;
				int y = movingobjectposition.blockY;
				int z = movingobjectposition.blockZ;

				if (!world.canMineBlock(player, x, y, z))
				{
					return item;
				}


				if (movingobjectposition.sideHit == 0)
				{
					--y;
				}

				if (movingobjectposition.sideHit == 1)
				{
					++y;
				}

				if (movingobjectposition.sideHit == 2)
				{
					--z;
				}

				if (movingobjectposition.sideHit == 3)
				{
					++z;
				}

				if (movingobjectposition.sideHit == 4)
				{
					--x;
				}

				if (movingobjectposition.sideHit == 5)
				{
					++x;
				}

				if (!player.canPlayerEdit(x, y, z, movingobjectposition.sideHit, item))
				{
					return item;
				}

				if (this.tryPlaceContainedLiquid(world, x, y, z) && !player.capabilities.isCreativeMode)
				{
					return new ItemStack(Item.bucketEmpty);
				}

			}

			return item;
		}
	}


	/**
	 * Attempts to place the liquid contained inside the bucket.
	 */
	public boolean tryPlaceContainedLiquid(World par1World, int par2, int par3, int par4)
	{
		if (this.isFull <= 0)
		{
			return false;
		}
		else
		{
			Material material = par1World.getBlockMaterial(par2, par3, par4);
			boolean flag = !material.isSolid();

			if (!par1World.isAirBlock(par2, par3, par4) && !flag)
			{
				return false;
			}
			else
			{
				if (par1World.provider.isHellWorld && this.isFull == Block.waterMoving.blockID)
				{
					par1World.playSoundEffect((double)((float)par2 + 0.5F), (double)((float)par3 + 0.5F), (double)((float)par4 + 0.5F), "random.fizz", 0.5F, 2.6F + (par1World.rand.nextFloat() - par1World.rand.nextFloat()) * 0.8F);

					for (int l = 0; l < 8; ++l)
					{
						par1World.spawnParticle("largesmoke", (double)par2 + Math.random(), (double)par3 + Math.random(), (double)par4 + Math.random(), 0.0D, 0.0D, 0.0D);
					}
				}
				else
				{
					if (!par1World.isRemote && flag && !material.isLiquid())
					{
						par1World.destroyBlock(par2, par3, par4, true);
					}

					par1World.setBlock(par2, par3, par4, this.isFull, 0, 3);
				}

				return true;
			}
		}
	}

	@ForgeSubscribe(priority = EventPriority.NORMAL)
	public void FillBucket(FillBucketEvent event) 
	{
		ItemStack result = attemptFill(event.world, event.target);
		if (result != null) {
			event.result = result;
			event.setResult(Result.ALLOW);
		}
	}

	private ItemStack attemptFill( World world, MovingObjectPosition p )
	{
		int id = world.getBlockId( p.blockX, p.blockY, p.blockZ );

		if ( id == Cellarium.blockTearsOfChildren.blockID )
		{
			if ( world.getBlockMetadata( p.blockX, p.blockY, p.blockZ ) == 0 ) // Check that it is a source block
			{
				world.setBlock( p.blockX, p.blockY, p.blockZ, 0 ); // Remove the fluid block

				return new ItemStack( Cellarium.bucketOfTears ); // Return the filled bucked item here.
			}
		}

		return null;
	}


	//below two methods are from Homletmoo's Forum Post
	/* @ForgeSubscribe
	public void onBucketFill( FillBucketEvent event )
	{
		ItemStack result = attemptFill( event.world, event.target );

		if ( result != null )
		{
			event.result = result;
			event.setResult( Result.ALLOW );
		}
	}

    private ItemStack attemptFill( World world, MovingObjectPosition p )
	{
		int id = world.getBlockId( p.blockX, p.blockY, p.blockZ );
		if ( id == Cellarium.blockTearsOfChildren.blockID )
		{
			if ( world.getBlockMetadata( p.blockX, p.blockY, p.blockZ ) == 0 ) // Check that it is a source block
			{
				world.setBlock( p.blockX, p.blockY, p.blockZ, 0 ); // Remove the fluid block

				return new ItemStack( Cellarium.bucketOfTears );
			}
		}

		return null;
	}*/





}
