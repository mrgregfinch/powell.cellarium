package powell.cellarium.armor;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import powell.cellarium.Cellarium;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BloodArmor extends ItemArmor
{
	String itemTexture;
	String armorTexture;
	
	public BloodArmor(int id, EnumArmorMaterial material, int renderIndex, int slotType, String itemTexture, String armorTexture)
	{
		super(id, material, renderIndex, slotType);
		this.itemTexture = itemTexture;
		this.armorTexture = armorTexture;
		setCreativeTab(Cellarium.tabCellarium);
		setUnlocalizedName("armor_" + itemTexture);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	 public void registerIcons (IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("cellarium:armor_" + itemTexture);
    }

    @Override
    public String getArmorTexture (ItemStack stack, Entity entity, int slot, int layer)
    {
        if (slot == 2)
            return "/assets/cellarium/textures/armor/" + armorTexture + "_2.png";
        else
            return "/assets/cellarium/textures/armor/" + armorTexture + "_1.png";
    }

    public void getSubItems (int id, CreativeTabs tab, List list)
    {
        switch (armorType)
        {
        case 0:
            list.add(new ItemStack(Armors.bloodHelmet));
            break;
        case 1:
            list.add(new ItemStack(Armors.bloodChest));
            break;
        case 2:
            list.add(new ItemStack(Armors.bloodPants));
            break;
        case 3:
            list.add(new ItemStack(Armors.bloodBoots));
            break;
        }
    }
}
