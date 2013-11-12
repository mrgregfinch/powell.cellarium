package powell.rasterland.world;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.DimensionManager;
import powell.rasterland.Rasterland;
import powell.rasterland.chunk.RasterlandChunkManager;
import powell.rasterland.chunk.RasterlandChunkProvider;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RasterlandWorldProvider extends WorldProvider
{
	
	@Override
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new RasterlandChunkManager(worldObj.getSeed(), terrainType);
		this.hasNoSky = false;//maybe set to true to create the effect wanted?
	}

	@Override
	public String getDimensionName()
	{
		// TODO Auto-generated method stub
		return "Rasterland";
	}
	
	public static WorldProvider getProviderForDimension(int id)
	{
		return DimensionManager.createProviderFor(Rasterland.DIMENSIONID);
	}
	
	@Override
	public String getWelcomeMessage()
	{
		return "Welcome to the Rasterland";
	}
	
	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new RasterlandChunkProvider(worldObj, worldObj.getSeed(), true);
	}
	
	@Override
	public boolean canRespawnHere()
	{
		return true;
	}
	
	//testing:
//	 @SideOnly(Side.CLIENT)
//	    public boolean isSkyColored()
//	    {
//	        return false;
//	    }
	    public float getCloudHeight()
	    {
	        return 0.0F;
	    }
//	    public boolean isSurfaceWorld()
//	    {
//	        return false;
//	    }
	    
	    public float[] calcSunriseSunsetColors(float par1, float par2)
	    {
	        return null;
	    }

}
