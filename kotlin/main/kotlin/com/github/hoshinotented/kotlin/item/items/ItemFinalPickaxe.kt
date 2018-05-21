package com.github.hoshinotented.kotlin.item.items

import com.github.hoshinotented.kotlin.item.Recipable
import com.github.hoshinotented.kotlin.item.init
import com.github.hoshinotented.kotlin.utils.addShapedRecipe
import com.github.hoshinotented.kotlin.utils.itemStack
import net.minecraft.init.Items
import net.minecraft.item.ItemPickaxe
import net.minecraftforge.common.util.EnumHelper

val materialFinal = EnumHelper.addToolMaterial(
		"KOTLIN_FINAL",
		9,
		99999,
		99F,
		9F,
		9
)

class ItemFinalPickaxe : ItemPickaxe(materialFinal), Recipable {
	init {
		init("final_pickaxe", "finalPickaxe")
	}

	override fun registerRecipes() {
		itemStack.addShapedRecipe(
				"-+-",
				" | ",
				" | ",
				'-' to ItemLoader.scalaPiece,
				'+' to ItemLoader.kotlin,
				'|' to Items.DIAMOND
		)
	}
}