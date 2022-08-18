package net.mincraftr.normal_parkour.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.EditBox;

import net.mincraftr.normal_parkour.network.NormalParkourModModVariables;

import java.util.HashMap;

public class EffectBlockGuiLoadProcedure {
	public static void execute(LevelAccessor world, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (guistate.get("text:effect") instanceof EditBox _tf)
			_tf.setValue((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(world,
					new BlockPos(
							(entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NormalParkourModModVariables.PlayerVariables())).CustomBlockX,
							(entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NormalParkourModModVariables.PlayerVariables())).CustomBlockY,
							(entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NormalParkourModModVariables.PlayerVariables())).CustomBlockZ),
					"Effect")));
		if (guistate.get("text:amount") instanceof EditBox _tf)
			_tf.setValue((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(world,
					new BlockPos(
							(entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NormalParkourModModVariables.PlayerVariables())).CustomBlockX,
							(entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NormalParkourModModVariables.PlayerVariables())).CustomBlockY,
							(entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NormalParkourModModVariables.PlayerVariables())).CustomBlockZ),
					"Level")));
		if (guistate.get("text:ticks") instanceof EditBox _tf)
			_tf.setValue((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(world,
					new BlockPos(
							(entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NormalParkourModModVariables.PlayerVariables())).CustomBlockX,
							(entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NormalParkourModModVariables.PlayerVariables())).CustomBlockY,
							(entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NormalParkourModModVariables.PlayerVariables())).CustomBlockZ),
					"Ticks")));
	}
}
