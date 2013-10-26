package powell.cellarium.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class TearsOfChildren extends Fluid
{
	public TearsOfChildren()
	{
		super("TearsOfChildren");
		
		setDensity(10);
		setViscosity(1000);
		setLuminosity(15);//makes liquid give off light
		setUnlocalizedName("tearsOfChildren");
		FluidRegistry.registerFluid(this);
	}
}
