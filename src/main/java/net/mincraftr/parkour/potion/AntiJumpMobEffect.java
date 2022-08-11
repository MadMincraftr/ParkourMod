
package net.mincraftr.parkour.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class AntiJumpMobEffect extends MobEffect {
	public AntiJumpMobEffect() {
		super(MobEffectCategory.HARMFUL, -13680856);
	}

	@Override
	public String getDescriptionId() {
		return "effect.madmincraftrs_parkour_mod.anti_jump";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
