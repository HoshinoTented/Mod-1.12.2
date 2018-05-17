package com.github.hoshinotented.kotlin.item.items

import com.github.hoshinotented.kotlin.creativetab.KotlinCreativeTab
import com.github.hoshinotented.kotlin.item.Recipable
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item

abstract class HoshinoItem(
		registryName : String,
		unLocalizedName : String = registryName
) : Item(), Recipable {
	init {
		this.setRegistryName(registryName)
		this.setCreativeTab(KotlinCreativeTab)
		this.unlocalizedName = unLocalizedName
	}

	final override fun setCreativeTab(tab : CreativeTabs) : Item = super.setCreativeTab(tab)
}