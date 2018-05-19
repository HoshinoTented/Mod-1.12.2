package com.github.hoshinotented.kotlin

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

@Mod(
		modid = Kotlin.MOD_ID,
		name = Kotlin.NAME,
		version = Kotlin.VERSION,
//		modLanguage = "kotlin",
		acceptedMinecraftVersions = "1.12.2"
)
class Kotlin : IProxy {
	companion object Information {
		const val MOD_ID = "kotlin"
		const val NAME = "Kotlin"
		const val VERSION = "1.0.0"

		@SidedProxy(
				clientSide = "com.github.hoshinotented.kotlin.client.ClientProxy",
				serverSide = "com.github.hoshinotented.kotlin.common.CommonProxy"
		) lateinit var proxy : IProxy
		@Mod.Instance lateinit var INSTANCE : Kotlin
	}

	@Mod.EventHandler
	override fun preInit(event : FMLPreInitializationEvent) {
		event.let(proxy::preInit)
	}

	@Mod.EventHandler
	override fun init(event : FMLInitializationEvent) {
		event.let(proxy::init)
	}

	@Mod.EventHandler
	override fun postInit(event : FMLPostInitializationEvent) {
		event.let(proxy::postInit)
	}
}