package net.identitytheft.sculkitems.item;

import net.identitytheft.sculkitems.block.EchoFireBlock;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EchoLighterItem extends Item {

	public EchoLighterItem(Settings settings) {
		super(settings);
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.translatable("item.sculk_items.echo_lighter.tooltip").formatted(Formatting.AQUA));
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		World world = context.getWorld();
		PlayerEntity playerEntity = context.getPlayer();

		BlockState blockState = world.getBlockState(context.getBlockPos());

		BlockPos blockPos = context.getBlockPos();
		BlockPos firePos = blockPos.up();

		if (EchoFireBlock.canPlaceAt(world, firePos, blockState)) {

			world.playSound(playerEntity, firePos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0f, world.getRandom().nextFloat() * 0.4f + 0.8f);

			BlockState fireState = EchoFireBlock.getState(world, firePos);
			world.setBlockState(firePos, fireState, Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);

			ItemStack itemStack = context.getStack();

			if (playerEntity instanceof ServerPlayerEntity) {
				Criteria.PLACED_BLOCK.trigger((ServerPlayerEntity)playerEntity, firePos, itemStack);
				itemStack.damage(1, playerEntity, p -> p.sendToolBreakStatus(context.getHand()));
			}

			return ActionResult.success(world.isClient());
		}

		return ActionResult.FAIL;
	}
}