package com.courses.hibernateandjpa.config;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import  org.flywaydb.core.Flyway ;
public class FlyWayConfig  implements FlywayMigrationStrategy {


    @Override
    public void migrate(Flyway flyway) {
        flyway.clean() ;
    }
}
