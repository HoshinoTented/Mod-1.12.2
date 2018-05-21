package com.github.hoshinotented.kotlin.utils

import net.minecraft.item.ItemStack
import net.minecraft.item.crafting.Ingredient
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.common.registry.GameRegistry

private var resourceIndex = 0

private fun path() : String = "recipe_${resourceIndex ++}"

fun ItemStack.addShapedRecipe(line0 : String, line1 : String, line2 : String, vararg items : Pair<Char, Any>) {
	val params = ArrayList<Any>().apply {
		listOf(line0, line1, line2).forEach {
			it.takeIf { it.isNotEmpty() }?.run(::add)
		}

		items.forEach { addAll(it.toList()) }
	}.toTypedArray()

	GameRegistry.addShapedRecipe(
			ResourceLocation("kotlin", path()),
			null,
			this,
			* params
	)
}

fun ItemStack.addShapelessRecipe(vararg item : ItemStack) {
	GameRegistry.addShapelessRecipe(
			ResourceLocation("kotlin", path()),
			null,
			this,
			* item.map { Ingredient.fromStacks(it) }.toTypedArray()
	)
}

fun ItemStack.addSmelting(`in` : ItemStack, exp : Double = 0.0) {
	GameRegistry.addSmelting(`in`, this, exp.toFloat())
}