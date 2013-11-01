package powell.cellarium.armor;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.Property;
import powell.cellarium.CellariumConfiguration;
import powell.cellarium.DefaultProps;

public class Armors
{
	public static Item bloodHelmet;
	public static Item bloodChest;
	public static Item bloodPants;
	public static Item bloodBoots;
	
	
	
	public static void init(CellariumConfiguration main)
	{
		EnumArmorMaterial bloodMaterial = EnumHelper.addArmorMaterial("blood", 33, new int[] { 1, 3, 2, 1 }, 15);
		
		Property bloodHelmetId = main.getItem("bloodHelmet.id", DefaultProps.BLOOD_HELMET);
		Property bloodChestId = main.getItem("bloodChest.id", DefaultProps.BLOOD_CHEST);
		Property bloodPantsId = main.getItem("bloodPants.id", DefaultProps.BLOOD_PANTS);
		Property bloodBootsId = main.getItem("bloodBoots.id", DefaultProps.BLOOD_BOOTS);
		
		bloodHelmet = new BloodArmor(bloodHelmetId.getInt(), bloodMaterial, 1, 0, "bloodHelmet", "blood");
		bloodChest = new BloodArmor(bloodChestId.getInt(), bloodMaterial, 1, 1, "bloodChest", "blood");
		bloodPants = new BloodArmor(bloodPantsId.getInt(), bloodMaterial, 1, 2, "bloodPants", "blood");
		bloodBoots = new BloodArmor(bloodBootsId.getInt(), bloodMaterial, 1, 3, "bloodBoots", "blood");
		
	}
}
