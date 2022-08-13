
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mincraftr.parkour.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;

import net.mincraftr.parkour.MadmincraftrsParkourModMod;

public class MadmincraftrsParkourModModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, MadmincraftrsParkourModMod.MODID);
	public static final RegistryObject<Potion> POTION_ANTI_JUMP = REGISTRY.register("potion_anti_jump",
			() -> new Potion(new MobEffectInstance(MadmincraftrsParkourModModMobEffects.ANTI_JUMP.get(), 3600, 0, false, true)));
	public static final RegistryObject<Potion> ZERO_GRAVITY_POTION = REGISTRY.register("zero_gravity_potion",
			() -> new Potion(new MobEffectInstance(MadmincraftrsParkourModModMobEffects.ZERO_GRAVITY.get(), 3600, 0, false, true)));
}