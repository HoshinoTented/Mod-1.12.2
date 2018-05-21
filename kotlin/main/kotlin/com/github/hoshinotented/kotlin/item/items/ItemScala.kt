package com.github.hoshinotented.kotlin.item.items

import com.github.hoshinotented.kotlin.item.Recipable
import com.github.hoshinotented.kotlin.item.init
import com.github.hoshinotented.kotlin.utils.addShapedRecipe
import com.github.hoshinotented.kotlin.utils.itemStack
import net.minecraft.init.Items
import net.minecraft.item.Item

class ItemScalaPiece : Item(), Recipable {
	init {
		init("scala_piece", "scalaPiece")
	}

	override fun registerRecipes() {
		itemStack.addShapedRecipe(
				" * ",
				"*+*",
				" * ",
				'*' to ItemLoader.java,
				'+' to Items.DIAMOND
		)
	}
}

class ItemScala : Item(), Recipable {
	init {
		init("scala")
	}

	override fun registerRecipes() {
		itemStack.addShapedRecipe(
				"*",
				"*",
				"*",
				'*' to ItemLoader.scalaPiece
		)
	}
}