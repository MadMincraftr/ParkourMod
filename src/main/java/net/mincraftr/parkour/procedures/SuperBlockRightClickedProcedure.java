package net.mincraftr.parkour.procedures;

import net.minecraft.world.entity.Entity;

import net.mincraftr.parkour.network.MadmincraftrsParkourModModVariables;

public class SuperBlockRightClickedProcedure {
	public static void execute(Entity entity, double hitX, double hitY, double hitZ) {
		if (entity == null)
			return;
		{
			double _setval = hitX;
			entity.getCapability(MadmincraftrsParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.CustomBlockX = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = hitY;
			entity.getCapability(MadmincraftrsParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.CustomBlockY = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = hitZ;
			entity.getCapability(MadmincraftrsParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.CustomBlockZ = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
