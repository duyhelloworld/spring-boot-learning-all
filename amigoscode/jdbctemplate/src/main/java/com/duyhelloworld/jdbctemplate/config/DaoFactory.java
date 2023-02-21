package com.duyhelloworld.jdbctemplate.config;

import org.springframework.jdbc.core.JdbcTemplate;

public class DaoFactory {
    private DaoFactory() {
    };
    
    public static JdbcTemplate getJdbcFactory(DataBaseType dataBaseType) {
        switch (dataBaseType) {
            case MYSQL:
                return new JdbcTemplate(new SpringJdbcConfig().mysqlDS());
            case H2DB:
                // return new JdbcTemplate(new SpringJdbcConfig().h2DS());
            case MSSQL:
                return null;
            default:
                throw new IllegalArgumentException("Not support this DB type.");
        }
    }


}
