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
		setTextureName("rasterland:blockTeleporter");
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
		byte b0 = 0;
        byte b1 = 0;

        if (world.getBlockId(x - 1, y, z) == Block.glowStone.blockID || world.getBlockId(x + 1, y, z) == Block.glowStone.blockID)
        {
            b0 = 1;
        }

        if (world.getBlockId(x, y, z - 1) == Block.glowStone.blockID || world.getBlockId(x, y, z + 1) == Block.glowStone.blockID)
        {
            b1 = 1;
        }

        if (b0 == b1)
        {
            return false;
        }
        else
        {
            if (world.isAirBlock(x - b0, y, z - b1))
            {
                x -= b0;
                z -= b1;
            }

            int l;
            int i1;

            for (l = -1; l <= 2; ++l)
            {
                for (i1 = -1; i1 <= 3; ++i1)
                {
                    boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;

                    if (l != -1 && l != 2 || i1 != -1 && i1 != 3)
                    {
                        int j1 = world.getBlockId(x + b0 * l, y + i1, z + b1 * l);
                        boolean isAirBlock = world.isAirBlock(x + b0 * l, y + i1, z + b1 * l);

                        if (flag)
                        {
                            if (j1 != Block.glowStone.blockID)
                            {
                                return false;
                            }
                        }
                        else if (!isAirBlock && j1 != Block.fire.blockID)
                        {
                            return false;
                        }
                    }
                }
            }

            for (l = 0; l < 2; ++l)
            {
                for (i1 = 0; i1 < 3; ++i1)
                {
                    world.setBlock(x + b0 * l, y + i1, z + b1 * l, Blocks.blockTeleporter.blockID, 0, 2);
                }
            }

            return true;
        }
	}
	
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
	{
		byte b0 = 0;
        byte b1 = 1;

        if (par1World.getBlockId(par2 - 1, par3, par4) == this.blockID || par1World.getBlockId(par2 + 1, par3, par4) == this.blockID)
        {
            b0 = 1;
            b1 = 0;
        }

        int i1;

        for (i1 = par3; par1World.getBlockId(par2, i1 - 1, par4) == this.blockID; --i1)
        {
            ;
        }

        if (par1World.getBlockId(par2, i1 - 1, par4) != Block.glowStone.blockID)
        {
            par1World.setBlockToAir(par2, par3, par4);
        }
        else
        {
            int j1;

            for (j1 = 1; j1 < 4 && par1World.getBlockId(par2, i1 + j1, par4) == this.blockID; ++j1)
            {
                ;
            }

            if (j1 == 3 && par1World.getBlockId(par2, i1 + j1, par4) == Block.glowStone.blockID)
            {
                boolean flag = par1World.getBlockId(par2 - 1, par3, par4) == this.blockID || par1World.getBlockId(par2 + 1, par3, par4) == this.blockID;
                boolean flag1 = par1World.getBlockId(par2, par3, par4 - 1) == this.blockID || par1World.getBlockId(par2, par3, par4 + 1) == this.blockID;

                if (flag && flag1)
                {
                    par1World.setBlockToAir(par2, par3, par4);
                }
                else
                {
                    if ((par1World.getBlockId(par2 + b0, par3, par4 + b1) != Block.glowStone.blockID || par1World.getBlockId(par2 - b0, par3, par4 - b1) != this.blockID) && (par1World.getBlockId(par2 - b0, par3, par4 - b1) != Block.glowStone.blockID || par1World.getBlockId(par2 + b0, par3, par4 + b1) != this.blockID))
                    {
                        par1World.setBlockToAir(par2, par3, par4);
                    }
                }
            }
            else
            {
                par1World.setBlockToAir(par2, par3, par4);
            }
        }
	}

}
