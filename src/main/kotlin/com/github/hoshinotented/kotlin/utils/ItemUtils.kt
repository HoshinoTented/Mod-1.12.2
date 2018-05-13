package com.github.hoshinotented.kotlin.utils

import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.crafting.Ingredient

operator fun ItemStack.times(amount : Int) : ItemStack = copy().apply {
	count = amount
}

operator fun Item.times(amount : Int) = ItemStack(this, amount)
operator fun Block.times(amount : Int) = ItemStack(this, amount)

fun Item.itemStack(metadata : Int) = ItemStack(this, 1, metadata)
fun Block.itemStack(metadata : Int) = ItemStack(this, 1, metadata)

val Item.itemStack get() = this * 1
val Block.itemStack get() = this * 1

val ItemStack.ingredient : Ingredient get() = Ingredient.fromStacks(this)