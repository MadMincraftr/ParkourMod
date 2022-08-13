package net.mincraftr.parkour.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.BlockPos;

import net.mincraftr.parkour.init.MadmincraftrsParkourModModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class JumpCheck2Procedure {
	@SubscribeEvent
	public static void onEntityJump(LivingEvent.LivingJumpEvent event) {
		execute(event, event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(),
				event.getEntityLiving());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (MadmincraftrsParkourModModBlocks.KILL_BRICK.get() == (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock()) {
			if (entity instanceof LivingEntity _entity)
				_entity.hurt(new DamageSource("killbrick.head").bypassArmor(), 99999);
		}
	}
}
