package powell.rasterland.item;

import java.util.Random;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import powell.rasterland.Rasterland;
import powell.rasterland.entity.EntityDisc;
import powell.rasterland.properties.PowerColor;
import powell.rasterland.properties.RasterizedPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Disc extends Item
{
	
	private Icon icons[];
	private int index = 0;
	private PowerColor power;

	public Disc(int par1)
	{
		super(par1);
		this.maxStackSize = 1;
		this.setCreativeTab(Rasterland.tabRasterland);
		this.setUnlocalizedName("disc");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister)//updateIcons
	{
		/*this.itemIcon = iconRegister.registerIcon("rasterland:base");
		System.out.println("[Rasterland] Registering Icon: rasterland:base");*/
		icons = new Icon[PowerColor.values().length];
		
		for(PowerColor pc: PowerColor.values())
		{
			icons[pc.getInt()] = iconRegister.registerIcon("rasterland:disc" + pc.toString());
		}
		
		updateIcon();
	}
	
	//test
	private void updateIcon()
	{
		this.itemIcon = icons[index];
	}


	/**
	 * Called whenever this item is equipped and the right mouse button is pressed.
	 * Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
	{
		RasterizedPlayer props = RasterizedPlayer.get(player);
		
		//color test
		Random rand = new Random();
		index = rand.nextInt(PowerColor.values().length);
		props.setPowerColor(index);
		updateIcon();
		//end color test
		
		
		System.out.println("Player currently has " + props.getEnergy() + " in their " + props.getPowerColor() + " energy reserve.");
		props.consumeEnergy(20);
		if (!player.capabilities.isCreativeMode)
		{
			--itemstack.stackSize;
		}

		world.playSoundAtEntity(player, "rasterland:discThrowShort", 0.5F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));

		if (!world.isRemote)
		{
			//world, player throwing disc, a velocity multiplier
			world.spawnEntityInWorld(new EntityDisc(world, player, 10));
		}

		return itemstack;
	}
	
	
	//test code for sound
	public void onUpdate(ItemStack item, World world, Entity entity, int par4, boolean par5) 
	{
	    if (entity instanceof EntityPlayerMP && ((EntityPlayerMP)entity).getCurrentEquippedItem() == item) 
	    {
	        world.playSoundAtEntity(entity, "rasterland:discGlowShort", 0.05F, 1.0F);
	    }
	}


}
