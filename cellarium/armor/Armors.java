package powell.cellarium.armor;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.src.ModLoader;
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
	public static final EnumArmorMaterial bloodMaterial = EnumHelper.addArmorMaterial("blood", 33, new int[] { 5, 10, 8, 5 }, 30);
	
	
	
	
	public static void init(CellariumConfiguration main)
	{
		
		Property bloodHelmetId = main.getItem("bloodHelmet.id", DefaultProps.BLOOD_HELMET);
		Property bloodChestId = main.getItem("bloodChest.id", DefaultProps.BLOOD_CHEST);
		Property bloodPantsId = main.getItem("bloodPants.id", DefaultProps.BLOOD_PANTS);
		Property bloodBootsId = main.getItem("bloodBoots.id", DefaultProps.BLOOD_BOOTS);
		
		bloodHelmet = new BloodArmor(bloodHelmetId.getInt(), bloodMaterial, ModLoader.addArmor("blood"), 0, "bloodHelmet", "blood");
		bloodChest = new BloodArmor(bloodChestId.getInt(), bloodMaterial, ModLoader.addArmor("blood"), 1, "bloodChest", "blood");
		bloodPants = new BloodArmor(bloodPantsId.getInt(), bloodMaterial, ModLoader.addArmor("blood"), 2, "bloodPants", "blood");
		bloodBoots = new BloodArmor(bloodBootsId.getInt(), bloodMaterial, ModLoader.addArmor("blood"), 3, "bloodBoots", "blood");
		
	}
}
