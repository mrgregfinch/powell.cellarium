package powell.cellarium.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class BoilingBlood extends Fluid
{
	public BoilingBlood()
	{
		super("BoilingBlood");
		
		setDensity(10);
		setViscosity(6000);
		setLuminosity(8);//makes liquid give off light
		setUnlocalizedName("boilingBlood");
		FluidRegistry.registerFluid(this);
	}
}
