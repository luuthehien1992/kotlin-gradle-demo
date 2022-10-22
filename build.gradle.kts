import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.7.10"
  kotlin("kapt") version "1.7.10"
  application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
  mavenLocal()
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.7.20")
  implementation("com.fasterxml.jackson.core:jackson-databind:2.13.4.2")
  implementation("com.google.code.gson:gson:2.9.1")
  implementation("org.redisson:redisson:3.17.7")

  implementation("com.google.dagger:dagger:2.44")
  kapt("com.google.dagger:dagger-compiler:2.44")

  implementation("org.mapstruct:mapstruct:1.5.3.Final")
  kapt("org.mapstruct:mapstruct-processor:1.5.3.Final")

  testImplementation("org.jetbrains.kotlin:kotlin-test:1.7.20")
}

application {
  mainClass.set("MainKt")
}

tasks.test {
  useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "1.8"
}

tasks.jar {
  manifest.attributes["Main-Class"] = application.mainClass
}

task("buildWithLibs") {
  group = "build"
  description = "build with dependencies in libs folder"

  task("copyDependencies", Copy::class) {
    from(configurations.default).into("$buildDir/libs/libs")
  }

  tasks.jar {
    manifest.attributes["Class-Path"] = configurations
      .runtimeClasspath
      .get()
      .joinToString(separator = " ") { file ->
        "libs/${file.name}"
      }
  }

  dependsOn("jar")
  dependsOn("copyDependencies")
}