package ru.argentum.htm;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import ru.argentum.htm.HardTechnologyMod;

public class Registry {
    // Deferred Registers
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(HardTechnologyMod.MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HardTechnologyMod.MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HardTechnologyMod.MODID);

    // Блоки и предметы
    public static final DeferredBlock<Block> EXAMPLE_BLOCK =
            BLOCKS.registerSimpleBlock("example_block",
                    BlockBehaviour.Properties.of().mapColor(MapColor.STONE));

    public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM =
            ITEMS.registerSimpleBlockItem("example_block", EXAMPLE_BLOCK);

    // Еда
    public static final DeferredItem<Item> EXAMPLE_ITEM =
            ITEMS.registerSimpleItem("example_item",
                    new Item.Properties().food(new FoodProperties.Builder()
                            .alwaysEdible()
                            .nutrition(1)
                            .saturationModifier(2f)
                            .build()));

    // Креативная вкладка
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB =
            CREATIVE_MODE_TABS.register("example_tab",
                    () -> CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.htm"))
                            .withTabsBefore(CreativeModeTabs.COMBAT)
                            .icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
                            .displayItems((parameters, output) -> {
                                output.accept(EXAMPLE_ITEM.get());
                            }).build());

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        CREATIVE_MODE_TABS.register(eventBus);
    }
}