package com.github.hoshinotented.kotlin.utils

import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.crafting.Ingredient
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.common.registry.GameRegistry

operator fun ItemStack.times(amount : Int) {
	count = amount
}

operator fun Item.times(amount : Int) = ItemStack(this, amount)
operator fun Block.times(amount : Int) = ItemStack(this, amount)

fun Item.itemStack(metadata : Int) = ItemStack(this, 1, metadata)
fun Block.itemStack(metadata : Int) = ItemStack(this, 1, metadata)

val Item.itemStack get() = this * 1
val Block.itemStack get() = this * 1

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