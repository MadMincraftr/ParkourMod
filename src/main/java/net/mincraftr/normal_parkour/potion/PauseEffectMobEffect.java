
package net.mincraftr.normal_parkour.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mincraftr.normal_parkour.procedures.PauseEffectStartedProcedure;
import net.mincraftr.normal_parkour.procedures.PauseEffectExpiresProcedure;

public class PauseEffectMobEffect extends MobEffect {
	public PauseEffectMobEffect() {
		super(MobEffectCategory.HARMFUL, -3355444);
	}

	@Override
	public String getDescriptionId() {
		return "effect.normal_parkour_mod.pause_effect";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		PauseEffectStartedProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		PauseEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
