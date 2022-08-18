
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mincraftr.normal_parkour.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mincraftr.normal_parkour.block.entity.SuperBlockBlockEntity;
import net.mincraftr.normal_parkour.block.entity.EffectBlockBlockEntity;
import net.mincraftr.normal_parkour.NormalParkourModMod;

public class NormalParkourModModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES,
			NormalParkourModMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> SUPER_BLOCK = register("super_block", NormalParkourModModBlocks.SUPER_BLOCK,
			SuperBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> EFFECT_BLOCK = register("effect_block", NormalParkourModModBlocks.EFFECT_BLOCK,
			EffectBlockBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
