
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mincraftr.parkour.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mincraftr.parkour.block.entity.SuperBlockBlockEntity;
import net.mincraftr.parkour.MadmincraftrsParkourModMod;

public class MadmincraftrsParkourModModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES,
			MadmincraftrsParkourModMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> SUPER_BLOCK = register("super_block", MadmincraftrsParkourModModBlocks.SUPER_BLOCK,
			SuperBlockBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
