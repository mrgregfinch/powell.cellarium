package powell.cellarium.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class Blood extends Fluid
{
	public Blood()
	{
		super("FluidBlood");

		setDensity(10);
		setViscosity(1000);
		//setLuminosity(15);//makes liquid give off light
		setUnlocalizedName("blood");
		FluidRegistry.registerFluid(this);
	}
}
