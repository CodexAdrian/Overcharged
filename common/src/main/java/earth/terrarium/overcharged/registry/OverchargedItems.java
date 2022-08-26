package earth.terrarium.overcharged.registry;

import dev.architectury.injectables.annotations.ExpectPlatform;
import earth.terrarium.overcharged.Overcharged;
import earth.terrarium.overcharged.item.*;
import earth.terrarium.overcharged.utils.ToolType;
import earth.terrarium.overcharged.utils.ToolUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.*;

import java.util.function.Supplier;

public class OverchargedItems {

    public static final Supplier<Item> HAMMER = registerItem("hammer", () -> new Item(props()));
    public static final Supplier<Item> SMASHED_IRON = registerItem("smashed_iron", () -> new Item(props()));
    public static final Supplier<Item> SMASHED_COPPER = registerItem("smashed_copper", () -> new Item(props()));
    public static final Supplier<Item> SMASHED_NICKEL = registerItem("smashed_nickel", () -> new Item(props()));
    public static final Supplier<Item> SMASHED_CONSTANTAN = registerItem("smashed_constantan", () -> new Item(props()));
    public static final Supplier<Item> NICKEL_INGOT = registerItem("nickel_ingot", () -> new Item(props()));
    public static final Supplier<Item> CONSTANTAN_INGOT = registerItem("constantan_ingot", () -> new Item(props()));
    public static final Supplier<Item> CONSTANTAN_SWORD = registerItem("constantan_sword", () -> new ConstantanSwordItem(3, -2.4f, props()));
    public static final Supplier<Item> CONSTANTAN_SHOVEL = registerItem("constantan_shovel", () -> new ConstantanTool(ToolType.SHOVEL, BlockTags.MINEABLE_WITH_SHOVEL, 1.5f, -3.0f, props()));
    public static final Supplier<Item> CONSTANTAN_PICKAXE = registerItem("constantan_pickaxe", () -> new ConstantanTool(ToolType.NONE, BlockTags.MINEABLE_WITH_PICKAXE,1, -2.8f, props()));
    public static final Supplier<Item> CONSTANTAN_AXE = registerItem("constantan_axe", () -> new ConstantanTool(ToolType.AXE, BlockTags.MINEABLE_WITH_AXE,5.0f, -3.0f, props()));
    public static final Supplier<Item> CONSTANTAN_HOE = registerItem("constantan_hoe", () -> new ConstantanTool(ToolType.HOE, BlockTags.MINEABLE_WITH_HOE,-3, 0.0f, props()));
    public static final Supplier<Item> CONSTANTAN_AIOT = registerItem("constantan_aiot", () -> new ConstantanTool(ToolType.NONE, ToolUtils.getAIOTBlockTag(),4.0f, -2.6f, props()));
    public static final Supplier<Item> CONSTANTAN_BOW = registerItem("constantan_bow", () -> new ConstantanBow(props()));

    public static Item.Properties props() {
        return new Item.Properties().tab(Overcharged.TAB);
    }

    @ExpectPlatform
    public static Supplier<Item> registerItem(String name, Supplier<Item> item) {
        throw new AssertionError();
    }

    public static void registerAll() {

    }
}
