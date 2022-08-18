
package net.mincraftr.normal_parkour.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.Minecraft;

import net.mincraftr.normal_parkour.world.inventory.EffectBlockGuiMenu;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class EffectBlockGuiScreen extends AbstractContainerScreen<EffectBlockGuiMenu> {
	private final static HashMap<String, Object> guistate = EffectBlockGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox effect;
	EditBox amount;
	EditBox ticks;

	public EffectBlockGuiScreen(EffectBlockGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 150;
		this.imageHeight = 130;
	}

	private static final ResourceLocation texture = new ResourceLocation("normal_parkour_mod:textures/effect_block_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		effect.render(ms, mouseX, mouseY, partialTicks);
		amount.render(ms, mouseX, mouseY, partialTicks);
		ticks.render(ms, mouseX, mouseY, partialTicks);
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
		if (effect.isFocused())
			return effect.keyPressed(key, b, c);
		if (amount.isFocused())
			return amount.keyPressed(key, b, c);
		if (ticks.isFocused())
			return ticks.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		effect.tick();
		amount.tick();
		ticks.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Effect Block", 43, 6, -12829636);
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
		effect = new EditBox(this.font, this.leftPos + 16, this.topPos + 23, 120, 20, new TextComponent("Effect ID")) {
			{
				setSuggestion("Effect ID");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("Effect ID");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("Effect ID");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:effect", effect);
		effect.setMaxLength(32767);
		this.addWidget(this.effect);
		amount = new EditBox(this.font, this.leftPos + 16, this.topPos + 62, 120, 20, new TextComponent("Effect level")) {
			{
				setSuggestion("Effect level");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("Effect level");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("Effect level");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:amount", amount);
		amount.setMaxLength(32767);
		this.addWidget(this.amount);
		ticks = new EditBox(this.font, this.leftPos + 16, this.topPos + 100, 120, 20, new TextComponent("Effect duration (Seconds)")) {
			{
				setSuggestion("Effect duration (Seconds)");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("Effect duration (Seconds)");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("Effect duration (Seconds)");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:ticks", ticks);
		ticks.setMaxLength(32767);
		this.addWidget(this.ticks);
	}
}
