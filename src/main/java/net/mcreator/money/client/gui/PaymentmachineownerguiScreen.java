
package net.mcreator.money.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.money.world.inventory.PaymentmachineownerguiMenu;
import net.mcreator.money.network.PaymentmachineownerguiButtonMessage;
import net.mcreator.money.MoneyMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class PaymentmachineownerguiScreen extends AbstractContainerScreen<PaymentmachineownerguiMenu> {
	private final static HashMap<String, Object> guistate = PaymentmachineownerguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox price;
	EditBox pin;

	public PaymentmachineownerguiScreen(PaymentmachineownerguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 230;
	}

	private static final ResourceLocation texture = new ResourceLocation("money:textures/screens/paymentmachineownergui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		price.render(ms, mouseX, mouseY, partialTicks);
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
		if (price.isFocused())
			return price.keyPressed(key, b, c);
		if (pin.isFocused())
			return pin.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		price.tick();
		pin.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Modify Payment", 46, 5, -12829636);
		this.font.draw(poseStack, "Type Price", 58, 19, -12829636);
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
		price = new EditBox(this.font, this.leftPos + 25, this.topPos + 34, 120, 20, new TextComponent(""));
		guistate.put("text:price", price);
		price.setMaxLength(32767);
		this.addWidget(this.price);
		this.addRenderableWidget(new Button(this.leftPos + 39, this.topPos + 59, 93, 20, new TextComponent("Start Payment"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new PaymentmachineownerguiButtonMessage(0, x, y, z));
				PaymentmachineownerguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 16, this.topPos + 115, 139, 20, new TextComponent("Collect Money (If any)"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new PaymentmachineownerguiButtonMessage(1, x, y, z));
				PaymentmachineownerguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		pin = new EditBox(this.font, this.leftPos + 41, this.topPos + 90, 120, 20, new TextComponent("Enter PIN")) {
			{
				setSuggestion("Enter PIN");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("Enter PIN");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("Enter PIN");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:pin", pin);
		pin.setMaxLength(32767);
		this.addWidget(this.pin);
	}
}
