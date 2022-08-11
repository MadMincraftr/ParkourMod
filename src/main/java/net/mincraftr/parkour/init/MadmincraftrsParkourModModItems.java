
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mincraftr.parkour.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mincraftr.parkour.MadmincraftrsParkourModMod;

public class MadmincraftrsParkourModModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MadmincraftrsParkourModMod.MODID);
	public static final RegistryObject<Item> KILL_BRICK = block(MadmincraftrsParkourModModBlocks.KILL_BRICK,
			MadmincraftrsParkourModModTabs.TAB_MAD_MINCRAFTR_PARKOUR);
	public static final RegistryObject<Item> CHECKPOINT_BLOCK = block(MadmincraftrsParkourModModBlocks.CHECKPOINT_BLOCK,
			MadmincraftrsParkourModModTabs.TAB_MAD_MINCRAFTR_PARKOUR);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
