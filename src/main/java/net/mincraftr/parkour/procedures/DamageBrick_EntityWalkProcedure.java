package net.mincraftr.parkour.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

public class DamageBrick_EntityWalkProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.hurt(new DamageSource("damagebrick").bypassArmor(), 4);
	}
}
