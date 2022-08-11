
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mincraftr.parkour.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mincraftr.parkour.block.KillBrickBlock;
import net.mincraftr.parkour.block.CheckpointBlockBlock;
import net.mincraftr.parkour.MadmincraftrsParkourModMod;

public class MadmincraftrsParkourModModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MadmincraftrsParkourModMod.MODID);
	public static final RegistryObject<Block> KILL_BRICK = REGISTRY.register("kill_brick", () -> new KillBrickBlock());
	public static final RegistryObject<Block> CHECKPOINT_BLOCK = REGISTRY.register("checkpoint_block", () -> new CheckpointBlockBlock());
}
