
package net.mincraftr.normal_parkour.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mincraftr.normal_parkour.procedures.ZeroGravityEffectStartedProcedure;
import net.mincraftr.normal_parkour.procedures.ZeroGravityEffectExpiresProcedure;

public class ZeroGravityMobEffect extends MobEffect {
	public ZeroGravityMobEffect() {
		super(MobEffectCategory.NEUTRAL, -4325121);
	}

	@Override
	public String getDescriptionId() {
		return "effect.normal_parkour_mod.zero_gravity";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		ZeroGravityEffectStartedProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		ZeroGravityEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
