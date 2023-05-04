package net.mcreator.money.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.money.world.inventory.CardmakerguiMenu;
import net.mcreator.money.network.CardmakerguiButtonMessage;
import net.mcreator.money.MoneyMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class CardmakerguiScreen extends AbstractContainerScreen<CardmakerguiMenu> {
	private final static HashMap<String, Object> guistate = CardmakerguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox initiallpin;
	Button button_create;

	public CardmakerguiScreen(CardmakerguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 181;
		this.imageHeight = 230;
	}

	private static final ResourceLocation texture = new ResourceLocation("money:textures/screens/cardmakergui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		initiallpin.render(ms, mouseX, mouseY, partialTicks);
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
		if (initiallpin.isFocused())
			return initiallpin.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		initiallpin.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, Component.translatable("gui.money.cardmakergui.label_card_maker"), 64, 14, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.money.cardmakergui.label_enter_a_pin"), 60, 45, -12829636);
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
		initiallpin = new EditBox(this.font, this.leftPos + 30, this.topPos + 61, 120, 20, Component.translatable("gui.money.cardmakergui.initiallpin"));
		initiallpin.setMaxLength(32767);
		guistate.put("text:initiallpin", initiallpin);
		this.addWidget(this.initiallpin);
		button_create = new Button(this.leftPos + 62, this.topPos + 119, 56, 20, Component.translatable("gui.money.cardmakergui.button_create"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new CardmakerguiButtonMessage(0, x, y, z));
				CardmakerguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_create", button_create);
		this.addRenderableWidget(button_create);
	}
}
