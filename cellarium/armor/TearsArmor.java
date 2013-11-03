package powell.cellarium.armor;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import powell.cellarium.Cellarium;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TearsArmor extends ItemArmor
{
	String itemTexture;
	String armorTexture;
	
	public TearsArmor(int id, EnumArmorMaterial material, int renderIndex, int slotType, String itemTexture, String armorTexture)
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
            return "cellarium:textures/models/armor/" + armorTexture + "_layer_2.png";
        else
            return "cellarium:textures/models/armor/" + armorTexture + "_layer_1.png";
    }
}
