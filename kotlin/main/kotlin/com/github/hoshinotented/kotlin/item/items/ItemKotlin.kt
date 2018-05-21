package com.github.hoshinotented.kotlin.item.items

import com.github.hoshinotented.kotlin.item.Recipable
import com.github.hoshinotented.kotlin.item.init
import com.github.hoshinotented.kotlin.utils.*
import net.minecraft.init.Blocks
import net.minecraft.init.Items
import net.minecraft.item.Item

class ItemKotlin : Item(), Recipable {
	init {
		init("kotlin")
	}

	override fun registerRecipes() {
		itemStack.addShapedRecipe(
				"#++",
				"++ ",
				"+##",
				'#' to Items.DIAMOND,
				'+' to Items.GOLD_INGOT
		)

		itemStack.addShapedRecipe(
				"s--", "", "",
				's' to ItemLoader.scala,
				'-' to ItemLoader.scalaPiece
		)

		Blocks.DIRT.times(9).addSmelting(itemStack)
	}
}