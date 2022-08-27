
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mincraftr.normal_parkour.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mincraftr.normal_parkour.block.ZeroGravityBlockBlock;
import net.mincraftr.normal_parkour.block.WinBlockBlock;
import net.mincraftr.normal_parkour.block.SuperBlockBlock;
import net.mincraftr.normal_parkour.block.SuperBlock2Block;
import net.mincraftr.normal_parkour.block.SpeedBlockBlock;
import net.mincraftr.normal_parkour.block.SlowBlockBlock;
import net.mincraftr.normal_parkour.block.RampBlock;
import net.mincraftr.normal_parkour.block.KillBrickBlock;
import net.mincraftr.normal_parkour.block.JumpBlockBlock;
import net.mincraftr.normal_parkour.block.FrictionStairsBlock;
import net.mincraftr.normal_parkour.block.FrictionBlockBlock;
import net.mincraftr.normal_parkour.block.EffectBlockBlock;
import net.mincraftr.normal_parkour.block.DebugBlockBlock;
import net.mincraftr.normal_parkour.block.DamageBrickBlock;
import net.mincraftr.normal_parkour.block.ClearBlockBlock;
import net.mincraftr.normal_parkour.block.CheckpointBlockBlock;
import net.mincraftr.normal_parkour.block.AntiJumpBlockBlock;
import net.mincraftr.normal_parkour.NormalParkourModMod;

public class NormalParkourModModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, NormalParkourModMod.MODID);
	public static final RegistryObject<Block> KILL_BRICK = REGISTRY.register("kill_brick", () -> new KillBrickBlock());
	public static final RegistryObject<Block> DAMAGE_BRICK = REGISTRY.register("damage_brick", () -> new DamageBrickBlock());
	public static final RegistryObject<Block> SPEED_BLOCK = REGISTRY.register("speed_block", () -> new SpeedBlockBlock());
	public static final RegistryObject<Block> JUMP_BLOCK = REGISTRY.register("jump_block", () -> new JumpBlockBlock());
	public static final RegistryObject<Block> ZERO_GRAVITY_BLOCK = REGISTRY.register("zero_gravity_block", () -> new ZeroGravityBlockBlock());
	public static final RegistryObject<Block> ANTI_JUMP_BLOCK = REGISTRY.register("anti_jump_block", () -> new AntiJumpBlockBlock());
	public static final RegistryObject<Block> SLOW_BLOCK = REGISTRY.register("slow_block", () -> new SlowBlockBlock());
	public static final RegistryObject<Block> CLEAR_BLOCK = REGISTRY.register("clear_block", () -> new ClearBlockBlock());
	public static final RegistryObject<Block> FRICTION_BLOCK = REGISTRY.register("friction_block", () -> new FrictionBlockBlock());
	public static final RegistryObject<Block> FRICTION_STAIRS = REGISTRY.register("friction_stairs", () -> new FrictionStairsBlock());
	public static final RegistryObject<Block> SUPER_BLOCK = REGISTRY.register("super_block", () -> new SuperBlockBlock());
	public static final RegistryObject<Block> SUPER_BLOCK_2 = REGISTRY.register("super_block_2", () -> new SuperBlock2Block());
	public static final RegistryObject<Block> WIN_BLOCK = REGISTRY.register("win_block", () -> new WinBlockBlock());
	public static final RegistryObject<Block> CHECKPOINT_BLOCK = REGISTRY.register("checkpoint_block", () -> new CheckpointBlockBlock());
	public static final RegistryObject<Block> EFFECT_BLOCK = REGISTRY.register("effect_block", () -> new EffectBlockBlock());
	public static final RegistryObject<Block> DEBUG_BLOCK = REGISTRY.register("debug_block", () -> new DebugBlockBlock());
	public static final RegistryObject<Block> RAMP = REGISTRY.register("ramp", () -> new RampBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			SpeedBlockBlock.registerRenderLayer();
			SuperBlockBlock.registerRenderLayer();
			RampBlock.registerRenderLayer();
		}
	}
}
