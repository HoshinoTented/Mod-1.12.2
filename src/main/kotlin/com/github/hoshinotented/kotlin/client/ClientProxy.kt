package com.github.hoshinotented.kotlin.client

import com.github.hoshinotented.kotlin.common.CommonProxy
import com.github.hoshinotented.kotlin.item.ItemLoader
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

class ClientProxy : CommonProxy() {
	@Mod.EventHandler
	override fun preInit(event : FMLPreInitializationEvent) {
		super.preInit(event)

		ItemLoader.registerRenders()
	}

	@Mod.EventHandler
	override fun init(event : FMLInitializationEvent) {
		super.init(event)
	}

	@Mod.EventHandler
	override fun postInit(event : FMLPostInitializationEvent) {
		super.postInit(event)
	}
}