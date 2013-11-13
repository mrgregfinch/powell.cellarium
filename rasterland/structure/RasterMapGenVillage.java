package powell.rasterland.structure;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import powell.rasterland.biome.Biomes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraft.world.gen.structure.StructureVillageStart;

public class RasterMapGenVillage extends MapGenStructure
{
    /** A list of all the biomes villages can spawn in. */
    public static List villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] {Biomes.orange, Biomes.yellow, Biomes.green, Biomes.blue, Biomes.purple});

    /** World terrain type, 0 for normal, 1 for flat map */
    private int terrainType;
    private int field_82665_g;
    private int field_82666_h;

    public RasterMapGenVillage()
    {
        this.field_82665_g = 32;
        this.field_82666_h = 8;
    }

    public RasterMapGenVillage(Map par1Map)
    {
        this();
        Iterator iterator = par1Map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Entry entry = (Entry)iterator.next();

            if (((String)entry.getKey()).equals("size"))
            {
                this.terrainType = MathHelper.parseIntWithDefaultAndMax((String)entry.getValue(), this.terrainType, 0);
            }
            else if (((String)entry.getKey()).equals("distance"))
            {
                this.field_82665_g = MathHelper.parseIntWithDefaultAndMax((String)entry.getValue(), this.field_82665_g, this.field_82666_h + 1);
            }
        }
    }

    public String func_143025_a()
    {
        return "Village";
    }

    protected boolean canSpawnStructureAtCoords(int par1, int par2)
    {
    	 int k = par1;
        int l = par2;

        if (par1 < 0)
        {
            par1 -= this.field_82665_g - 1;
        }

        if (par2 < 0)
        {
            par2 -= this.field_82665_g - 1;
        }

        int i1 = par1 / this.field_82665_g;
        int j1 = par2 / this.field_82665_g;
        Random random = this.worldObj.setRandomSeed(i1, j1, 10387312);
        i1 *= this.field_82665_g;
        j1 *= this.field_82665_g;
        i1 += random.nextInt(this.field_82665_g - this.field_82666_h);
        j1 += random.nextInt(this.field_82665_g - this.field_82666_h);

        if (k == i1 && l == j1)
        {
            boolean flag = this.worldObj.getWorldChunkManager().areBiomesViable(k * 16 + 8, l * 16 + 8, 0, villageSpawnBiomes);

            if (flag)
            {
            	System.out.println("8888888888888888888888888888found a suitable biome888888888888888888888888888888888");
                return true;
            }
        }

        return false;
    }

    protected StructureStart getStructureStart(int par1, int par2)
    {
        return new StructureVillageStart(this.worldObj, this.rand, par1, par2, this.terrainType);
    }
}
