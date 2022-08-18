
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mincraftr.normal_parkour.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mincraftr.normal_parkour.potion.ZeroGravityMobEffect;
import net.mincraftr.normal_parkour.potion.AntiJumpMobEffect;
import net.mincraftr.normal_parkour.NormalParkourModMod;

public class NormalParkourModModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, NormalParkourModMod.MODID);
	public static final RegistryObject<MobEffect> ANTI_JUMP = REGISTRY.register("anti_jump", () -> new AntiJumpMobEffect());
	public static final RegistryObject<MobEffect> ZERO_GRAVITY = REGISTRY.register("zero_gravity", () -> new ZeroGravityMobEffect());
}
