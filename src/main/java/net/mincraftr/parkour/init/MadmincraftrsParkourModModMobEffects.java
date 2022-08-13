
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mincraftr.parkour.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mincraftr.parkour.potion.ZeroGravityMobEffect;
import net.mincraftr.parkour.potion.AntiJumpMobEffect;
import net.mincraftr.parkour.MadmincraftrsParkourModMod;

public class MadmincraftrsParkourModModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MadmincraftrsParkourModMod.MODID);
	public static final RegistryObject<MobEffect> ANTI_JUMP = REGISTRY.register("anti_jump", () -> new AntiJumpMobEffect());
	public static final RegistryObject<MobEffect> ZERO_GRAVITY = REGISTRY.register("zero_gravity", () -> new ZeroGravityMobEffect());
}
