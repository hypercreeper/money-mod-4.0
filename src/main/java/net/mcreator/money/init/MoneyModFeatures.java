
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.money.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import net.mcreator.money.world.features.SimpleBankFeature;
import net.mcreator.money.MoneyMod;

@Mod.EventBusSubscriber
public class MoneyModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, MoneyMod.MODID);
	public static final RegistryObject<Feature<?>> SIMPLE_BANK = REGISTRY.register("simple_bank", SimpleBankFeature::feature);
}
