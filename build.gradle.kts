import org.gradle.api.internal.HasConvention
import org.gradle.api.internal.project.ProjectInternal
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
	repositories {
		jcenter()
		maven("http://files.minecraftforge.net/maven")
	}

	dependencies {
		classpath("net.minecraftforge.gradle:ForgeGradle:2.3-SNAPSHOT")
	}
}

plugins {
	kotlin("jvm") version "1.2.41"
}

val jvmTarget = "1.8"
var kotlinVersion : String by extra
kotlinVersion = "1.2.41"

allprojects {
	apply {
		plugin("kotlin")
	}

	version = "1.0.0"
	group = "com.github.HoshinoTented"
	//BasePluginConvention(project).archivesBaseName = "kotlin"            //FIXME it is useless !!!

	tasks.withType<JavaCompile> {
		sourceCompatibility = jvmTarget
		targetCompatibility = sourceCompatibility
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions.jvmTarget = jvmTarget
	}

	dependencies {
		compile(kotlin("stdlib-jdk8", kotlinVersion))
		compile(kotlin("test-junit", kotlinVersion))
		testCompile(kotlin("reflect", kotlinVersion))
	}
}