package net.mcreator.money.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.money.world.inventory.AtmguiMenu;
import net.mcreator.money.procedures.BalanceViewerDisplayOverlayIngameProcedure;
import net.mcreator.money.network.AtmguiButtonMessage;
import net.mcreator.money.MoneyMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class AtmguiScreen extends AbstractContainerScreen<AtmguiMenu> {
	private final static HashMap<String, Object> guistate = AtmguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox cardpin;
	EditBox amount;
	Checkbox withdraw;
	Button button_enter;
	Button button_check_credit;

	public AtmguiScreen(AtmguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 250;
		this.imageHeight = 230;
	}

	private static final ResourceLocation texture = new ResourceLocation("money:textures/screens/atmgui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		cardpin.render(ms, mouseX, mouseY, partialTicks);
		amount.render(ms, mouseX, mouseY, partialTicks);
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
		if (cardpin.isFocused())
			return cardpin.keyPressed(key, b, c);
		if (amount.isFocused())
			return amount.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		cardpin.tick();
		amount.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, Component.translatable("gui.money.atmgui.label_atm"), 113, 11, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.money.atmgui.label_insert_cashcoins"), 13, 39, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.money.atmgui.label_insert_credit_card"), 133, 38, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.money.atmgui.label_enter_pin"), 101, 103, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.money.atmgui.label_withdraw"), 6, 85, -12829636);
		this.font.draw(poseStack,

				BalanceViewerDisplayOverlayIngameProcedure.execute(entity), 11, 14, -12829636);
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
		cardpin = new EditBox(this.font, this.leftPos + 37, this.topPos + 117, 120, 20, Component.translatable("gui.money.atmgui.cardpin"));
		cardpin.setMaxLength(32767);
		guistate.put("text:cardpin", cardpin);
		this.addWidget(this.cardpin);
		amount = new EditBox(this.font, this.leftPos + 82, this.topPos + 80, 120, 20, Component.translatable("gui.money.atmgui.amount")) {
			{
				setSuggestion(Component.translatable("gui.money.atmgui.amount").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.money.atmgui.amount").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.money.atmgui.amount").getString());
				else
					setSuggestion(null);
			}
		};
		amount.setMaxLength(32767);
		guistate.put("text:amount", amount);
		this.addWidget(this.amount);
		button_enter = new Button(this.leftPos + 160, this.topPos + 116, 51, 20, Component.translatable("gui.money.atmgui.button_enter"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new AtmguiButtonMessage(0, x, y, z));
				AtmguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_enter", button_enter);
		this.addRenderableWidget(button_enter);
		button_check_credit = new Button(this.leftPos + 148, this.topPos + 8, 87, 20, Component.translatable("gui.money.atmgui.button_check_credit"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new AtmguiButtonMessage(1, x, y, z));
				AtmguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_check_credit", button_check_credit);
		this.addRenderableWidget(button_check_credit);
		withdraw = new Checkbox(this.leftPos + 59, this.topPos + 80, 20, 20, Component.translatable("gui.money.atmgui.withdraw"), false);
		guistate.put("checkbox:withdraw", withdraw);
		this.addRenderableWidget(withdraw);
	}
}
