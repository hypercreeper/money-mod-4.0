
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.money.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.money.block.entity.PaymentMachineBlockEntity;
import net.mcreator.money.MoneyMod;

public class MoneyModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MoneyMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> PAYMENT_MACHINE = register("payment_machine", MoneyModBlocks.PAYMENT_MACHINE, PaymentMachineBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
