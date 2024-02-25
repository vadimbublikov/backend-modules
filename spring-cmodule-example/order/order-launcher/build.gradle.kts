val storeAppVersion: String by project
val paymentVersion: String by project

val executableStoreJar by configurations.creating
val modulesJar by configurations.creating

plugins {
    kotlin("jvm")
}

group = rootProject.group
version = rootProject.version

repositories {
    mavenLocal()
}

dependencies {
    modulesJar(project(":order-impl")) { isTransitive = false }

    executableStoreJar("tech.cmodule.store:store-app:$storeAppVersion") { isTransitive = false }
    modulesJar("tech.cmodule.store:payment-api:$paymentVersion") { isTransitive = false }
}

val tb = tasks.getByName("build")

val cp = tasks.register<Copy>("copyDependenceJar") {
    from(modulesJar)
    into("./build/libs/modules")
}

tasks.register<JavaExec>("launch") {
    dependsOn(tb)
    dependsOn(cp)

    group = "execution"
    val mainJar = files(executableStoreJar.files.filter { it.name.contains("store") })
    val moduleJar = files("./build/libs/modules")
    val args = mutableListOf(
        "-Dloader.path=${moduleJar.asPath}"
    )
    classpath = mainJar
    mainClass = "org.springframework.boot.loader.launch.PropertiesLauncher"
    jvmArgs = args

}

