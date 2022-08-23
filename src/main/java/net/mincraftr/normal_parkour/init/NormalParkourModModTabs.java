
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mincraftr.normal_parkour.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class NormalParkourModModTabs {
	public static CreativeModeTab TAB_NORMAL_PARKOUR_TAB;

	public static void load() {
		TAB_NORMAL_PARKOUR_TAB = new CreativeModeTab("tabnormal_parkour_tab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(NormalParkourModModBlocks.KILL_BRICK.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
