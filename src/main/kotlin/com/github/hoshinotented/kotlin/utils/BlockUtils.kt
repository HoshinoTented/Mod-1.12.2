package com.github.hoshinotented.kotlin.utils

import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock

val Block.item : Item get() = Item.getItemFromBlock(this)
val Block.itemBlock : ItemBlock get() = ItemBlock(this)