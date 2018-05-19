package com.github.hoshinotented.kotlin.item.items

import com.github.hoshinotented.kotlin.Kotlin
import com.github.hoshinotented.kotlin.item.Recipable
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

@Mod.EventBusSubscriber(modid = Kotlin.MOD_ID)
object ItemLoader {
	private val items : Array<HoshinoItem> = arrayOf(
			ItemKotlin,
			ItemColdJava,
			ItemJava
	)

	@JvmStatic            //It should be `JvmStatic` !!!
	@SubscribeEvent
	@Suppress("unused")
	fun registerItems(event : RegistryEvent.Register<Item>) {
		event.registry.registerAll(* ItemLoader.items)
	}

	@JvmStatic
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	@Suppress("unused")
	fun registerRenders(event : ModelRegistryEvent) {        //https://github.com/ustc-zzzz/fmltutor/issues/74
		ItemLoader.items.forEach(ItemLoader::registerRender)
	}

	fun registerRecipes() {
		ItemLoader.items.forEach(Recipable::registerRecipes)
	}

	@SideOnly(Side.CLIENT)
	private fun registerRender(item : Item) {
		ModelResourceLocation(item.registryName ?: return, "inventory").let {
			ModelLoader.setCustomModelResourceLocation(item, 0, it)
		}
	}
}