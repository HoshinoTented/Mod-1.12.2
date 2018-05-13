package com.github.hoshinotented.kotlin.utils

import net.minecraft.item.ItemStack
import net.minecraft.item.crafting.Ingredient
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.common.registry.GameRegistry

fun ItemStack.addShapedRecipe(line0 : String, line1 : String, line2 : String, vararg items : Pair<Char, Any>) {
	GameRegistry.addShapedRecipe(
			ResourceLocation(""),
			null,
			this,
			line0,
			line1,
			line2,
			* items.flatMap {
				listOf(it.first, it.second)
			}.toTypedArray()
	)
}

fun ItemStack.addShapelessRecipe(vararg item : ItemStack) {
	GameRegistry.addShapelessRecipe(
			ResourceLocation(""),
			null,
			this,
			Ingredient.fromStacks(* item)
	)
}

fun ItemStack.addSmelting(`in` : ItemStack, exp : Double = 0.0) {
	GameRegistry.addSmelting(`in`, this, exp.toFloat())
}