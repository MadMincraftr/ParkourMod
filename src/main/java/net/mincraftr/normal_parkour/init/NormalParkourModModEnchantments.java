
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mincraftr.normal_parkour.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mincraftr.normal_parkour.enchantment.BrickProtectionEnchantment;
import net.mincraftr.normal_parkour.NormalParkourModMod;

public class NormalParkourModModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, NormalParkourModMod.MODID);
	public static final RegistryObject<Enchantment> BRICK_PROTECTION = REGISTRY.register("brick_protection", () -> new BrickProtectionEnchantment());
}
