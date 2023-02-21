package com.duyhelloworld.jdbctemplate.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
// import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
// import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@ComponentScan(basePackages = "com.duyhelloworld.amigoscode.config")
public class SpringJdbcConfig {
    @Bean
    protected DataSource mysqlDS() {
        Properties user = new Properties();
        user.setProperty("username", "duyaiti");
        user.setProperty("password", "12345678");
        String url = "jdbc:mysql://localhost:3306/QuanLiSinhVien";
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url, user);
        return dataSource;
    }

    // @Bean
    // protected DataSource h2DS() {
    //     return new EmbeddedDatabaseBuilder()
    //             .setType(EmbeddedDatabaseType.H2)
    //             .addScript("classpath:jdbc/schema.sql").setName("" + this.getClass().getSimpleName())
    //             .build();
    // }    
}
