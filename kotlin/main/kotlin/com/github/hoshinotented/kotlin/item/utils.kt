package com.github.hoshinotented.kotlin.item

import com.github.hoshinotented.kotlin.creativetab.KotlinCreativeTab
import net.minecraft.block.Block
import net.minecraft.item.Item

fun Item.init(registryName : String, unLocalizedName : String = registryName) {
	setRegistryName(registryName)
	unlocalizedName = unLocalizedName
	creativeTab = KotlinCreativeTab
}

fun Block.init(registryName : String, unLocalizedName : String = registryName) {
	setRegistryName(registryName)
	unlocalizedName = unLocalizedName
	setCreativeTab(KotlinCreativeTab)
}