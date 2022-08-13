
package net.mincraftr.parkour.world.inventory;

import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mincraftr.parkour.procedures.SuperBlockConfigOpenTickProcedure;
import net.mincraftr.parkour.init.MadmincraftrsParkourModModMenus;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber
public class SuperBlockConfigMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
	public final static HashMap<String, Object> guistate = new HashMap<>();
	public final Level world;
	public final Player entity;
	public int x, y, z;
	private IItemHandler internal;
	private final Map<Integer, Slot> customSlots = new HashMap<>();
	private boolean bound = false;

	public SuperBlockConfigMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(MadmincraftrsParkourModModMenus.SUPER_BLOCK_CONFIG, id);
		this.entity = inv.player;
		this.world = inv.player.level;
		this.internal = new ItemStackHandler(0);
		BlockPos pos = null;
		if (extraData != null) {
			pos = extraData.readBlockPos();
			this.x = pos.getX();
			this.y = pos.getY();
			this.z = pos.getZ();
		}
	}

	@Override
	public boolean stillValid(Player player) {
		return true;
	}

	public Map<Integer, Slot> get() {
		return customSlots;
	}

	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		Player entity = event.player;
		if (event.phase == TickEvent.Phase.END && entity.containerMenu instanceof SuperBlockConfigMenu) {
			Level world = entity.level;
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();

			SuperBlockConfigOpenTickProcedure.execute(world, x, y, z, guistate);
		}
	}
}
