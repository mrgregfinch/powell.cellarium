package powell.rasterland;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderVoid extends WorldProvider
{
	
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(null, 0.2F, 0);
		this.dimensionId = Rasterland.DIMENSIONID;
	}
	
	public IChunkProvider createChunkProvider()
	{
		return new ChunkProviderVoid();
	}
	

	@Override
	public String getDimensionName()
	{
		// TODO Auto-generated method stub
		return "Void Dimension";
	}

}
