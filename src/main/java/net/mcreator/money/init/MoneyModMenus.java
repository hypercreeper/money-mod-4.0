
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.money.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.money.world.inventory.PaymentmachinepayerguiMenu;
import net.mcreator.money.world.inventory.PaymentmachineownerguiMenu;
import net.mcreator.money.world.inventory.ExchangeguiMenu;
import net.mcreator.money.world.inventory.CardupgraderguiMenu;
import net.mcreator.money.world.inventory.CardmakerguiMenu;
import net.mcreator.money.world.inventory.AtmguiMenu;
import net.mcreator.money.MoneyMod;

public class MoneyModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MoneyMod.MODID);
	public static final RegistryObject<MenuType<CardmakerguiMenu>> CARDMAKERGUI = REGISTRY.register("cardmakergui", () -> IForgeMenuType.create(CardmakerguiMenu::new));
	public static final RegistryObject<MenuType<AtmguiMenu>> ATMGUI = REGISTRY.register("atmgui", () -> IForgeMenuType.create(AtmguiMenu::new));
	public static final RegistryObject<MenuType<ExchangeguiMenu>> EXCHANGEGUI = REGISTRY.register("exchangegui", () -> IForgeMenuType.create(ExchangeguiMenu::new));
	public static final RegistryObject<MenuType<CardupgraderguiMenu>> CARDUPGRADERGUI = REGISTRY.register("cardupgradergui", () -> IForgeMenuType.create(CardupgraderguiMenu::new));
	public static final RegistryObject<MenuType<PaymentmachineownerguiMenu>> PAYMENTMACHINEOWNERGUI = REGISTRY.register("paymentmachineownergui", () -> IForgeMenuType.create(PaymentmachineownerguiMenu::new));
	public static final RegistryObject<MenuType<PaymentmachinepayerguiMenu>> PAYMENTMACHINEPAYERGUI = REGISTRY.register("paymentmachinepayergui", () -> IForgeMenuType.create(PaymentmachinepayerguiMenu::new));
}
