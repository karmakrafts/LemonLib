package onelemonyboi.lemonlib.trait.tile;

import cpw.mods.util.Lazy;
import lombok.Getter;
import lombok.SneakyThrows;
import net.neoforged.neoforge.energy.IEnergyStorage;
import onelemonyboi.lemonlib.handlers.CustomEnergyStorage;
import onelemonyboi.lemonlib.handlers.MUItemStackHandler;
import onelemonyboi.lemonlib.trait.Trait;

public class TileTraits {
    public static class PowerTrait extends Trait {

        private @Getter int capacity, maxExtract, maxRecieve, energy;
        private final Lazy<IEnergyStorage> lazyEnergyStorage = Lazy.of(this::createEnergyStorage);

        public PowerTrait(int capacity) {
            this.capacity = capacity;
            this.maxExtract = capacity;
            this.maxRecieve = capacity;
            this.energy = 0;
        }

        public PowerTrait(int capacity, int maxTransfer) {
            this.capacity = capacity;
            this.maxExtract = maxTransfer;
            this.maxRecieve = maxTransfer;
            this.energy = 0;
        }

        public PowerTrait(int capacity, int maxReceive, int maxExtract) {
            this.capacity = capacity;
            this.maxExtract = maxExtract;
            this.maxRecieve = maxReceive;
            this.energy = 0;
        }

        public PowerTrait(int capacity, int maxReceive, int maxExtract, int energy) {
            this.capacity = capacity;
            this.maxExtract = maxExtract;
            this.maxRecieve = maxReceive;
            this.energy = energy;
        }

        public PowerTrait(CustomEnergyStorage storage) {
            this.capacity = storage.getMaxEnergyStored();
            this.maxExtract = storage.getMaxExtract();
            this.maxRecieve = storage.getMaxRecieve();
            this.energy = storage.getEnergyStored();
        }

        public CustomEnergyStorage createEnergyStorage() {
            return new CustomEnergyStorage(capacity, maxRecieve, maxExtract, energy);
        }

        public IEnergyStorage getEnergyStorage() {
            return lazyEnergyStorage.get();
        }

        public CustomEnergyStorage getCustomEnergyStorage() {
            return (CustomEnergyStorage) lazyEnergyStorage.get();
        }

        @Override
        @SneakyThrows
        public Object clone() {
            return new PowerTrait(this.getCustomEnergyStorage().copy());
        }
    }

    public static class ItemTrait extends Trait {
        private final Lazy<MUItemStackHandler> lazyItemStackHandler = Lazy.of(this::createItemStackHandler);
        private @Getter int slots;

        public ItemTrait(int slots) {
            this.slots = slots;
        }

        public ItemTrait(MUItemStackHandler storage) {
            this.slots = storage.getSlots();
        }

        public MUItemStackHandler createItemStackHandler() {
            return new MUItemStackHandler(slots);
        }

        public MUItemStackHandler getItemStackHandler() {
            return lazyItemStackHandler.get();
        }

        @Override
        @SneakyThrows
        public Object clone() {
            return new ItemTrait(this.getItemStackHandler().copy());
        }
    }
}
