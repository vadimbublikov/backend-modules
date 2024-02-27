package tech.pf4j.store.config

import org.pf4j.spring.SpringPluginManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Pf4jConfig {

    @Bean
    fun pluginManager(): SpringPluginManager {
        return SpringPluginManager()
    }

}