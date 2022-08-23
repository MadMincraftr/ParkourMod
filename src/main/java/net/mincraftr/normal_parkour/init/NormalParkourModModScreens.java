
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mincraftr.normal_parkour.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mincraftr.normal_parkour.client.gui.WinScreenScreen;
import net.mincraftr.normal_parkour.client.gui.SuperBlockConfigScreen;
import net.mincraftr.normal_parkour.client.gui.EffectBlockGuiScreen;
import net.mincraftr.normal_parkour.client.gui.DebugGuiRuncodeScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class NormalParkourModModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(NormalParkourModModMenus.SUPER_BLOCK_CONFIG, SuperBlockConfigScreen::new);
			MenuScreens.register(NormalParkourModModMenus.EFFECT_BLOCK_GUI, EffectBlockGuiScreen::new);
			MenuScreens.register(NormalParkourModModMenus.DEBUG_GUI_RUNCODE, DebugGuiRuncodeScreen::new);
			MenuScreens.register(NormalParkourModModMenus.WIN_SCREEN, WinScreenScreen::new);
		});
	}
}
