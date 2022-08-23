package net.mincraftr.normal_parkour.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mincraftr.normal_parkour.network.NormalParkourModModVariables;
import net.mincraftr.normal_parkour.init.NormalParkourModModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BrickProtectionCheckProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingUpdateEvent event) {
		execute(event, event.getEntityLiving());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (1 == EnchantmentHelper.getItemEnchantmentLevel(NormalParkourModModEnchantments.BRICK_PROTECTION.get(),
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY))) {
			{
				boolean _setval = true;
				entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HasBrickProtection = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				boolean _setval = false;
				entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HasBrickProtection = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
