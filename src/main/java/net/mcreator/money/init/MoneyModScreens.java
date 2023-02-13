
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.money.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.money.client.gui.PaymentmachinepayerguiScreen;
import net.mcreator.money.client.gui.PaymentmachineownerguiScreen;
import net.mcreator.money.client.gui.ExchangeguiScreen;
import net.mcreator.money.client.gui.CardupgraderguiScreen;
import net.mcreator.money.client.gui.CardmakerguiScreen;
import net.mcreator.money.client.gui.AtmguiScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MoneyModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(MoneyModMenus.CARDMAKERGUI, CardmakerguiScreen::new);
			MenuScreens.register(MoneyModMenus.ATMGUI, AtmguiScreen::new);
			MenuScreens.register(MoneyModMenus.EXCHANGEGUI, ExchangeguiScreen::new);
			MenuScreens.register(MoneyModMenus.CARDUPGRADERGUI, CardupgraderguiScreen::new);
			MenuScreens.register(MoneyModMenus.PAYMENTMACHINEOWNERGUI, PaymentmachineownerguiScreen::new);
			MenuScreens.register(MoneyModMenus.PAYMENTMACHINEPAYERGUI, PaymentmachinepayerguiScreen::new);
		});
	}
}
