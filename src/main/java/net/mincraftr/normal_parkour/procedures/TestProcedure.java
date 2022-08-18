package net.mincraftr.normal_parkour.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Direction;

import net.mincraftr.normal_parkour.NormalParkourModMod;

public class TestProcedure {
	public static void execute(double x, double y, double z, BlockState blockstate, ResourceKey<Level> dimension, Direction direction, Entity entity,
			Entity immediatesourceentity, Entity sourceentity, ItemStack itemstack) {
		if (dimension == null || direction == null || entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		NormalParkourModMod.LOGGER
				.info(blockstate + "" + itemstack + x + y + z + entity + sourceentity + immediatesourceentity + direction + dimension);
	}
}
