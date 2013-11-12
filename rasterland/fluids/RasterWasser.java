package powell.rasterland.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class RasterWasser extends Fluid
{
	public RasterWasser()
	{
		super("rasterWasser");
		
		setDensity(11);
		setViscosity(1000);
		setLuminosity(15);//makes liquid give off light
		setUnlocalizedName("rasterWasser");
		FluidRegistry.registerFluid(this);
	}
}
