
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

import net.mincraftr.parkour.block.SpeedBlockBlock;
import net.mincraftr.parkour.block.KillBrickBlock;
import net.mincraftr.parkour.block.CheckpointBlockBlock;
import net.mincraftr.parkour.MadmincraftrsParkourModMod;

public class MadmincraftrsParkourModModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MadmincraftrsParkourModMod.MODID);
	public static final RegistryObject<Block> KILL_BRICK = REGISTRY.register("kill_brick", () -> new KillBrickBlock());
	public static final RegistryObject<Block> CHECKPOINT_BLOCK = REGISTRY.register("checkpoint_block", () -> new CheckpointBlockBlock());
	public static final RegistryObject<Block> SPEED_BLOCK = REGISTRY.register("speed_block", () -> new SpeedBlockBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			SpeedBlockBlock.registerRenderLayer();
		}
	}
}
