package powell.rasterland.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import powell.rasterland.Rasterland;

public class BlockTeleporter extends BlockPortal
{

	public BlockTeleporter(int par1)
	{
		super(par1);
		// TODO Auto-generated constructor stub
		setUnlocalizedName("blockTeleporter");
		setCreativeTab(Rasterland.tabRasterland);
	}
	
	@Override
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity entity)
    {
		if(entity.ridingEntity == null && entity.riddenByEntity == null
				&& entity instanceof EntityPlayerMP)
		{
			EntityPlayerMP player = (EntityPlayerMP) entity;
			ModLoader.getMinecraftServerInstance();
			MinecraftServer server = MinecraftServer.getServer();
			
			if(player.timeUntilPortal > 0)
			{
				player.timeUntilPortal = 10;
			}
			else if(player.dimension != Rasterland.DIMENSIONID)
			{
				player.timeUntilPortal = 10;
				player.mcServer.getConfigurationManager().transferPlayerToDimension(player, Rasterland.DIMENSIONID, new TeleporterVoid(server.worldServerForDimension(Rasterland.DIMENSIONID)));
			}
			else
			{
				player.timeUntilPortal = 10;
				player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new TeleporterVoid(server.worldServerForDimension(0)));
			}
		}
	}
	
	@Override
	public boolean tryToCreatePortal(World world, int x, int y, int z)
	{
		byte b = 0;
		byte b1 = 0;
		
		if(world.getBlockId(x-1, y, z) == Block.glowStone.blockID || world.getBlockId(x+1, y, z) == Block.glowStone.blockID)
		{
			b = 1;
		}
		
		if(world.getBlockId(x, y, z-1) == Block.glowStone.blockID || world.getBlockId(x, y, z+1) == Block.glowStone.blockID)
		{
			b1 = 1;
		}
		
		if(b == b1)
		{
			return false;
		}
		else
		{
			if(world.isAirBlock(x-b, y, z-b1))
			{
				x -=b;
				z -=b1;
			}
			
			for (int i = -1; i <=2; i++)
			{
				for(int j = -1; j <=3; j++)
				{
					boolean flag = (i == -1 || i == 2 || j == -1 || j == 3);
					if(i != -1 && i !=2 || j != -1 && j != 3)
					{
						int k = world.getBlockId(x + (b*i), y+j, z+ (b1*i));
						if(flag)
							if(k != Block.glowStone.blockID)
								return false;
					}
					
				}
			}
		}
		
		return false;
	}
	
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
	{
		
	}

}
