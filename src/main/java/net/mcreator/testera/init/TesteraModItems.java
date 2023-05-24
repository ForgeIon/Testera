
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.testera.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.testera.item.JetpackItem;
import net.mcreator.testera.TesteraMod;

public class TesteraModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TesteraMod.MODID);
	public static final RegistryObject<Item> JETPACK_HELMET = REGISTRY.register("jetpack_helmet", () -> new JetpackItem.Helmet());
	public static final RegistryObject<Item> JETPACK_CHESTPLATE = REGISTRY.register("jetpack_chestplate", () -> new JetpackItem.Chestplate());
}
