package powell.rasterland.world;

import powell.rasterland.Rasterland;
import powell.rasterland.chunk.ChunkProviderVoid;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderVoid extends WorldProvider
{
	
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.desertHills, 0.2F, 0);
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

}
