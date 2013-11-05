package powell.cellarium.armor;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.Property;
import powell.cellarium.Cellarium;
import powell.cellarium.CellariumConfiguration;
import powell.cellarium.DefaultProps;

public class Armors
{
	public static final EnumArmorMaterial bloodMaterial = EnumHelper.addArmorMaterial("blood", 50, new int[] { 5, 10, 8, 5 }, 30);
	public static final EnumArmorMaterial tearsMaterial = EnumHelper.addArmorMaterial("tears", 10, new int[] { 1, 6, 4, 1 }, 30);
	
	public static Item bloodHelmet;
	public static Item bloodChest;
	public static Item bloodPants;
	public static Item bloodBoots;
	
	public static Item tearsHelmet;
	public static Item tearsChest;
	public static Item tearsPants;
	public static Item tearsBoots;
	
	
	
	
	public static void init(CellariumConfiguration main)
	{
		
		Property bloodHelmetId = main.getItem("bloodHelmet.id", DefaultProps.BLOOD_HELMET);
		Property bloodChestId = main.getItem("bloodChest.id", DefaultProps.BLOOD_CHEST);
		Property bloodPantsId = main.getItem("bloodPants.id", DefaultProps.BLOOD_PANTS);
		Property bloodBootsId = main.getItem("bloodBoots.id", DefaultProps.BLOOD_BOOTS);
		
		bloodHelmet = new BloodArmor(bloodHelmetId.getInt(), bloodMaterial, Cellarium.proxy.addArmor("blood"), 0, "bloodHelmet", "blood");
		bloodChest = new BloodArmor(bloodChestId.getInt(), bloodMaterial, Cellarium.proxy.addArmor("blood"), 1, "bloodChest", "blood");
		bloodPants = new BloodArmor(bloodPantsId.getInt(), bloodMaterial, Cellarium.proxy.addArmor("blood"), 2, "bloodPants", "blood");
		bloodBoots = new BloodArmor(bloodBootsId.getInt(), bloodMaterial, Cellarium.proxy.addArmor("blood"), 3, "bloodBoots", "blood");
		
		Property tearsHelmetId = main.getItem("tearsHelmet.id", DefaultProps.TEARS_HELMET);
		Property tearsChestId = main.getItem("tearsChest.id", DefaultProps.TEARS_CHEST);
		Property tearsPantsId = main.getItem("tearsPants.id", DefaultProps.TEARS_PANTS);
		Property tearsBootsId = main.getItem("tearsBoots.id", DefaultProps.TEARS_BOOTS);
		
		tearsHelmet = new TearsArmor(tearsHelmetId.getInt(),tearsMaterial, Cellarium.proxy.addArmor("tears"), 0, "tearsHelmet", "tears");
		tearsChest = new TearsArmor(tearsChestId.getInt(),tearsMaterial, Cellarium.proxy.addArmor("tears"), 1, "tearsChest", "tears");
		tearsPants = new TearsArmor(tearsPantsId.getInt(),tearsMaterial, Cellarium.proxy.addArmor("tears"), 2, "tearsPants", "tears");
		tearsBoots = new TearsArmor(tearsBootsId.getInt(),tearsMaterial, Cellarium.proxy.addArmor("tears"), 3, "tearsBoots", "tears");
		
	}
}
