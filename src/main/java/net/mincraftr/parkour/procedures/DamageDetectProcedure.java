package net.mincraftr.parkour.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingFallEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.BlockPos;

import net.mincraftr.parkour.init.MadmincraftrsParkourModModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DamageDetectProcedure {
	@SubscribeEvent
	public static void onEntityFall(LivingFallEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(),
					event.getDistance());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double distance) {
		execute(null, world, x, y, z, entity, distance);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, double distance) {
		if (entity == null)
			return;
		if (distance >= 3.3 && MadmincraftrsParkourModModBlocks.KILL_BRICK.get() == (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock()) {
			if (entity instanceof LivingEntity _entity)
				_entity.hurt(new DamageSource("killbrick.fall").bypassArmor(), 999999);
		}
	}
}
