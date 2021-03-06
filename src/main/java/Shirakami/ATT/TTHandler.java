package Shirakami.ATT;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class TTHandler
{

	@SubscribeEvent
	public void onItemTooltip(ItemTooltipEvent event)
	{
		if (event.entityPlayer == null)
			return;

		if (event.getResult() == Result.DENY)
			return;

		Item item = event.itemStack.getItem();
		ItemStack stack = event.itemStack;

		if (ConfigHelper.showTooltipAll = true)
		{
			// Tools
			if (ConfigHelper.showTooltipTools = true && item instanceof ItemTool)
			{
				ItemTool tool = (ItemTool) item;

				// Efficiency
				if (ConfigHelper.showToolEfficiency = true)
					event.toolTip.add("\u00a7" + Integer.toHexString(ConfigHelper.colorToolEfficiency) + StatCollector.translateToLocal("tooltip.efficiency") + ": " + tool.func_150913_i().getEfficiencyOnProperMaterial());

				// Harvest Level
				if (ConfigHelper.showToolLevel = true)
				{
					if (tool.getHarvestLevel(stack, "axe") >= 0)
						event.toolTip.add("\u00a7" + Integer.toHexString(ConfigHelper.colorToolLevel) + StatCollector.translateToLocal("tooltip.harvestLevelAxe") + ": " + getHarvestLevel(tool.getHarvestLevel(stack, "axe")));
					if (tool.getHarvestLevel(stack, "shovel") >= 0)
						event.toolTip.add("\u00a7" + Integer.toHexString(ConfigHelper.colorToolLevel) + StatCollector.translateToLocal("tooltip.harvestLevelShovel") + ": " + getHarvestLevel(tool.getHarvestLevel(stack, "shovel")));
					if (tool.getHarvestLevel(stack, "pickaxe") >= 0)
						event.toolTip.add("\u00a7" + Integer.toHexString(ConfigHelper.colorToolLevel) + StatCollector.translateToLocal("tooltip.harvestLevelPickaxe") + ": " + getHarvestLevel(tool.getHarvestLevel(stack, "pickaxe")));
				}
				// Enchantability
				if (ConfigHelper.showToolEnchantability = true)
					event.toolTip.add("\u00a7" + Integer.toHexString(ConfigHelper.colorToolEnchantability) + StatCollector.translateToLocal("tooltip.enchantability") + ": " + tool.getItemEnchantability());

				// Durability
				if (ConfigHelper.showToolDurability = true)
					if (item.getMaxDamage() > 0)
						event.toolTip.add("\u00a7" + Integer.toHexString(ConfigHelper.colorToolDurability) + StatCollector.translateToLocal("tooltip.durability") + ": " + (stack.getMaxDamage() - stack.getItemDamage()) + "/" + (stack.getMaxDamage()));
					else
						event.toolTip.add("\u00a7" + Integer.toHexString(ConfigHelper.colorToolDurability) + StatCollector.translateToLocal("tooltip.durabilityInfinite"));
			}

			// Swords
			else if (ConfigHelper.showTooltipSwords = true && item instanceof ItemSword)
			{
				ItemSword sword = (ItemSword) item;

				// Enchantability
				if (ConfigHelper.showSwordEnchantability = true)
					event.toolTip.add("\u00a7" + Integer.toHexString(ConfigHelper.colorSwordEnchantability) + StatCollector.translateToLocal("tooltip.enchantability") + ": " + sword.getItemEnchantability());

				// Durability
				if (ConfigHelper.showSwordDurability = true)
					if (item.getMaxDamage() > 0)
						event.toolTip.add("\u00a7" + Integer.toHexString(ConfigHelper.colorSwordDurability) + StatCollector.translateToLocal("tooltip.durability") + ": " + (stack.getMaxDamage() - stack.getItemDamage()) + "/" + (stack.getMaxDamage()));
					else
						event.toolTip.add("\u00a7" + Integer.toHexString(ConfigHelper.colorSwordDurability) + StatCollector.translateToLocal("tooltip.durabilityInfinite"));
			}
			
			else if (ConfigHelper.showTooltipBow = true && item instanceof ItemBow)
			{
				ItemBow bow = (ItemBow) item;
				if (ConfigHelper.showBowDuration = true)
					event.toolTip.add("\u00a7" + Integer.toHexString(ConfigHelper.colorBowDuration) + StatCollector.translateToLocal("tooltip.bowDuration") + ": " + bow.getMaxItemUseDuration(stack));
				if (ConfigHelper.showBowEnchantability = true)
					if (bow.getItemEnchantability() > 0)
						event.toolTip.add("\u00a7" + Integer.toHexString(ConfigHelper.colorBowEnchantability) + StatCollector.translateToLocal("tooltip.enchantability") + ": " + item.getItemEnchantability());
				if (ConfigHelper.showBowDurability = true)
					if (bow.getMaxDamage() > 0)
						event.toolTip.add("\u00a7" + Integer.toHexString(ConfigHelper.colorBowDurability) + StatCollector.translateToLocal("tooltip.durability") + ": " + (stack.getMaxDamage() - stack.getItemDamage()) + "/" + (stack.getMaxDamage()));
			}

			// Armor
			else if (ConfigHelper.showTooltipArmor = true && item instanceof ItemArmor)
			{
				ItemArmor armor = (ItemArmor) item;

				// Armor Type
				if (ConfigHelper.showArmorType = true)
					if (armor.armorType == 0)
						event.toolTip.add("\u00a7" + Integer.toHexString(ConfigHelper.colorArmorType) + StatCollector.translateToLocal("tooltip.armorType") + ": " + StatCollector.translateToLocal("tooltip.armorHelmet"));
					else if (armor.armorType == 1)
						event.toolTip.add("\u00a7" + Integer.toHexString(ConfigHelper.colorArmorType) + StatCollector.translateToLocal("tooltip.armorType") + ": " + StatCollector.translateToLocal("tooltip.armorChestplate"));
					else if (armor.armorType == 2)
						event.toolTip.add("\u00a7" + Integer.toHexString(ConfigHelper.colorArmorType) + StatCollector.translateToLocal("tooltip.armorType") + ": " + StatCollector.translateToLocal("tooltip.armorLeggings"));
					else if (armor.armorType == 3)
						event.toolTip.add("\u00a7" + Integer.toHexString(ConfigHelper.colorArmorType) + StatCollector.translateToLocal("tooltip.armorType") + ": " + StatCollector.translateToLocal("tooltip.armorBoots"));

				// Damage Reduction
				if (ConfigHelper.showArmorReduction = true)
					event.toolTip.add("\u00a7" + Integer.toHexString(ConfigHelper.colorArmorReduction) + StatCollector.translateToLocal("tooltip.damageReduction") + ": " + armor.damageReduceAmount);

				// Enchantability
				if (ConfigHelper.showArmorEnchantability = true)
					event.toolTip.add("\u00a7" + Integer.toHexString(ConfigHelper.colorArmorEnchantability) + StatCollector.translateToLocal("tooltip.enchantability") + ": " + armor.getItemEnchantability());

				// Durability
				if (ConfigHelper.showArmorDurability = true)
					if (item.getMaxDamage() > 0)
						event.toolTip.add("\u00a7" + Integer.toHexString(ConfigHelper.colorArmorDurability) + StatCollector.translateToLocal("tooltip.durability") + ": " + (stack.getMaxDamage() - stack.getItemDamage()) + "/" + (stack.getMaxDamage()));
					else
						event.toolTip.add("\u00a7" + Integer.toHexString(ConfigHelper.colorArmorDurability) + StatCollector.translateToLocal("tooltip.durabilityInfinite"));
			}
			
			else if (ConfigHelper.showTooltipFood = true && item instanceof ItemFood)
			{
				ItemFood food = (ItemFood) item;
				if (ConfigHelper.showFoodDuration = true)
					event.toolTip.add("\u00a7" + Integer.toHexString(ConfigHelper.colorFoodDuration) + StatCollector.translateToLocal("tooltip.foodDuration") + ": " + food.getMaxItemUseDuration(stack));
				if (ConfigHelper.showFoodHunger = true)
					event.toolTip.add("\u00a7" + Integer.toHexString(ConfigHelper.colorFoodHunger) + StatCollector.translateToLocal("tooltip.foodHunger") + ": " + food.func_150905_g(stack));
				if (ConfigHelper.showFoodSaturation = true)
					event.toolTip.add("\u00a7" + Integer.toHexString(ConfigHelper.colorFoodSaturation) + StatCollector.translateToLocal("tooltip.foodSaturation") + ": " + food.func_150906_h(stack));
			}
			

			// All other Items
			else if (ConfigHelper.showTooltipItems = true)
			{
				if (ConfigHelper.showItemEnchantability = true)
					if (item.getItemEnchantability() > 0)
						event.toolTip.add("\u00a7" + Integer.toHexString(ConfigHelper.colorItemEnchantability) + StatCollector.translateToLocal("tooltip.enchantability") + ": " + item.getItemEnchantability());
				if (ConfigHelper.showItemDurability = true)
					if (item.getMaxDamage() > 0)
						event.toolTip.add("\u00a7" + Integer.toHexString(ConfigHelper.colorItemDurability) + StatCollector.translateToLocal("tooltip.durability") + ": " + (stack.getMaxDamage() - stack.getItemDamage()) + "/" + (stack.getMaxDamage()));
			}
		}
	}

	private String getHarvestLevel(int level)
	{
		if (ConfigHelper.showWailaLevel == true)
		{
			switch (level)
			{
			case 0:
				return StatCollector.translateToLocal("harvestLevel0");
			case 1:
				return StatCollector.translateToLocal("harvestLevel1");
			case 2:
				return StatCollector.translateToLocal("harvestLevel2");
			case 3:
				return StatCollector.translateToLocal("harvestLevel3");
			case 4:
				return StatCollector.translateToLocal("harvestLevel4");
			case 5:
				return StatCollector.translateToLocal("harvestLevel5");
			case 6:
				return StatCollector.translateToLocal("harvestLevel6");
			default:
				return Integer.toString(level);
			}
		}
		else
			return Integer.toString(level);
	}
}
