package com.github.hoshinotented.kotlin.item

import net.minecraft.item.Item

abstract class HoshinoItem(registryName : String, unLocalizedName : String = registryName) : Item() {
	init {
		this.setRegistryName(registryName)
		this.unlocalizedName = unLocalizedName
	}

	open fun registerRecipes() {
		//NONE
	}
}