package net.mcreator.money.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.gui.components.EditBox;

import net.mcreator.money.init.MoneyModItems;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

public class CardmakerguibuttonProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = new ItemStack(MoneyModItems.CREDIT_CARD.get());
			_setstack.setCount(1);
			((Slot) _slots.get(0)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		entity.getPersistentData().putString("PIN", (guistate.containsKey("text:initiallpin") ? ((EditBox) guistate.get("text:initiallpin")).getValue() : ""));
		entity.getPersistentData().putDouble("credit", 0);
	}
}
