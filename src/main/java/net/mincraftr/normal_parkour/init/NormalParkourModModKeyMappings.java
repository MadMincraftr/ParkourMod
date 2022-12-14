
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mincraftr.normal_parkour.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mincraftr.normal_parkour.network.BuildToggleKeyMessage;
import net.mincraftr.normal_parkour.NormalParkourModMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class NormalParkourModModKeyMappings {
	public static final KeyMapping BUILD_TOGGLE_KEY = new KeyMapping("key.normal_parkour_mod.build_toggle_key", GLFW.GLFW_KEY_F4,
			"key.categories.parkour");

	@SubscribeEvent
	public static void registerKeyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(BUILD_TOGGLE_KEY);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == BUILD_TOGGLE_KEY.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						NormalParkourModMod.PACKET_HANDLER.sendToServer(new BuildToggleKeyMessage(0, 0));
						BuildToggleKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}
	}
}
