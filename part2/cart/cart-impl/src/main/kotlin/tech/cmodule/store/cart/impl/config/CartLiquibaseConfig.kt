package tech.cmodule.store.cart.impl.config

import liquibase.integration.spring.SpringLiquibase
import org.springframework.beans.factory.ObjectProvider
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class CartLiquibaseConfig {

    @Bean
    fun cartLiquibase(
        dataSource: ObjectProvider<DataSource>,
        properties: LiquibaseProperties
    ): SpringLiquibase {
        val liquibase = SpringLiquibase()
        liquibase.dataSource = dataSource.ifAvailable
        liquibase.changeLog = "classpath:db/changelog-cart.xml"
        liquibase.isClearCheckSums = properties.isClearChecksums
        liquibase.contexts = properties.contexts
        liquibase.liquibaseSchema = properties.liquibaseSchema
        liquibase.liquibaseTablespace = properties.liquibaseTablespace
        liquibase.databaseChangeLogTable = properties.databaseChangeLogTable
        liquibase.databaseChangeLogLockTable = properties.databaseChangeLogLockTable
        liquibase.isDropFirst = properties.isDropFirst
        liquibase.setShouldRun(properties.isEnabled)
        liquibase.setRollbackFile(properties.rollbackFile)

        return liquibase
    }

}