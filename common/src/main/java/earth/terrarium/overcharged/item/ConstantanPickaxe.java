package earth.terrarium.overcharged.item;

import earth.terrarium.overcharged.energy.AOEMode;
import earth.terrarium.overcharged.energy.EnergyItem;
import earth.terrarium.overcharged.energy.ToolMode;
import earth.terrarium.overcharged.energy.VeinMineMode;
import earth.terrarium.overcharged.utils.ToolUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ConstantanPickaxe extends PickaxeItem implements EnergyItem {
    public ConstantanPickaxe(int i, float f, Properties properties) {
        super(ConstantanTier.INSTANCE, i, f, properties);
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack itemStack, @NotNull BlockState blockState) {
        float speed = super.getDestroySpeed(itemStack, blockState);
        return this.hasEnoughEnergy(itemStack, 200) ? EnergyItem.isEmpowered(itemStack) ? speed * 1.2F : speed : 0;
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack itemStack, @NotNull LivingEntity livingEntity, @NotNull LivingEntity livingEntity2) {
        return ToolUtils.hurtEnemy(this, itemStack, livingEntity, livingEntity2, 400);
    }

    @Override
    public boolean mineBlock(@NotNull ItemStack itemStack, Level level, @NotNull BlockState blockState, @NotNull BlockPos blockPos, @NotNull LivingEntity livingEntity) {
        return ToolUtils.mineBlock(this, itemStack, level, blockState, blockPos, 200);
    }
}
