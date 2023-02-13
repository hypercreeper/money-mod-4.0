
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.money.init;

import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import net.mcreator.money.world.inventory.PaymentmachinepayerguiMenu;
import net.mcreator.money.world.inventory.PaymentmachineownerguiMenu;
import net.mcreator.money.world.inventory.ExchangeguiMenu;
import net.mcreator.money.world.inventory.CardupgraderguiMenu;
import net.mcreator.money.world.inventory.CardmakerguiMenu;
import net.mcreator.money.world.inventory.AtmguiMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MoneyModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<CardmakerguiMenu> CARDMAKERGUI = register("cardmakergui",
			(id, inv, extraData) -> new CardmakerguiMenu(id, inv, extraData));
	public static final MenuType<AtmguiMenu> ATMGUI = register("atmgui", (id, inv, extraData) -> new AtmguiMenu(id, inv, extraData));
	public static final MenuType<ExchangeguiMenu> EXCHANGEGUI = register("exchangegui",
			(id, inv, extraData) -> new ExchangeguiMenu(id, inv, extraData));
	public static final MenuType<CardupgraderguiMenu> CARDUPGRADERGUI = register("cardupgradergui",
			(id, inv, extraData) -> new CardupgraderguiMenu(id, inv, extraData));
	public static final MenuType<PaymentmachineownerguiMenu> PAYMENTMACHINEOWNERGUI = register("paymentmachineownergui",
			(id, inv, extraData) -> new PaymentmachineownerguiMenu(id, inv, extraData));
	public static final MenuType<PaymentmachinepayerguiMenu> PAYMENTMACHINEPAYERGUI = register("paymentmachinepayergui",
			(id, inv, extraData) -> new PaymentmachinepayerguiMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
