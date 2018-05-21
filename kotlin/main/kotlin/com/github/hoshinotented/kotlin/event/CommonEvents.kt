package com.github.hoshinotented.kotlin.event

import com.github.hoshinotented.kotlin.item.items.ItemJava
import net.minecraft.entity.item.EntityTNTPrimed
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

object CommonEvents {
	fun init() {
		MinecraftForge.EVENT_BUS.register(this)
	}

	/**
	 * 主手持 `ItemJava` 右键 `BlockKotlinBlock`
	 * 就会消耗 `ItemJava` 并讲 `BlockKotlinBlock` 转化成 TNT
	 * 这说明了 `Kotlin` 和 `Java` 的水火不容（特大雾
	 */
	@SubscribeEvent
	@Suppress("unused")
	fun rightClickBlockEvent(event : BlockExplodedEvent) {
		if (! event.world.isRemote && event.entityPlayer.heldItemMainhand.item is ItemJava) {
			val pos = event.pos
			val tnt = EntityTNTPrimed(event.world, pos.x + 0.5, pos.y + 0.5, pos.z + 0.5, null)

			event.entityPlayer.heldItemMainhand.count -= 1
			event.world.spawnEntity(tnt)
		}
	}
}