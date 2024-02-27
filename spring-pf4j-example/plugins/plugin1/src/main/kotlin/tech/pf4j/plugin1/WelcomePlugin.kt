package tech.pf4j.plugin1

import org.pf4j.Plugin
import org.pf4j.PluginWrapper
import org.slf4j.LoggerFactory

class WelcomePlugin(wrapper: PluginWrapper): Plugin(wrapper) {

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun start() {
        log.info("WelcomePlugin.start()")
        log.info("WelcomePlugin")
    }

    override fun stop() {
        log.info("WelcomePlugin.stop()")
    }

}