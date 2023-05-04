
/*
 *	MCreator note: This file will be REGENERATED on each build.
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
			MenuScreens.register(MoneyModMenus.CARDMAKERGUI.get(), CardmakerguiScreen::new);
			MenuScreens.register(MoneyModMenus.ATMGUI.get(), AtmguiScreen::new);
			MenuScreens.register(MoneyModMenus.EXCHANGEGUI.get(), ExchangeguiScreen::new);
			MenuScreens.register(MoneyModMenus.CARDUPGRADERGUI.get(), CardupgraderguiScreen::new);
			MenuScreens.register(MoneyModMenus.PAYMENTMACHINEOWNERGUI.get(), PaymentmachineownerguiScreen::new);
			MenuScreens.register(MoneyModMenus.PAYMENTMACHINEPAYERGUI.get(), PaymentmachinepayerguiScreen::new);
		});
	}
}
