package net.mcreator.money.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;

import net.mcreator.money.init.MoneyModItems;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

public class AtmguibuttonProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		double processReturn = 0;
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem() == MoneyModItems.CREDIT_CARD.get()
				|| (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem() == MoneyModItems.GOLD_CREDIT_CARD
						.get()) {
			if (guistate.containsKey("checkbox:withdraw") ? ((Checkbox) guistate.get("checkbox:withdraw")).selected() : false) {
				if ((guistate.containsKey("text:cardpin") ? ((EditBox) guistate.get("text:cardpin")).getValue() : "").equals(entity.getPersistentData().getString("PIN"))) {
					if (new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(guistate.containsKey("text:amount") ? ((EditBox) guistate.get("text:amount")).getValue() : "") <= entity.getPersistentData().getDouble("credit")) {
						if (new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(guistate.containsKey("text:amount") ? ((EditBox) guistate.get("text:amount")).getValue() : "") < 10) {
							if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(MoneyModItems.COIN.get());
								_setstack.setCount((int) new Object() {
									double convert(String s) {
										try {
											return Double.parseDouble(s.trim());
										} catch (Exception e) {
										}
										return 0;
									}
								}.convert(guistate.containsKey("text:amount") ? ((EditBox) guistate.get("text:amount")).getValue() : ""));
								((Slot) _slots.get(2)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else {
							if ((guistate.containsKey("text:amount") ? ((EditBox) guistate.get("text:amount")).getValue() : "").endsWith("0")) {
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									ItemStack _setstack = new ItemStack(MoneyModItems.CASH.get());
									_setstack.setCount((int) (new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(guistate.containsKey("text:amount") ? ((EditBox) guistate.get("text:amount")).getValue() : "") / 10));
									((Slot) _slots.get(2)).set(_setstack);
									_player.containerMenu.broadcastChanges();
								}
							} else {
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									ItemStack _setstack = new ItemStack(MoneyModItems.CASH.get());
									_setstack.setCount((int) Math.floor(new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(guistate.containsKey("text:amount") ? ((EditBox) guistate.get("text:amount")).getValue() : "") / 10));
									((Slot) _slots.get(2)).set(_setstack);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof Player _player) {
									ItemStack _setstack = new ItemStack(MoneyModItems.COIN.get());
									_setstack.setCount((int) new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert((guistate.containsKey("text:amount") ? ((EditBox) guistate.get("text:amount")).getValue() : "").substring(
											(int) ((guistate.containsKey("text:amount") ? ((EditBox) guistate.get("text:amount")).getValue() : "").length() - 1),
											(int) (guistate.containsKey("text:amount") ? ((EditBox) guistate.get("text:amount")).getValue() : "").length())));
									ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
								}
							}
						}
						entity.getPersistentData().putDouble("credit", (entity.getPersistentData().getDouble("credit") - new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(guistate.containsKey("text:amount") ? ((EditBox) guistate.get("text:amount")).getValue() : "")));
					}
				}
			} else {
				if (MoneyModItems.COIN.get() == (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem()
						|| MoneyModItems.CASH.get() == (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
								.getItem()) {
					if ((guistate.containsKey("text:cardpin") ? ((EditBox) guistate.get("text:cardpin")).getValue() : "").equals(entity.getPersistentData().getString("PIN"))) {
						if (MoneyModItems.CASH.get() == (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
								.getItem()) {
							entity.getPersistentData().putDouble("credit",
									((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag()
											.getDouble("credit")
											+ ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)).getCount()
													* 10));
							if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								((Slot) _slots.get(0))
										.remove(((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)).getCount());
								_player.containerMenu.broadcastChanges();
							}
						} else if (MoneyModItems.COIN.get() == (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
								.getItem()) {
							entity.getPersistentData().putDouble("credit",
									((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag()
											.getDouble("credit")
											+ ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)).getCount()));
							if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								((Slot) _slots.get(0))
										.remove(((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)).getCount());
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				}
			}
		}
	}
}
