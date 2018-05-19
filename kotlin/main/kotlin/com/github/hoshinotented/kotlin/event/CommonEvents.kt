package com.github.hoshinotented.kotlin.event

import com.github.hoshinotented.kotlin.item.items.ItemJava
import net.minecraft.entity.item.EntityTNTPrimed
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.eventhandler.EventBus
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

object CommonEvents {
	val EVENT_BUS = EventBus()

	fun init() {
		MinecraftForge.EVENT_BUS.register(this)
		MinecraftForge.EVENT_BUS.register(EVENT_BUS)
	}

	@SubscribeEvent
	@Suppress("unused")
	fun rightClickBlockEvent(event : BlockExplodedEvent) {
		if (! event.world.isRemote) {
			val pos = event.pos
			val entityCount = event.entityPlayer.heldItemMainhand.takeIf { it.item === ItemJava }?.count ?: 0
			val tnt = EntityTNTPrimed(event.world, pos.x + 0.5, pos.y + 0.5, pos.z + 0.5, null)
			repeat(entityCount) {
				event.world.spawnEntity(tnt)
			}
		}
	}
}