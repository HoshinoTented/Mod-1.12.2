package com.github.hoshinotented.kotlin.item.blocks

import com.github.hoshinotented.kotlin.Kotlin
import com.github.hoshinotented.kotlin.item.Recipable
import com.github.hoshinotented.kotlin.utils.item
import com.github.hoshinotented.kotlin.utils.itemBlock
import net.minecraft.block.Block
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
@Mod.EventBusSubscriber(modid = Kotlin.MOD_ID)
object BlockLoader {
	private val blocks : Array<HoshinoBlock> = arrayOf(
			BlockKotlinBlock
	)

	@JvmStatic
	@SubscribeEvent
	@Suppress("unused")
	fun registerBlocks(event : RegistryEvent.Register<Block>) {
		event.registry.registerAll(* BlockLoader.blocks)
	}

	@JvmStatic
	@SubscribeEvent
	@Suppress("unused")
	fun registerItemBlocks(event : RegistryEvent.Register<Item>) {        //need register `blocks` and `item blocks`
		event.registry.registerAll(
				* BlockLoader.blocks.map { block ->
					block.itemBlock.setRegistryName(block.registryName)
				}.toTypedArray()
		)
	}

	@JvmStatic
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	@Suppress("unused")
	fun registerRenders(event : ModelRegistryEvent) {
		BlockLoader.blocks.forEach(BlockLoader::registerRender)
	}

	fun registerRecipes() {
		BlockLoader.blocks.forEach(Recipable::registerRecipes)
	}

	@SideOnly(Side.CLIENT)
	private fun registerRender(block : Block) {
		ModelResourceLocation(block.registryName ?: return, "inventory").let {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, it)
		}
	}
}