package net.mincraftr.normal_parkour.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;

import net.mincraftr.normal_parkour.network.NormalParkourModModVariables;

import java.util.HashMap;

public class SuperBlockConfigSaveProcedure {
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
				_blockEntity.getTileData().putString("Speed1",
						(guistate.containsKey("text:SpeedAmount") ? ((EditBox) guistate.get("text:SpeedAmount")).getValue() : ""));
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
				_blockEntity.getTileData().putString("Speed2",
						(guistate.containsKey("text:SpeedTime") ? ((EditBox) guistate.get("text:SpeedTime")).getValue() : ""));
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
				_blockEntity.getTileData().putString("Jump1",
						(guistate.containsKey("text:JumpAmount") ? ((EditBox) guistate.get("text:JumpAmount")).getValue() : ""));
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
				_blockEntity.getTileData().putString("Jump2",
						(guistate.containsKey("text:JumpTime") ? ((EditBox) guistate.get("text:JumpTime")).getValue() : ""));
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
				_blockEntity.getTileData().putBoolean("DoSpeed",
						(guistate.containsKey("checkbox:SpeedToggle") ? ((Checkbox) guistate.get("checkbox:SpeedToggle")).selected() : false));
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
				_blockEntity.getTileData().putBoolean("DoJump",
						(guistate.containsKey("checkbox:JumpToggle") ? ((Checkbox) guistate.get("checkbox:JumpToggle")).selected() : false));
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}
}
