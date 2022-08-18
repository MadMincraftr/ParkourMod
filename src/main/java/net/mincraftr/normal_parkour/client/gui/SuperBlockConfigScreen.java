
package net.mincraftr.normal_parkour.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.Minecraft;

import net.mincraftr.normal_parkour.world.inventory.SuperBlockConfigMenu;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class SuperBlockConfigScreen extends AbstractContainerScreen<SuperBlockConfigMenu> {
	private final static HashMap<String, Object> guistate = SuperBlockConfigMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Checkbox SpeedToggle;
	EditBox SpeedAmount;
	Checkbox JumpToggle;
	EditBox JumpAmount;
	EditBox SpeedTime;
	EditBox JumpTime;

	public SuperBlockConfigScreen(SuperBlockConfigMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 100;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	private static final ResourceLocation texture = new ResourceLocation("normal_parkour_mod:textures/super_block_config.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		SpeedAmount.render(ms, mouseX, mouseY, partialTicks);
		JumpAmount.render(ms, mouseX, mouseY, partialTicks);
		SpeedTime.render(ms, mouseX, mouseY, partialTicks);
		JumpTime.render(ms, mouseX, mouseY, partialTicks);
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
		if (SpeedAmount.isFocused())
			return SpeedAmount.keyPressed(key, b, c);
		if (JumpAmount.isFocused())
			return JumpAmount.keyPressed(key, b, c);
		if (SpeedTime.isFocused())
			return SpeedTime.keyPressed(key, b, c);
		if (JumpTime.isFocused())
			return JumpTime.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		SpeedAmount.tick();
		JumpAmount.tick();
		SpeedTime.tick();
		JumpTime.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "[ THIS GUI IS BROKEN ); ]", 77, 106, -1163714);
		this.font.draw(poseStack, "Custom Block", 117, 11, -12829636);
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
		SpeedToggle = new Checkbox(this.leftPos + 14, this.topPos + 10, 150, 20, new TextComponent("Speed Boost"), false);
		guistate.put("checkbox:SpeedToggle", SpeedToggle);
		this.addRenderableWidget(SpeedToggle);
		SpeedAmount = new EditBox(this.font, this.leftPos + 14, this.topPos + 37, 120, 20, new TextComponent("Speed Boost Level")) {
			{
				setSuggestion("Speed Boost Level");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("Speed Boost Level");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("Speed Boost Level");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:SpeedAmount", SpeedAmount);
		SpeedAmount.setMaxLength(32767);
		this.addWidget(this.SpeedAmount);
		JumpToggle = new Checkbox(this.leftPos + 203, this.topPos + 10, 150, 20, new TextComponent("Jump Boost"), false);
		guistate.put("checkbox:JumpToggle", JumpToggle);
		this.addRenderableWidget(JumpToggle);
		JumpAmount = new EditBox(this.font, this.leftPos + 167, this.topPos + 37, 120, 20, new TextComponent("Jump Boost Amount")) {
			{
				setSuggestion("Jump Boost Amount");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("Jump Boost Amount");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("Jump Boost Amount");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:JumpAmount", JumpAmount);
		JumpAmount.setMaxLength(32767);
		this.addWidget(this.JumpAmount);
		SpeedTime = new EditBox(this.font, this.leftPos + 14, this.topPos + 64, 120, 20, new TextComponent("Speed Ticks")) {
			{
				setSuggestion("Speed Ticks");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("Speed Ticks");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("Speed Ticks");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:SpeedTime", SpeedTime);
		SpeedTime.setMaxLength(32767);
		this.addWidget(this.SpeedTime);
		JumpTime = new EditBox(this.font, this.leftPos + 167, this.topPos + 64, 120, 20, new TextComponent("Jump Ticks")) {
			{
				setSuggestion("Jump Ticks");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("Jump Ticks");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("Jump Ticks");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:JumpTime", JumpTime);
		JumpTime.setMaxLength(32767);
		this.addWidget(this.JumpTime);
	}
}
