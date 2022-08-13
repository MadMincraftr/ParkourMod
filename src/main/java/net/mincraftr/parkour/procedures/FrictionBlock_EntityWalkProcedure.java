package net.mincraftr.parkour.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class FrictionBlock_EntityWalkProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setDeltaMovement(
				new Vec3((entity.getDeltaMovement().x() * 1.3), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z() * 1.3)));
	}
}
