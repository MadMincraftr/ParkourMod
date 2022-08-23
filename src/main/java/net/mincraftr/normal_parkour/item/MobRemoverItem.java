
package net.mincraftr.normal_parkour.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

import net.mincraftr.normal_parkour.procedures.MobRemoverActionProcedure;
import net.mincraftr.normal_parkour.init.NormalParkourModModTabs;

public class MobRemoverItem extends SwordItem {
	public MobRemoverItem() {
		super(new Tier() {
			public int getUses() {
				return 999;
			}

			public float getSpeed() {
				return 999f;
			}

			public float getAttackDamageBonus() {
				return -2f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 1;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		}, 3, 96f, new Item.Properties().tab(NormalParkourModModTabs.TAB_NORMAL_PARKOUR_TAB).fireResistant());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		MobRemoverActionProcedure.execute(entity);
		return retval;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}
}
