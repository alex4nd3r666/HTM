package ru.argentum.htm.content.items;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import ru.argentum.htm.HardTechnologyMod;
import net.neoforged.neoforge.registries.DeferredRegister;
public class ModItems {
    public static final DeferredRegister.Items ITEMS
            = DeferredRegister.createItems(HardTechnologyMod.MODID);
    //public static final DeferredItem<Item> BISMUTH = ITEMS.registerItem("bismuth", Item::new, new Item.Properties());

    //public static final DeferredItem<Item> KEYGEN = ITEMS.register("keygen",
    //        ()-> new Item(new Item.Properties()));

    public static void Register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
