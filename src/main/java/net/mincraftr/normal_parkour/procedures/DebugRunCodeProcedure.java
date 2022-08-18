package net.mincraftr.normal_parkour.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.EditBox;

import net.mincraftr.normal_parkour.NormalParkourModMod;

import java.util.HashMap;

public class DebugRunCodeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		NormalParkourModMod.LOGGER
				.info("Running Procedure #" + (guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : ""));
		if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("0")) {
			NormalParkourModMod.LOGGER.info("Procedure #0 is invalid");
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("1")) {
			KillBrickEntityCollidesInTheBlockProcedure.execute(world, entity);
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("2")) {
			JumpCheckProcedure.execute(entity);
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("3")) {
			CheckpointTriggerProcedure.execute(x, y, z, entity);
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("4")) {
			SpeedBlock_EntityWalkProcedure.execute(entity);
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("5")) {
			ToggleBuildProcedure.execute(entity);
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("6")) {
			SuperBlock_EntityWalkProcedure.execute(world, x, y, z, entity);
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("7")) {
			SuperBlockEntityWalksOnTheBlockProcedure.execute();
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("8")) {
			JumpBlock_EntityWalkProcedure.execute(entity);
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("9")) {
			DamageBrick_EntityWalkProcedure.execute(entity);
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("10")) {
			ZeroGravityEffectStartedProcedure.execute(entity);
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("11")) {
			ZeroGravityEffectExpiresProcedure.execute(entity);
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("12")) {
			SuperBlock2_EntityWalkProcedure.execute(entity);
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("13")) {
			FrictionBlock_EntityWalkProcedure.execute(entity);
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("14")) {
			SuperBlockRightClickedProcedure.execute(x, y, z, entity);
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("15")) {
			NormalParkourModMod.LOGGER.info("This Procedure ID was removed");
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("16")) {
			JumpCheck2Procedure.execute(world, x, y, z, entity);
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("17")) {
			SuperBlockConfigOpenTickProcedure.execute(world, x, y, z, guistate);
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("18")) {
			EffectBlockGuiSaveProcedure.execute(world, entity, guistate);
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("19")) {
			SuperBlockConfigSaveProcedure.execute(world, entity, guistate);
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("20")) {
			PortalCheckProcedure.execute(world, entity);
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("21")) {
			MobRemoverActionProcedure.execute(entity);
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("22")) {
			EffectBlockGuiLoadProcedure.execute(world, entity, guistate);
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("23")) {
			EffectBlock_EntityWalkProcedure.execute(world, x, y, z);
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("24")) {
			EffectBlockUpdateTickProcedure.execute(world, x, y, z);
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("25")) {
			ZeroGBlock_EntityWalkProcedure.execute(entity);
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("26")) {
			AntiJumpBlock_EntityWalkProcedure.execute(entity);
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("27")) {
			ClearBlock_EntityWalkProcedure.execute(entity);
		} else if ((guistate.containsKey("text:code") ? ((EditBox) guistate.get("text:code")).getValue() : "").equals("28")) {
			NormalParkourModMod.LOGGER.info("This Procedure ID was removed");
		} else {
			NormalParkourModMod.LOGGER.info("Invalid Procedure ID");
		}
	}
}
