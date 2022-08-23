
package net.mincraftr.normal_parkour.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

public class BrickProtectionEnchantment extends Enchantment {
	public BrickProtectionEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.ARMOR_FEET, slots);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		if (stack.getItem() == Items.LEATHER_BOOTS)
			return true;
		if (stack.getItem() == Items.CHAINMAIL_BOOTS)
			return true;
		if (stack.getItem() == Items.IRON_BOOTS)
			return true;
		if (stack.getItem() == Items.GOLDEN_BOOTS)
			return true;
		if (stack.getItem() == Items.DIAMOND_BOOTS)
			return true;
		if (stack.getItem() == Items.NETHERITE_BOOTS)
			return true;
		return false;
	}

	@Override
	public boolean isDiscoverable() {
		return false;
	}

	@Override
	public boolean isTradeable() {
		return false;
	}
}
