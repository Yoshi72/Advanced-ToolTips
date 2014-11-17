package Shirakami.ATT;

import java.io.File;
import java.util.HashMap;
import net.minecraftforge.common.config.Configuration;

public class ConfigHelper
{
	public static Configuration	cfg;

	public static void init()
	{
		cfg = new Configuration(new File("./config/ATT.cfg"));
		cfg.load();
		ATTinit();
		cfg.save();
	}

	public static boolean	showTooltipAll, showTooltipTools, showTooltipSwords, showTooltipArmor, showTooltipItems, showWailaLevel;
	public static boolean	showToolEfficiency, showToolLevel, showToolEnchantability, showToolDurability;
	public static boolean	showSwordEnchantability, showSwordDurability;
	public static boolean	showArmorType, showArmorReduction, showArmorEnchantability, showArmorDurability;

	public static int		colorItemDurability;
	public static int		colorToolEfficiency, colorToolLevel, colorToolEnchantability, colorToolDurability;
	public static int		colorSwordEnchantability, colorSwordDurability;
	public static int		colorArmorType, colorArmorReduction, colorArmorEnchantability, colorArmorDurability;

	public static void ATTinit()
	{
		cfg.addCustomCategoryComment("ATT", "Toggles specific tooltips on or off");
		showTooltipAll = cfg.getBoolean("showTooltipAll", "ATT", true, "All tooltips (effectively disabling this mod)");
		showTooltipTools = cfg.getBoolean("showTooltipTools", "ATT", true, "Tool tooltips");
		showTooltipSwords = cfg.getBoolean("showTooltipSwords", "ATT", true, "Sword tooltips");
		showTooltipArmor = cfg.getBoolean("showTooltipArmor", "ATT", true, "Armor tooltips");
		showTooltipItems = cfg.getBoolean("showTooltipItems", "ATT", true, "Durability tooltip for items");
		showWailaLevel = cfg.getBoolean("showWailaLevel", "ATT", true, "Prints the harvest level of tools as a Text instead of plain numbers (similiar to WAILA Harvestability) NOT IMPLEMENTED YET");

		cfg.addCustomCategoryComment("Tool", "Toggles specific tooltips for tools on or off");
		showToolEfficiency = cfg.getBoolean("showToolEfficiency", "Tools", true, "Efficiency of this tool (harvest speed modifier)");
		showToolLevel = cfg.getBoolean("showToolLevel", "Tools", true, "Harvest level of this tool");
		showToolEnchantability = cfg.getBoolean("showToolEnchantability", "Tools", true, "Enchantability of tool (higher numbers means higher level enchants)");
		showToolDurability = cfg.getBoolean("showToolDurability", "Tools", true, "Durability of this tool (durability left/durability max)");

		cfg.addCustomCategoryComment("Sword", "Toggles specific tooltips for swords on or off");
		showSwordEnchantability = cfg.getBoolean("DisplayswordEnchantability", "Swords", true, "Enchantability of this sword (higher numbers means higher level enchants)");
		showSwordDurability = cfg.getBoolean("DisplayswordDurability", "Swords", true, "Durability of this sword (durability left/durability max)");

		cfg.addCustomCategoryComment("Armor", "Toggles specific tooltips for armor on or off");
		showArmorType = cfg.getBoolean("showArmorType", "Armor", true, "Displays in which kind of armor (What kind of armor this is. Helmet, Chestplate, Leggings, Boots)");
		showArmorReduction = cfg.getBoolean("showArmorReduction", "Armor", true, "Damage reduction of this armor");
		showArmorEnchantability = cfg.getBoolean("showArmorEnchantability", "Armor", true, "Enchantability of this armor (higher numbers means higher level enchants)");
		showArmorDurability = cfg.getBoolean("showArmorDurability", "Armor", true, "Durability of this armor (durability left/durability max)");

		cfg.addCustomCategoryComment("Color", "Text color of your tooltips. 0 = BLACK, 1=DARK_BLUE, 2=DARK_GREEN, 3=DARK_AQUA, 4=DARK_RED, 5=DARK_PURPLE, 6=GOLD, 7=GRAY, 8=DARK_GRAY, 9=BLUE, 10=GREEN, 11=AQUA, 12=RED, 13=LIGHT_PURPLE, 14=YELLOW, 15=WHITE");
		colorItemDurability = cfg.getInt("colorItemDurability", "Color", 15, 0, 15, "Text color of item durability");
		colorToolEfficiency = cfg.getInt("colorToolEfficiency", "Color", 15, 0, 15, "Text color of tool efficency");
		colorToolLevel = cfg.getInt("colorToolLevel", "Color", 15, 0, 15, "Text color of tool harvest level");
		colorToolEnchantability = cfg.getInt("colorToolEnchantability", "Color", 0, 0, 15, "Text color of tool enchantability");
		colorToolDurability = cfg.getInt("colorToolDurability", "Color", 15, 0, 15, "Text color of tool durability");
		colorSwordEnchantability = cfg.getInt("colorSwordEnchantability", "Color", 0, 0, 15, "Text color of sword enchantability");
		colorSwordDurability = cfg.getInt("colorSwordDurability", "Color", 15, 0, 15, "Text color of sword durability");
		colorArmorType = cfg.getInt("colorArmorType", "Color", 15, 0, 15, "Text color of armor type");
		colorArmorReduction = cfg.getInt("colorArmorReduction", "Color", 15, 0, 15, "Text color of armor damage reduction");
		colorArmorEnchantability = cfg.getInt("colorArmorEnchantability", "Color", 15, 0, 15, "Text color of armor enchantability");
		colorArmorDurability = cfg.getInt("colorArmorDurability", "Color", 15, 0, 15, "Text color of armor durability");
	}
}
