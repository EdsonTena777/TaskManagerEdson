
package com.taskmanager.api.Configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource(){

        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setDriverClassName("oracle.jdbc.OracleDriver");

        ds.setUrl("jdbc:oracle:thin:@localhost:1521/orcl");

        ds.setUsername("TU_USUARIO");
        ds.setPassword("TU_CONTRASEÑA");

        return ds;
    }
}