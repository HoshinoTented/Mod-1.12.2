package com.github.hoshinotented.kotlin.event

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraftforge.event.entity.player.PlayerEvent
import net.minecraftforge.fml.common.eventhandler.Cancelable

@Cancelable
class BlockExplodedEvent(player : EntityPlayer, val pos : BlockPos, val world : World) : PlayerEvent(player)