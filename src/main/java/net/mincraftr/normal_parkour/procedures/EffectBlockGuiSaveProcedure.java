package net.mincraftr.normal_parkour.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.EditBox;

import net.mincraftr.normal_parkour.network.NormalParkourModModVariables;

import java.util.HashMap;

public class EffectBlockGuiSaveProcedure {
	public static void execute(LevelAccessor world, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (!world.isClientSide()) {
			BlockPos _bp = new BlockPos(
					(entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NormalParkourModModVariables.PlayerVariables())).CustomBlockX,
					(entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NormalParkourModModVariables.PlayerVariables())).CustomBlockY,
					(entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NormalParkourModModVariables.PlayerVariables())).CustomBlockZ);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getTileData().putString("Effect",
						(guistate.containsKey("text:effect") ? ((EditBox) guistate.get("text:effect")).getValue() : ""));
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if (!world.isClientSide()) {
			BlockPos _bp = new BlockPos(
					(entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NormalParkourModModVariables.PlayerVariables())).CustomBlockX,
					(entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NormalParkourModModVariables.PlayerVariables())).CustomBlockY,
					(entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NormalParkourModModVariables.PlayerVariables())).CustomBlockZ);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getTileData().putString("Ticks",
						(guistate.containsKey("text:ticks") ? ((EditBox) guistate.get("text:ticks")).getValue() : ""));
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if (!world.isClientSide()) {
			BlockPos _bp = new BlockPos(
					(entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NormalParkourModModVariables.PlayerVariables())).CustomBlockX,
					(entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NormalParkourModModVariables.PlayerVariables())).CustomBlockY,
					(entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NormalParkourModModVariables.PlayerVariables())).CustomBlockZ);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getTileData().putString("Level",
						(guistate.containsKey("text:amount") ? ((EditBox) guistate.get("text:amount")).getValue() : ""));
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}
}
