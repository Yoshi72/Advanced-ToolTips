package Shirakami.ATT;

import java.io.File;

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

	public static boolean	showTooltipAll, showTooltipTools, showTooltipSwords, showTooltipBow, showTooltipArmor, showTooltipFood, showTooltipItems, showWailaLevel;
	public static boolean	showToolEfficiency, showToolLevel, showToolEnchantability, showToolDurability;
	public static boolean	showSwordEnchantability, showSwordDurability;
	public static boolean	showArmorType, showArmorReduction, showArmorEnchantability, showArmorDurability;
	public static boolean	showFoodHunger, showFoodSaturation, showFoodDuration;
	public static boolean	showItemDurability, showItemEnchantability;
	public static boolean	showBowDuration, showBowEnchantability, showBowDurability;

	public static int		colorToolEfficiency, colorToolLevel, colorToolEnchantability, colorToolDurability;
	public static int		colorSwordEnchantability, colorSwordDurability;
	public static int		colorBowDuration, colorBowEnchantability, colorBowDurability;
	public static int		colorArmorType, colorArmorReduction, colorArmorEnchantability, colorArmorDurability;
	public static int		colorFoodHunger, colorFoodSaturation, colorFoodDuration;
	public static int		colorItemDurability, colorItemEnchantability;

	public static void ATTinit()
	{
		cfg.addCustomCategoryComment("ATT", "Toggles specific tooltips on or off");
		showTooltipAll = cfg.getBoolean("showTooltipAll", "ATT", true, "All tooltips (effectively disabling this mod)");
		showTooltipTools = cfg.getBoolean("showTooltipTools", "ATT", true, "Tool tooltips");
		showTooltipSwords = cfg.getBoolean("showTooltipSwords", "ATT", true, "Sword tooltips");
		showTooltipBow = cfg.getBoolean("showTooltipBow", "ATT", true, "Bow tooltips");
		showTooltipArmor = cfg.getBoolean("showTooltipArmor", "ATT", true, "Armor tooltips");
		showTooltipFood = cfg.getBoolean("showTooltipFood", "ATT", true, "Food tooltips");
		showTooltipItems = cfg.getBoolean("showTooltipItems", "ATT", true, "Durability tooltip for items");
		showWailaLevel = cfg.getBoolean("showWailaLevel", "ATT", true, "Prints the harvest level of tools as a Text instead of plain numbers (similiar to WAILA Harvestability) NOT IMPLEMENTED YET");

		cfg.addCustomCategoryComment("Tool", "Toggles specific tooltips for tools on or off");
		showToolEfficiency = cfg.getBoolean("showToolEfficiency", "Tool", true, "Efficiency of this tool (harvest speed modifier)");
		showToolLevel = cfg.getBoolean("showToolLevel", "Tool", true, "Harvest level of this tool");
		showToolEnchantability = cfg.getBoolean("showToolEnchantability", "Tool", true, "Enchantability of tool (higher numbers means higher level enchants)");
		showToolDurability = cfg.getBoolean("showToolDurability", "Tool", true, "Durability of this tool (durability left/durability max)");

		cfg.addCustomCategoryComment("Sword", "Toggles specific tooltips for swords on or off");
		showSwordEnchantability = cfg.getBoolean("showSwordEnchantability", "Sword", true, "Enchantability of this sword (higher numbers means higher level enchants)");
		showSwordDurability = cfg.getBoolean("showSwordDurability", "Sword", true, "Durability of this sword (durability left/durability max)");
		
		cfg.addCustomCategoryComment("Bow", "Toggles specific tooltips for bows on or off");
		showBowDuration = cfg.getBoolean("showBowDuration", "Bow", true, "Using time of this bow (number of ticks to wait until fully charged)");
		showBowEnchantability = cfg.getBoolean("showBowEnchantability", "Bow", true, "Enchantability of this bow (higher numbers means higher level enchants)");
		showBowDurability = cfg.getBoolean("showBowDurability", "Bow", true, "Durability of this bow (durability left/durability max)");

		cfg.addCustomCategoryComment("Armor", "Toggles specific tooltips for armor on or off");
		showArmorType = cfg.getBoolean("showArmorType", "Armor", true, "Displays in which kind of armor (What kind of armor this is. Helmet, Chestplate, Leggings, Boots)");
		showArmorReduction = cfg.getBoolean("showArmorReduction", "Armor", true, "Damage reduction of this armor");
		showArmorEnchantability = cfg.getBoolean("showArmorEnchantability", "Armor", true, "Enchantability of this armor (higher numbers means higher level enchants)");
		showArmorDurability = cfg.getBoolean("showArmorDurability", "Armor", true, "Durability of this armor (durability left/durability max)");

		cfg.addCustomCategoryComment("Food", "Toggles specific tooltips for food on or off");
		showFoodDuration = cfg.getBoolean("showFoodDuration", "Food", true, "Using time of this food (number of ticks to wait until eaten)");
		showFoodHunger = cfg.getBoolean("showFoodHunger", "Food", true, "Hunger restoration of this food");
		showFoodSaturation = cfg.getBoolean("showFoodSaturation", "Food", true, "Saturation of this food (see http://minecraft.gamepedia.com/Food)");
		
		cfg.addCustomCategoryComment("Item", "Toggles specific tooltips for all other items on or off");
		showItemEnchantability = cfg.getBoolean("showItemEnchantability", "Item", true, "Enchantability of this item (higher numbers means higher level enchants)");
		showItemDurability = cfg.getBoolean("showItemDurability", "Item", true, "Durability of this item (durability left/durability max)");
		
		cfg.addCustomCategoryComment("Color", "Text color of your tooltips. 0 = BLACK, 1=DARK_BLUE, 2=DARK_GREEN, 3=DARK_AQUA, 4=DARK_RED, 5=DARK_PURPLE, 6=GOLD, 7=GRAY, 8=DARK_GRAY, 9=BLUE, 10=GREEN, 11=AQUA, 12=RED, 13=LIGHT_PURPLE, 14=YELLOW, 15=WHITE");
		colorToolEfficiency = cfg.getInt("colorToolEfficiency", "Color", 7, 0, 15, "Text color of tool efficency");
		colorToolLevel = cfg.getInt("colorToolLevel", "Color", 7, 0, 15, "Text color of tool harvest level");
		colorToolEnchantability = cfg.getInt("colorToolEnchantability", "Color", 7, 0, 15, "Text color of tool enchantability");
		colorToolDurability = cfg.getInt("colorToolDurability", "Color", 7, 0, 15, "Text color of tool durability");
		colorSwordEnchantability = cfg.getInt("colorSwordEnchantability", "Color", 7, 0, 15, "Text color of sword enchantability");
		colorSwordDurability = cfg.getInt("colorSwordDurability", "Color", 7, 0, 15, "Text color of sword durability");
		colorBowDuration = cfg.getInt("colorBowDuration", "Color", 7, 0, 15, "Text color of bow using time");
		colorBowEnchantability = cfg.getInt("colorBowEnchantability", "Color", 7, 0, 15, "Text color of bow enchantability");
		colorBowDurability = cfg.getInt("colorBowDurability", "Color", 7, 0, 15, "Text color of bow durability");
		colorArmorType = cfg.getInt("colorArmorType", "Color", 7, 0, 15, "Text color of armor type");
		colorArmorReduction = cfg.getInt("colorArmorReduction", "Color", 7, 0, 15, "Text color of armor damage reduction");
		colorArmorEnchantability = cfg.getInt("colorArmorEnchantability", "Color", 7, 0, 15, "Text color of armor enchantability");
		colorArmorDurability = cfg.getInt("colorArmorDurability", "Color", 7, 0, 15, "Text color of armor durability");
		colorFoodDuration = cfg.getInt("colorFoodDuration", "Color", 7, 0, 15, "Text color of food eating time");
		colorFoodHunger = cfg.getInt("colorFoodHunger", "Color", 7, 0, 15, "Text color of food hunger restoration");
		colorFoodSaturation = cfg.getInt("colorFoodSaturation", "Color", 7, 0, 15, "Text color of food saturation");
		colorItemEnchantability = cfg.getInt("colorItemEnchantability", "Color", 7, 0, 15, "Text color of item enchantability");
		colorItemDurability = cfg.getInt("colorItemDurability", "Color", 7, 0, 15, "Text color of item durability");
	}
}
