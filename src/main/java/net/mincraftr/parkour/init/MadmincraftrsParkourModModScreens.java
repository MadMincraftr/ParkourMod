
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mincraftr.parkour.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mincraftr.parkour.client.gui.SuperBlockConfigScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MadmincraftrsParkourModModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(MadmincraftrsParkourModModMenus.SUPER_BLOCK_CONFIG, SuperBlockConfigScreen::new);
		});
	}
}
