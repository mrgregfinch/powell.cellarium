package powell.rasterland.world;

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
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isSkyColored()
	{
		return false;
	}
	
	

}
