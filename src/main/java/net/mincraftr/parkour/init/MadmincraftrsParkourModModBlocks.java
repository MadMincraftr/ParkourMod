
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mincraftr.parkour.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mincraftr.parkour.block.SuperBlockBlock;
import net.mincraftr.parkour.block.SuperBlock2Block;
import net.mincraftr.parkour.block.SpeedBlockBlock;
import net.mincraftr.parkour.block.KillBrickBlock;
import net.mincraftr.parkour.block.JumpBlockBlock;
import net.mincraftr.parkour.block.FrictionBlockBlock;
import net.mincraftr.parkour.block.DamageBrickBlock;
import net.mincraftr.parkour.block.CheckpointBlockBlock;
import net.mincraftr.parkour.MadmincraftrsParkourModMod;

public class MadmincraftrsParkourModModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MadmincraftrsParkourModMod.MODID);
	public static final RegistryObject<Block> KILL_BRICK = REGISTRY.register("kill_brick", () -> new KillBrickBlock());
	public static final RegistryObject<Block> CHECKPOINT_BLOCK = REGISTRY.register("checkpoint_block", () -> new CheckpointBlockBlock());
	public static final RegistryObject<Block> SPEED_BLOCK = REGISTRY.register("speed_block", () -> new SpeedBlockBlock());
	public static final RegistryObject<Block> FRICTION_BLOCK = REGISTRY.register("friction_block", () -> new FrictionBlockBlock());
	public static final RegistryObject<Block> SUPER_BLOCK = REGISTRY.register("super_block", () -> new SuperBlockBlock());
	public static final RegistryObject<Block> JUMP_BLOCK = REGISTRY.register("jump_block", () -> new JumpBlockBlock());
	public static final RegistryObject<Block> DAMAGE_BRICK = REGISTRY.register("damage_brick", () -> new DamageBrickBlock());
	public static final RegistryObject<Block> SUPER_BLOCK_2 = REGISTRY.register("super_block_2", () -> new SuperBlock2Block());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			SpeedBlockBlock.registerRenderLayer();
			SuperBlockBlock.registerRenderLayer();
		}
	}
}
