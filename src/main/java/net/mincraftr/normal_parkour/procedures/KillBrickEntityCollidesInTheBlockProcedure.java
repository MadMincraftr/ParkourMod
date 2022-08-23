package net.mincraftr.normal_parkour.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

import net.mincraftr.normal_parkour.network.NormalParkourModModVariables;

public class KillBrickEntityCollidesInTheBlockProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NormalParkourModModVariables.PlayerVariables())).HasBrickProtection) {
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if ((entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NormalParkourModModVariables.PlayerVariables())).PortalCheck) {
						if (entity instanceof LivingEntity _entity)
							_entity.hurt(new DamageSource("killbrick.portal").bypassArmor(), 99999);
					} else {
						if (entity instanceof LivingEntity _entity)
							_entity.hurt(new DamageSource("killbrick").bypassArmor(), 99999);
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, 3);
		}
	}
}
