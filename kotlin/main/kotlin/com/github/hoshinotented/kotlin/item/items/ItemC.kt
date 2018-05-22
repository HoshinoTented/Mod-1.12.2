package com.github.hoshinotented.kotlin.item.items

import com.github.hoshinotented.kotlin.item.Recipable
import com.github.hoshinotented.kotlin.item.init
import com.github.hoshinotented.kotlin.utils.addShapedRecipe
import com.github.hoshinotented.kotlin.utils.itemStack
import net.minecraft.item.Item

class ItemC : Item(), Recipable {
	init {
		init("c")
	}

	override fun registerRecipes() {
		itemStack.addShapedRecipe(
				"000",
				"+  ",
				"111",
				'0' to ItemLoader.zero,
				'+' to ItemLoader.baseCenter,
				'1' to ItemLoader.one
		)
	}
}

class ItemCpp : Item(), Recipable {
	init {
		init("cpp")
	}

	override fun registerRecipes() {
		itemStack.addShapedRecipe(
				" + ",
				"+=+",
				" + ",
				'+' to ItemLoader.c,
				'=' to ItemLoader.machineCenter
		)
	}
}