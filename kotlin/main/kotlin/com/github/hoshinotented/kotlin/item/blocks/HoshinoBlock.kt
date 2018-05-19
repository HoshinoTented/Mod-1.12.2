package com.github.hoshinotented.kotlin.item.blocks

import com.github.hoshinotented.kotlin.creativetab.KotlinCreativeTab
import com.github.hoshinotented.kotlin.item.Recipable
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs

abstract class HoshinoBlock(
		registryName : String,
		unLocalizedName : String = registryName,
		material : Material
) : Block(material), Recipable {
	init {
		this.setRegistryName(registryName)
		this.setCreativeTab(KotlinCreativeTab)
		this.unlocalizedName = unLocalizedName
	}

	final override fun setCreativeTab(tab : CreativeTabs) : Block = super.setCreativeTab(tab)
}