package com.github.hoshinotented.kotlin.creativetab

import com.github.hoshinotented.kotlin.item.items.ItemKotlin
import com.github.hoshinotented.kotlin.item.items.ItemLoader
import com.github.hoshinotented.kotlin.utils.itemStack
import net.minecraft.creativetab.CreativeTabs

object KotlinCreativeTab : CreativeTabs("kotlin") {
	override fun getTabIconItem() = ItemLoader.kotlin.itemStack
}