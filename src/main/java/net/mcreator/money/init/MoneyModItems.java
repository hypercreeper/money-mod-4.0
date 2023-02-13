
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.money.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.money.item.GoldCreditCardItem;
import net.mcreator.money.item.CreditCardItem;
import net.mcreator.money.item.CoinItem;
import net.mcreator.money.item.CashItem;
import net.mcreator.money.MoneyMod;

public class MoneyModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MoneyMod.MODID);
	public static final RegistryObject<Item> CREDIT_CARD = REGISTRY.register("credit_card", () -> new CreditCardItem());
	public static final RegistryObject<Item> CARD_MAKER = block(MoneyModBlocks.CARD_MAKER, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> ATM = block(MoneyModBlocks.ATM, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> COIN = REGISTRY.register("coin", () -> new CoinItem());
	public static final RegistryObject<Item> CASH = REGISTRY.register("cash", () -> new CashItem());
	public static final RegistryObject<Item> EXCHANGE_BLOCK = block(MoneyModBlocks.EXCHANGE_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> GOLD_CREDIT_CARD = REGISTRY.register("gold_credit_card", () -> new GoldCreditCardItem());
	public static final RegistryObject<Item> CARDUPGRADER = block(MoneyModBlocks.CARDUPGRADER, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> PAYMENT_MACHINE = block(MoneyModBlocks.PAYMENT_MACHINE, CreativeModeTab.TAB_BUILDING_BLOCKS);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
