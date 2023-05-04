package net.mcreator.money.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.money.world.inventory.CardupgraderguiMenu;
import net.mcreator.money.network.CardupgraderguiButtonMessage;
import net.mcreator.money.MoneyMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class CardupgraderguiScreen extends AbstractContainerScreen<CardupgraderguiMenu> {
	private final static HashMap<String, Object> guistate = CardupgraderguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_get_gold_card;

	public CardupgraderguiScreen(CardupgraderguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 230;
	}

	private static final ResourceLocation texture = new ResourceLocation("money:textures/screens/cardupgradergui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, Component.translatable("gui.money.cardupgradergui.label_card_upgrader"), 50, 9, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.money.cardupgradergui.label_note_minimum_money_required"), 14, 24, -3407872);
		this.font.draw(poseStack, Component.translatable("gui.money.cardupgradergui.label_is_1000000"), 9, 35, -3407872);
		this.font.draw(poseStack, Component.translatable("gui.money.cardupgradergui.label_insert_credit_card"), 36, 58, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		button_get_gold_card = new Button(this.leftPos + 40, this.topPos + 122, 92, 20, Component.translatable("gui.money.cardupgradergui.button_get_gold_card"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new CardupgraderguiButtonMessage(0, x, y, z));
				CardupgraderguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_get_gold_card", button_get_gold_card);
		this.addRenderableWidget(button_get_gold_card);
	}
}
