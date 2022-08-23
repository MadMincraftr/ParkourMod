
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mincraftr.normal_parkour.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mincraftr.normal_parkour.item.MobRemoverItem;
import net.mincraftr.normal_parkour.NormalParkourModMod;

public class NormalParkourModModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, NormalParkourModMod.MODID);
	public static final RegistryObject<Item> KILL_BRICK = block(NormalParkourModModBlocks.KILL_BRICK, NormalParkourModModTabs.TAB_NORMAL_PARKOUR_TAB);
	public static final RegistryObject<Item> CHECKPOINT_BLOCK = block(NormalParkourModModBlocks.CHECKPOINT_BLOCK,
			NormalParkourModModTabs.TAB_NORMAL_PARKOUR_TAB);
	public static final RegistryObject<Item> SPEED_BLOCK = block(NormalParkourModModBlocks.SPEED_BLOCK,
			NormalParkourModModTabs.TAB_NORMAL_PARKOUR_TAB);
	public static final RegistryObject<Item> FRICTION_BLOCK = block(NormalParkourModModBlocks.FRICTION_BLOCK,
			NormalParkourModModTabs.TAB_NORMAL_PARKOUR_TAB);
	public static final RegistryObject<Item> SUPER_BLOCK = block(NormalParkourModModBlocks.SUPER_BLOCK, null);
	public static final RegistryObject<Item> JUMP_BLOCK = block(NormalParkourModModBlocks.JUMP_BLOCK, NormalParkourModModTabs.TAB_NORMAL_PARKOUR_TAB);
	public static final RegistryObject<Item> DAMAGE_BRICK = block(NormalParkourModModBlocks.DAMAGE_BRICK,
			NormalParkourModModTabs.TAB_NORMAL_PARKOUR_TAB);
	public static final RegistryObject<Item> SUPER_BLOCK_2 = block(NormalParkourModModBlocks.SUPER_BLOCK_2,
			NormalParkourModModTabs.TAB_NORMAL_PARKOUR_TAB);
	public static final RegistryObject<Item> EFFECT_BLOCK = block(NormalParkourModModBlocks.EFFECT_BLOCK, null);
	public static final RegistryObject<Item> MOB_REMOVER = REGISTRY.register("mob_remover", () -> new MobRemoverItem());
	public static final RegistryObject<Item> FRICTION_STAIRS = block(NormalParkourModModBlocks.FRICTION_STAIRS,
			NormalParkourModModTabs.TAB_NORMAL_PARKOUR_TAB);
	public static final RegistryObject<Item> ZERO_GRAVITY_BLOCK = block(NormalParkourModModBlocks.ZERO_GRAVITY_BLOCK,
			NormalParkourModModTabs.TAB_NORMAL_PARKOUR_TAB);
	public static final RegistryObject<Item> ANTI_JUMP_BLOCK = block(NormalParkourModModBlocks.ANTI_JUMP_BLOCK,
			NormalParkourModModTabs.TAB_NORMAL_PARKOUR_TAB);
	public static final RegistryObject<Item> CLEAR_BLOCK = block(NormalParkourModModBlocks.CLEAR_BLOCK,
			NormalParkourModModTabs.TAB_NORMAL_PARKOUR_TAB);
	public static final RegistryObject<Item> DEBUG_BLOCK = block(NormalParkourModModBlocks.DEBUG_BLOCK, null);
	public static final RegistryObject<Item> SLOW_BLOCK = block(NormalParkourModModBlocks.SLOW_BLOCK, NormalParkourModModTabs.TAB_NORMAL_PARKOUR_TAB);
	public static final RegistryObject<Item> WIN_BLOCK = block(NormalParkourModModBlocks.WIN_BLOCK, NormalParkourModModTabs.TAB_NORMAL_PARKOUR_TAB);
	public static final RegistryObject<Item> RAMP = block(NormalParkourModModBlocks.RAMP, null);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
