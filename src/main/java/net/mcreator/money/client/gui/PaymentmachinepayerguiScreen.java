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

import net.mcreator.money.world.inventory.PaymentmachinepayerguiMenu;
import net.mcreator.money.network.PaymentmachinepayerguiButtonMessage;
import net.mcreator.money.MoneyMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class PaymentmachinepayerguiScreen extends AbstractContainerScreen<PaymentmachinepayerguiMenu> {
	private final static HashMap<String, Object> guistate = PaymentmachinepayerguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox pin;
	Button button_pay;

	public PaymentmachinepayerguiScreen(PaymentmachinepayerguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 230;
	}

	private static final ResourceLocation texture = new ResourceLocation("money:textures/screens/paymentmachinepayergui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		pin.render(ms, mouseX, mouseY, partialTicks);
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
		if (pin.isFocused())
			return pin.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		pin.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, Component.translatable("gui.money.paymentmachinepayergui.label_payment"), 67, 4, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.money.paymentmachinepayergui.label_insert_card"), 55, 48, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.money.paymentmachinepayergui.label_price_bnbtnumberprice"), 39, 22, -12829636);
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
		pin = new EditBox(this.font, this.leftPos + 27, this.topPos + 84, 120, 20, Component.translatable("gui.money.paymentmachinepayergui.pin")) {
			{
				setSuggestion(Component.translatable("gui.money.paymentmachinepayergui.pin").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.money.paymentmachinepayergui.pin").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.money.paymentmachinepayergui.pin").getString());
				else
					setSuggestion(null);
			}
		};
		pin.setMaxLength(32767);
		guistate.put("text:pin", pin);
		this.addWidget(this.pin);
		button_pay = new Button(this.leftPos + 64, this.topPos + 119, 40, 20, Component.translatable("gui.money.paymentmachinepayergui.button_pay"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new PaymentmachinepayerguiButtonMessage(0, x, y, z));
				PaymentmachinepayerguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_pay", button_pay);
		this.addRenderableWidget(button_pay);
	}
}
