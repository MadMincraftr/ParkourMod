package net.mincraftr.normal_parkour.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mincraftr.normal_parkour.init.NormalParkourModModMobEffects;

public class AntiJumpBlock_EntityWalkProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(NormalParkourModModMobEffects.ANTI_JUMP.get(), 10000000, 1));
	}
}
