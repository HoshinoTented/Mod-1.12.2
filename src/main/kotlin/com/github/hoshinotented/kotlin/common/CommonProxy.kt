package com.github.hoshinotented.kotlin.common

import com.github.hoshinotented.kotlin.IProxy
import com.github.hoshinotented.kotlin.item.blocks.BlockLoader
import com.github.hoshinotented.kotlin.item.items.ItemLoader
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

open class CommonProxy : IProxy {
	@Mod.EventHandler
	override fun preInit(event : FMLPreInitializationEvent) {

	}

	@Mod.EventHandler
	override fun init(event : FMLInitializationEvent) {
		ItemLoader.registerRecipes()
		BlockLoader.registerRecipes()
	}

	@Mod.EventHandler
	override fun postInit(event : FMLPostInitializationEvent) {

	}
}