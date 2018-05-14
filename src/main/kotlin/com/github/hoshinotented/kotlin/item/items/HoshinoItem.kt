package com.github.hoshinotented.kotlin.item.items

import com.github.hoshinotented.kotlin.item.Recipable
import net.minecraft.item.Item

abstract class HoshinoItem(
		registryName : String,
		unLocalizedName : String = registryName
) : Item(), Recipable {
	init {
		this.setRegistryName(registryName)
		this.unlocalizedName = unLocalizedName
	}
}