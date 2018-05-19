package com.github.hoshinotented.kotlin

import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

interface IProxy {
	fun preInit(event : FMLPreInitializationEvent)
	fun init(event : FMLInitializationEvent)
	fun postInit(event : FMLPostInitializationEvent)
}