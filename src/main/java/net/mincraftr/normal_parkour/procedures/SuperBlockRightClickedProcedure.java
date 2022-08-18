package net.mincraftr.normal_parkour.procedures;

import net.minecraft.world.entity.Entity;

import net.mincraftr.normal_parkour.network.NormalParkourModModVariables;

public class SuperBlockRightClickedProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = x;
			entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.CustomBlockX = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = y;
			entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.CustomBlockY = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = z;
			entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.CustomBlockZ = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
