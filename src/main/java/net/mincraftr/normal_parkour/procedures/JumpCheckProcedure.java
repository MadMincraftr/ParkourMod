package net.mincraftr.normal_parkour.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

import net.mincraftr.normal_parkour.init.NormalParkourModModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class JumpCheckProcedure {
	@SubscribeEvent
	public static void onEntityJump(LivingEvent.LivingJumpEvent event) {
		execute(event, event.getEntityLiving());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(NormalParkourModModMobEffects.ANTI_JUMP.get()) : false) {
			if (entity instanceof LivingEntity _entity)
				_entity.hurt(new DamageSource("antijump").bypassArmor(), 99999);
		}
	}
}
