package net.mincraftr.normal_parkour.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

public class MobRemoverActionProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.level.isClientSide())
			entity.discard();
		if (entity instanceof LivingEntity _entity)
			_entity.hurt(new DamageSource("mobremover").bypassArmor(), 30);
	}
}
