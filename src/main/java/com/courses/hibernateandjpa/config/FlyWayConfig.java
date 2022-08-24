package com.courses.hibernateandjpa.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import  org.flywaydb.core.Flyway ;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Slf4j
@Configuration
public class FlyWayConfig {
    @Bean
    public FlywayMigrationStrategy migrateStrategy() {
        return (flyway) -> {
            log.info("cleaning db");
            flyway.clean() ;
            log.info("ignore flyway migration");
            flyway.migrate() ;
        } ;
    }
}
