package tech.modulith.store.config

import org.springframework.modulith.core.ApplicationModuleDetectionStrategy
import org.springframework.modulith.core.JavaPackage
import java.util.stream.Stream

class ModuleDetection : ApplicationModuleDetectionStrategy {
    override fun getModuleBasePackages(basePackage: JavaPackage): Stream<JavaPackage> {
        return basePackage.directSubPackages
            .filter { !it.name.endsWith(".config") }
            .stream()
    }
}