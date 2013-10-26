package powell.cellarium.block.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class POPMaterial extends Material
{
	public POPMaterial()
	{
		super(MapColor.airColor);
	}
	
	@Override
	public boolean blocksMovement()
    {
        return false;
    }
	
	@Override
	public boolean isSolid()
    {
        return false;
    }
}
