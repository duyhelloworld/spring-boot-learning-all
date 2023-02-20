package com.duyhelloworld.amigoscode;

import org.springframework.jdbc.core.JdbcTemplate;

import com.duyhelloworld.amigoscode.config.SpringJdbcConfig;

public abstract class Jdbc {
    private Jdbc(){};

    public static JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(new SpringJdbcConfig().mysqlDS());
    }
}
