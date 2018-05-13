import net.minecraftforge.gradle.user.patcherUser.forge.ForgeExtension
import net.minecraftforge.gradle.user.patcherUser.forge.ForgePlugin
import org.gradle.api.internal.HasConvention

buildscript {
	repositories {
		jcenter()
		maven("http://files.minecraftforge.net/maven")
	}

	dependencies {
		classpath("net.minecraftforge.gradle:ForgeGradle:2.3-SNAPSHOT")
	}
}

apply(plugin = "net.minecraftforge.gradle.forge")

plugins {
	kotlin("jvm") version "1.2.41"
}

val kotlinVersion = "1.2.41"
val Project.forgePlugin : ForgePlugin get() = plugins.getPlugin(ForgePlugin::class.java)
val Project.minecraft : ForgeExtension get() = forgePlugin.extension
val Project.sourceSets : SourceSetContainer get() = java.sourceSets
val Project.processResources : ProcessResources get() = tasks.getByName("processResources") as ProcessResources

operator fun <TaskType : Task> TaskType.invoke(action : TaskType.() -> Unit) = apply(action)
operator fun ForgeExtension.invoke(action : ForgeExtension.() -> Unit) = apply(action)

version = "1.0.0"
group = "com.github.HoshinoTented"
BasePluginConvention(project).archivesBaseName = "kotlin"

tasks.withType<JavaCompile> {
	sourceCompatibility = "1.8"
	targetCompatibility = sourceCompatibility
}

minecraft {
	version = "1.12.2-14.23.3.2655"
	runDir = "run"
	mappings = "snapshot_20171003"
}

dependencies {
	compile(kotlin("stdlib-jdk8", kotlinVersion))
	compile(kotlin("test-junit", kotlinVersion))
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