package com.github.hoshinotented.kotlin.item

import com.github.hoshinotented.kotlin.utils.addShapedRecipe
import com.github.hoshinotented.kotlin.utils.addSmelting
import com.github.hoshinotented.kotlin.utils.itemStack
import com.github.hoshinotented.kotlin.utils.times
import net.minecraft.init.Blocks
import net.minecraft.init.Items

object ItemKotlin : HoshinoItem("kotlin", "kotlin") {
	override fun registerRecipes() {
		itemStack.addShapedRecipe(
				"*#+",
				"#+#",
				"+#*",
				'*' to Blocks.OBSIDIAN,
				'#' to Items.DIAMOND,
				'+' to Items.GOLD_INGOT
		)

		Blocks.DIRT.times(9).addSmelting(itemStack)
	}
}