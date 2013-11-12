package powell.rasterland.world;

import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import powell.rasterland.Rasterland;
import powell.rasterland.biome.Biomes;
import powell.rasterland.chunk.ChunkProviderVoid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderVoid extends WorldProvider
{
	
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(Biomes.test, 0.2F, 0);
		this.dimensionId = Rasterland.DIMENSIONID;
	}
	
	
	public IChunkProvider createChunkProvider()
	{
		return new ChunkProviderVoid(worldObj, worldObj.getSeed(), true);
	}
	

	@Override
	public String getDimensionName()
	{
		// TODO Auto-generated method stub
		return "Void Dimension";
	}
	
	
	// the below to things turn the sky black(ish) but not what i'm looking for, need to keep trying.
	/*@Override
	@SideOnly(Side.CLIENT)
	public Vec3 getSkyColor(Entity cameraEntity, float partialTicks)
	{
	         return this.worldObj.getWorldVec3Pool().getVecFromPool(0, 0, 0);
	}

	
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isSkyColored()
	{
		return true;
	}*/
	
	

}
