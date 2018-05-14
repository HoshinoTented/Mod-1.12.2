package com.github.hoshinotented.kotlin.item.blocks

import com.github.hoshinotented.kotlin.item.Recipable
import net.minecraft.block.Block
import net.minecraft.block.material.Material

abstract class HoshinoBlock(
		registryName : String,
		unLocalizedName : String = registryName,
		material : Material
) : Block(material), Recipable {
	init {
		setRegistryName(registryName)
		this.unlocalizedName = unLocalizedName
	}
}