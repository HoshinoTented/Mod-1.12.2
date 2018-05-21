package com.github.hoshinotented.kotlin.item.items

import com.github.hoshinotented.kotlin.item.Recipable
import com.github.hoshinotented.kotlin.item.init
import com.github.hoshinotented.kotlin.utils.addShapedRecipe
import com.github.hoshinotented.kotlin.utils.itemStack
import net.minecraft.init.Blocks
import net.minecraft.init.Items
import net.minecraft.item.Item

class ItemMachineCenter : Item(), Recipable {
	init {
		init("machine_center", "machineCenter")
	}

	override fun registerRecipes() {
		itemStack.addShapedRecipe(
				"*+*",
				"+=+",
				"*+*",
				'*' to Items.IRON_INGOT,
				'+' to Items.REDSTONE,
				'=' to Blocks.REDSTONE_BLOCK
		)
	}
}

class ItemZero : Item(), Recipable {
	init {
		init("zero")
	}

	override fun registerRecipes() {
		itemStack.addShapedRecipe(
				" * ",
				"*+*",
				" * ",
				'*' to Items.IRON_INGOT,
				'+' to ItemLoader.machineCenter
		)
	}
}

class ItemOne : Item(), Recipable {
	init {
		init("one")
	}

	override fun registerRecipes() {
		itemStack.addShapedRecipe(
				"-- ",
				" - ",
				"-+-",
				'-' to Items.IRON_INGOT,
				'+' to ItemLoader.machineCenter
		)
	}
}

class ItemBaseCenter : Item(), Recipable {
	init {
		init("base_center", "baseCenter")
	}

	override fun registerRecipes() {
		itemStack.addShapedRecipe(
				"0+1", "", "",
				'0' to ItemLoader.zero,
				'+' to ItemLoader.machineCenter,
				'1' to ItemLoader.one
		)
	}
}