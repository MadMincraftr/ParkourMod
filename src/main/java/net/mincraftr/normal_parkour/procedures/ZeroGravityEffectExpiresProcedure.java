package net.mincraftr.normal_parkour.procedures;

import net.minecraft.world.entity.Entity;

public class ZeroGravityEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null)
				_ent.getServer().getCommands().performCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
						"attribute @s forge:entity_gravity base set 0.08");
		}
	}
}
