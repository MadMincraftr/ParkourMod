
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mincraftr.normal_parkour.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class NormalParkourModModTabs {
	public static CreativeModeTab TAB_MAD_MINCRAFTR_PARKOUR;

	public static void load() {
		TAB_MAD_MINCRAFTR_PARKOUR = new CreativeModeTab("tabmad_mincraftr_parkour") {
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
