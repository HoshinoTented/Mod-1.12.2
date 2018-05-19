import net.minecraftforge.gradle.user.patcherUser.forge.ForgeExtension
import net.minecraftforge.gradle.user.patcherUser.forge.ForgePlugin
import org.gradle.api.internal.HasConvention
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

apply {
	plugin("net.minecraftforge.gradle.forge")
}

val Project.forgePlugin : ForgePlugin get() = plugins.getPlugin(ForgePlugin::class.java)
val Project.minecraft : ForgeExtension get() = forgePlugin.extension
val Project.sourceSets : SourceSetContainer get() = java.sourceSets
val Project.processResources : ProcessResources get() = tasks.getByName("processResources") as ProcessResources
val SourceSet.kotlin
	get() = (this as HasConvention)
			.convention
			.getPlugin(KotlinSourceSet::class)
			.kotlin

operator fun <TaskType : Task> TaskType.invoke(action : TaskType.() -> Unit) = apply(action)
operator fun ForgeExtension.invoke(action : ForgeExtension.() -> Unit) = apply(action)

sourceSets {
	listOf("main", "test").forEach {
		it {
			kotlin.srcDirs("$it/kotlin")
			resources.srcDirs("$it/resources")
		}
	}
}

minecraft {
	version = "1.12.2-14.23.3.2655"
	runDir = "run"
	mappings = "snapshot_20171003"
}

processResources {
	inputs.property("version", project.version)
	inputs.property("mcversion", project.minecraft.version)

	from(sourceSets.getByName("main").resources.srcDirs) {
		include("mcmod.info")
		expand(
				mapOf(
						"version" to project.version,
						"mcversion" to project.minecraft.version
				)
		)
	}

	from(sourceSets.getByName("main").resources.srcDirs) {
		exclude("mcmod.info")
	}
}