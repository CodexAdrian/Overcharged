package earth.terrarium.overcharged.mixin;

import earth.terrarium.overcharged.energy.EnergyItem;
import earth.terrarium.overcharged.ForgeEnergyStorage;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.extensions.IForgeItem;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EnergyItem.class)
public abstract class EnergyItemMixin implements EnergyItem, IForgeItem {
    @Override
    public int getEnergy(ItemStack stack) {
        return stack.getCapability(CapabilityEnergy.ENERGY).map(IEnergyStorage::getEnergyStored).orElse(0);
    }

    @Override
    public void setEnergy(ItemStack stack, int energy) {
        stack.getCapability(CapabilityEnergy.ENERGY).filter(object -> object instanceof ForgeEnergyStorage).map(object -> (ForgeEnergyStorage) object).ifPresent(fenergy -> fenergy.setEnergy(energy));
    }

    @Override
    public @Nullable ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return new ForgeEnergyStorage(stack, getMaxEnergy());
    }
}
