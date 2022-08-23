package net.mincraftr.normal_parkour.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

import net.mincraftr.normal_parkour.network.NormalParkourModModVariables;

public class DamageBrick_EntityWalkProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NormalParkourModModVariables.PlayerVariables())).HasBrickProtection) {
			if (entity instanceof LivingEntity _entity)
				_entity.hurt(new DamageSource("damagebrick").bypassArmor(), 4);
		}
	}
}
