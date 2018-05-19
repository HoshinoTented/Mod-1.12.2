package com.github.hoshinotented.kotlin.item.blocks

import com.github.hoshinotented.kotlin.event.BlockExplodedEvent
import com.github.hoshinotented.kotlin.event.CommonEvents
import com.github.hoshinotented.kotlin.item.items.ItemJava
import com.github.hoshinotented.kotlin.item.items.ItemKotlin
import com.github.hoshinotented.kotlin.utils.addShapedRecipe
import com.github.hoshinotented.kotlin.utils.itemStack
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraftforge.common.MinecraftForge

object BlockKotlinBlock : HoshinoBlock(
		"kotlin_block",
		"kotlinBlock",
		Material.GROUND
) {
	override fun registerRecipes() {
		itemStack.addShapedRecipe(
				"***",
				"***",
				"***",
				'*' to ItemKotlin
		)
	}

	override fun onBlockActivated(
			worldIn : World?,
			pos : BlockPos?,
			state : IBlockState?,
			playerIn : EntityPlayer?,
			hand : EnumHand?,
			facing : EnumFacing?,
			hitX : Float,
			hitY : Float,
			hitZ : Float
	) : Boolean {
		return if (worldIn != null && pos != null && playerIn != null && playerIn.heldItemMainhand.item === ItemJava) {
			BlockExplodedEvent(playerIn, pos, worldIn).run {
				MinecraftForge.EVENT_BUS.post(this)

				if (isCanceled.not() && worldIn.isRemote.not()) {
					worldIn.setBlockToAir(pos)
					true
				} else false
			}
		} else false
	}
}