
package net.mincraftr.normal_parkour.block;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mincraftr.normal_parkour.init.NormalParkourModModBlocks;

import java.util.List;
import java.util.Collections;

public class RampBlock extends Block implements SimpleWaterloggedBlock

{
	public static final DirectionProperty FACING = DirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public RampBlock() {
		super(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(1f, 10f).noOcclusion().hasPostProcess((bs, br, bp) -> true)
				.emissiveRendering((bs, br, bp) -> true).isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return state.getFluidState().isEmpty();
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		Vec3 offset = state.getOffset(world, pos);
		switch ((Direction) state.getValue(FACING)) {
			case SOUTH :
			default :
				return Shapes.or(box(0, 0, 0, 16, 15, 16), box(0, 1, 0, 15, 14, 16), box(0, 2, 0, 14, 13, 16), box(0, 3, 0, 13, 12, 16),
						box(0, 4, 0, 12, 11, 16), box(0, 5, 0, 11, 10, 16), box(0, 6, 0, 10, 9, 16), box(0, 7, 0, 9, 8, 16), box(0, 7, 0, 8, 8, 16),
						box(0, 6, 0, 7, 9, 16), box(0, 5, 0, 6, 10, 16), box(0, 4, 0, 5, 11, 16), box(0, 3, 0, 4, 12, 16), box(0, 2, 0, 3, 13, 16),
						box(0, 1, 0, 2, 14, 16)).move(offset.x, offset.y, offset.z);
			case NORTH :
				return Shapes.or(box(0, 0, 0, 16, 15, 16), box(1, 1, 0, 16, 14, 16), box(2, 2, 0, 16, 13, 16), box(3, 3, 0, 16, 12, 16),
						box(4, 4, 0, 16, 11, 16), box(5, 5, 0, 16, 10, 16), box(6, 6, 0, 16, 9, 16), box(7, 7, 0, 16, 8, 16), box(8, 7, 0, 16, 8, 16),
						box(9, 6, 0, 16, 9, 16), box(10, 5, 0, 16, 10, 16), box(11, 4, 0, 16, 11, 16), box(12, 3, 0, 16, 12, 16),
						box(13, 2, 0, 16, 13, 16), box(14, 1, 0, 16, 14, 16)).move(offset.x, offset.y, offset.z);
			case EAST :
				return Shapes.or(box(0, 0, 0, 16, 15, 16), box(0, 1, 1, 16, 14, 16), box(0, 2, 2, 16, 13, 16), box(0, 3, 3, 16, 12, 16),
						box(0, 4, 4, 16, 11, 16), box(0, 5, 5, 16, 10, 16), box(0, 6, 6, 16, 9, 16), box(0, 7, 7, 16, 8, 16), box(0, 7, 8, 16, 8, 16),
						box(0, 6, 9, 16, 9, 16), box(0, 5, 10, 16, 10, 16), box(0, 4, 11, 16, 11, 16), box(0, 3, 12, 16, 12, 16),
						box(0, 2, 13, 16, 13, 16), box(0, 1, 14, 16, 14, 16)).move(offset.x, offset.y, offset.z);
			case WEST :
				return Shapes.or(box(0, 0, 0, 16, 15, 16), box(0, 1, 0, 16, 14, 15), box(0, 2, 0, 16, 13, 14), box(0, 3, 0, 16, 12, 13),
						box(0, 4, 0, 16, 11, 12), box(0, 5, 0, 16, 10, 11), box(0, 6, 0, 16, 9, 10), box(0, 7, 0, 16, 8, 9), box(0, 7, 0, 16, 8, 8),
						box(0, 6, 0, 16, 9, 7), box(0, 5, 0, 16, 10, 6), box(0, 4, 0, 16, 11, 5), box(0, 3, 0, 16, 12, 4), box(0, 2, 0, 16, 13, 3),
						box(0, 1, 0, 16, 14, 2)).move(offset.x, offset.y, offset.z);
			case UP :
				return Shapes.or(box(0, 0, 0, 16, 16, 15), box(1, 0, 1, 16, 16, 14), box(2, 0, 2, 16, 16, 13), box(3, 0, 3, 16, 16, 12),
						box(4, 0, 4, 16, 16, 11), box(5, 0, 5, 16, 16, 10), box(6, 0, 6, 16, 16, 9), box(7, 0, 7, 16, 16, 8), box(8, 0, 7, 16, 16, 8),
						box(9, 0, 6, 16, 16, 9), box(10, 0, 5, 16, 16, 10), box(11, 0, 4, 16, 16, 11), box(12, 0, 3, 16, 16, 12),
						box(13, 0, 2, 16, 16, 13), box(14, 0, 1, 16, 16, 14)).move(offset.x, offset.y, offset.z);
			case DOWN :
				return Shapes.or(box(0, 0, 1, 16, 16, 16), box(1, 0, 2, 16, 16, 15), box(2, 0, 3, 16, 16, 14), box(3, 0, 4, 16, 16, 13),
						box(4, 0, 5, 16, 16, 12), box(5, 0, 6, 16, 16, 11), box(6, 0, 7, 16, 16, 10), box(7, 0, 8, 16, 16, 9),
						box(8, 0, 8, 16, 16, 9), box(9, 0, 7, 16, 16, 10), box(10, 0, 6, 16, 16, 11), box(11, 0, 5, 16, 16, 12),
						box(12, 0, 4, 16, 16, 13), box(13, 0, 3, 16, 16, 14), box(14, 0, 2, 16, 16, 15)).move(offset.x, offset.y, offset.z);
		}
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;;
		return this.defaultBlockState().setValue(FACING, context.getNearestLookingDirection().getOpposite()).setValue(WATERLOGGED, flag);
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos,
			BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerRenderLayer() {
		ItemBlockRenderTypes.setRenderLayer(NormalParkourModModBlocks.RAMP.get(), renderType -> renderType == RenderType.cutout());
	}
}
