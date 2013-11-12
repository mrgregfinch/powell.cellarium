package powell.rasterland.block;

import net.minecraft.block.Block;
import powell.rasterland.Rasterland;



public class OrangeRasterBlock extends RasterBlock 
{
    public OrangeRasterBlock(int par1) 
    {
            super(par1);
            this.setLightOpacity(15);
            setStepSound(Block.soundStoneFootstep);
            setCreativeTab(Rasterland.tabRasterland);
            setHardness(5F);
            setResistance(5F);
            setTextureName("rasterland:rasterBlockOrange");
            setUnlocalizedName("orangeRasterBlock");
    }

}