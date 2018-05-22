package com.github.hoshinotented.kotlin.item.items

import com.github.hoshinotented.kotlin.Kotlin
import com.github.hoshinotented.kotlin.item.Loadable
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

@Suppress("unused")
@Mod.EventBusSubscriber(modid = Kotlin.MOD_ID)
object ItemLoader {
	@Loadable val machineCenter = ItemMachineCenter()
	@Loadable val kotlin = ItemKotlin()
	@Loadable val coldJava = ItemColdJava()
	@Loadable val java = ItemJava()
	@Loadable val scalaPiece = ItemScalaPiece()
	@Loadable val scala = ItemScala()
	@Loadable val zero = ItemZero()
	@Loadable val one = ItemOne()
	@Loadable val baseCenter = ItemBaseCenter()
	@Loadable val c = ItemC()
	@Loadable val cpp = ItemCpp()

	@Loadable val finalPickaxe = ItemFinalPickaxe()

	private val items : Array<Item> by lazy {
		ItemLoader::class.java.declaredFields.mapNotNull {
			if (it.isAnnotationPresent(Loadable::class.java)) {
				it.isAccessible = true
				it.get(null) as Item
			} else null
		}.toTypedArray()
	}

	@JvmStatic            //It should be `JvmStatic` !!!
	@SubscribeEvent
	fun registerItems(event : RegistryEvent.Register<Item>) {
		event.registry.registerAll(* ItemLoader.items)
	}

	@JvmStatic
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	fun registerRenders(event : ModelRegistryEvent) {        //https://github.com/ustc-zzzz/fmltutor/issues/74
		ItemLoader.items.forEach(ItemLoader::registerRender)
	}

	fun registerRecipes() {
		ItemLoader.items.forEach {
			(it as? Recipable)?.registerRecipes()
		}
	}

	@SideOnly(Side.CLIENT)
	private fun registerRender(item : Item) {
		ModelResourceLocation(item.registryName ?: return, "inventory").let {
			ModelLoader.setCustomModelResourceLocation(item, 0, it)
		}
	}
}