package com.github.hoshinotented.kotlin.item.items

import com.github.hoshinotented.kotlin.item.Recipable
import com.github.hoshinotented.kotlin.item.init
import com.github.hoshinotented.kotlin.utils.addShapelessRecipe
import com.github.hoshinotented.kotlin.utils.addSmelting
import com.github.hoshinotented.kotlin.utils.itemStack
import net.minecraft.init.Items
import net.minecraft.item.Item

//明示 Java 已经凉了 (光速逃
class ItemColdJava : Item(), Recipable {
	init {
		init("cold_java", "coldJava")
	}

	override fun registerRecipes() {
		itemStack.addShapelessRecipe(
				Items.MILK_BUCKET.itemStack,
				Items.GLASS_BOTTLE.itemStack,
				Items.DYE.itemStack(3)
		)
	}
}

class ItemJava : Item(), Recipable {
	init {
		init("java")
	}

	override fun registerRecipes() {
		itemStack.addSmelting(ItemLoader.coldJava.itemStack, 0.9)
	}
}