
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.money.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.money.block.PaymentMachineBlock;
import net.mcreator.money.block.ExchangeBlockBlock;
import net.mcreator.money.block.CardupgraderBlock;
import net.mcreator.money.block.CardMakerBlock;
import net.mcreator.money.block.ATMBlock;
import net.mcreator.money.MoneyMod;

public class MoneyModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MoneyMod.MODID);
	public static final RegistryObject<Block> CARD_MAKER = REGISTRY.register("card_maker", () -> new CardMakerBlock());
	public static final RegistryObject<Block> ATM = REGISTRY.register("atm", () -> new ATMBlock());
	public static final RegistryObject<Block> EXCHANGE_BLOCK = REGISTRY.register("exchange_block", () -> new ExchangeBlockBlock());
	public static final RegistryObject<Block> CARDUPGRADER = REGISTRY.register("cardupgrader", () -> new CardupgraderBlock());
	public static final RegistryObject<Block> PAYMENT_MACHINE = REGISTRY.register("payment_machine", () -> new PaymentMachineBlock());
}
