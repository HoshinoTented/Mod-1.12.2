package com.github.hoshinotented.kotlin.item

import com.github.hoshinotented.kotlin.utils.addShapelessRecipe
import com.github.hoshinotented.kotlin.utils.addSmelting
import com.github.hoshinotented.kotlin.utils.itemStack
import net.minecraft.init.Items

//明示 Java 已经凉了 (光速逃
object ItemColdJava : HoshinoItem("cold_java", "coldJava") {
	override fun registerRecipes() {
		itemStack.addShapelessRecipe(
				Items.MILK_BUCKET.itemStack,
				Items.GLASS_BOTTLE.itemStack,
				Items.DYE.itemStack(3)
		)
	}
}

object ItemJava : HoshinoItem("java", "java") {
	override fun registerRecipes() {
		itemStack.addSmelting(ItemColdJava.itemStack, 0.9)
	}
}