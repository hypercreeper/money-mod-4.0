
/*
*    MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.money.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerProfession;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MoneyModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == VillagerProfession.ARMORER) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MoneyModItems.CASH.get(), 10),

					new ItemStack(Items.DIAMOND_HELMET), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MoneyModItems.CASH.get(), 10),

					new ItemStack(Items.DIAMOND_CHESTPLATE), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MoneyModItems.CASH.get(), 10),

					new ItemStack(Items.DIAMOND_LEGGINGS), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MoneyModItems.CASH.get(), 10),

					new ItemStack(Items.DIAMOND_BOOTS), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MoneyModItems.CASH.get(), 20),

					new ItemStack(Items.DIAMOND_SWORD), 10, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.BUTCHER) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MoneyModItems.COIN.get(), 5),

					new ItemStack(Items.BEEF), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MoneyModItems.CASH.get()),

					new ItemStack(Items.COOKED_BEEF), 10, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.CLERIC) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD),

					new ItemStack(MoneyModItems.CASH.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.DIAMOND),

					new ItemStack(MoneyModItems.CASH.get(), 10), 10, 5, 0.05f));
		}
	}
}
