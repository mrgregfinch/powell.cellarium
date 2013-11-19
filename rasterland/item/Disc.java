package powell.rasterland.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import powell.rasterland.Rasterland;
import powell.rasterland.entity.EntityDisc;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Disc extends Item
{

	public Disc(int par1)
	{
		super(par1);
		this.maxStackSize = 1;
		this.setCreativeTab(Rasterland.tabRasterland);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister)//updateIcons
	{
		this.itemIcon = iconRegister.registerIcon("rasterland:base");
		System.out.println("[Rasterland] Registering Icon: rasterland:base");
	}


	/**
	 * Called whenever this item is equipped and the right mouse button is pressed.
	 * Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
	{
		if (!player.capabilities.isCreativeMode)
		{
			--itemstack.stackSize;
		}

		world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		if (!world.isRemote)
		{
			world.spawnEntityInWorld(new EntityDisc(world, player));
		}

		return itemstack;
	}


}
