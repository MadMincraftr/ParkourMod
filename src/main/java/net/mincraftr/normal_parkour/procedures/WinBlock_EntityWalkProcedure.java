package net.mincraftr.normal_parkour.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mincraftr.normal_parkour.world.inventory.WinScreenMenu;
import net.mincraftr.normal_parkour.network.NormalParkourModModVariables;

import io.netty.buffer.Unpooled;

public class WinBlock_EntityWalkProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NormalParkourModModVariables.PlayerVariables())).DidStepOnWinBlock == false
				&& (entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NormalParkourModModVariables.PlayerVariables())).DidWin == false) {
			{
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openGui((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return new TextComponent("WinScreen");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new WinScreenMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.toast.challenge_complete")), SoundSource.BLOCKS, 1, 2);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.toast.challenge_complete")),
							SoundSource.BLOCKS, 1, 2, false);
				}
			}
			{
				boolean _setval = true;
				entity.getCapability(NormalParkourModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DidStepOnWinBlock = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
