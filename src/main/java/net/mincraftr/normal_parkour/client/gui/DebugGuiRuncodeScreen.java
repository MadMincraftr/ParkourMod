
package net.mincraftr.normal_parkour.client.gui;

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

import net.mincraftr.normal_parkour.world.inventory.DebugGuiRuncodeMenu;
import net.mincraftr.normal_parkour.network.DebugGuiRuncodeButtonMessage;
import net.mincraftr.normal_parkour.NormalParkourModMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class DebugGuiRuncodeScreen extends AbstractContainerScreen<DebugGuiRuncodeMenu> {
	private final static HashMap<String, Object> guistate = DebugGuiRuncodeMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox code;

	public DebugGuiRuncodeScreen(DebugGuiRuncodeMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	private static final ResourceLocation texture = new ResourceLocation("normal_parkour_mod:textures/debug_gui_runcode.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		code.render(ms, mouseX, mouseY, partialTicks);
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
		if (code.isFocused())
			return code.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		code.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Debug Gui (Run Code)", 33, 16, -12829636);
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
		code = new EditBox(this.font, this.leftPos + 24, this.topPos + 43, 120, 20, new TextComponent("Procedure Name")) {
			{
				setSuggestion("Procedure Name");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("Procedure Name");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("Procedure Name");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:code", code);
		code.setMaxLength(32767);
		this.addWidget(this.code);
		this.addRenderableWidget(new Button(this.leftPos + 123, this.topPos + 133, 40, 20, new TextComponent("Run"), e -> {
			if (true) {
				NormalParkourModMod.PACKET_HANDLER.sendToServer(new DebugGuiRuncodeButtonMessage(0, x, y, z));
				DebugGuiRuncodeButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
