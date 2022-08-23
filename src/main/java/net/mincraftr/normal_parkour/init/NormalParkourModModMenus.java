
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mincraftr.normal_parkour.init;

import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import net.mincraftr.normal_parkour.world.inventory.WinScreenMenu;
import net.mincraftr.normal_parkour.world.inventory.SuperBlockConfigMenu;
import net.mincraftr.normal_parkour.world.inventory.EffectBlockGuiMenu;
import net.mincraftr.normal_parkour.world.inventory.DebugGuiRuncodeMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NormalParkourModModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<SuperBlockConfigMenu> SUPER_BLOCK_CONFIG = register("super_block_config",
			(id, inv, extraData) -> new SuperBlockConfigMenu(id, inv, extraData));
	public static final MenuType<EffectBlockGuiMenu> EFFECT_BLOCK_GUI = register("effect_block_gui",
			(id, inv, extraData) -> new EffectBlockGuiMenu(id, inv, extraData));
	public static final MenuType<DebugGuiRuncodeMenu> DEBUG_GUI_RUNCODE = register("debug_gui_runcode",
			(id, inv, extraData) -> new DebugGuiRuncodeMenu(id, inv, extraData));
	public static final MenuType<WinScreenMenu> WIN_SCREEN = register("win_screen", (id, inv, extraData) -> new WinScreenMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
