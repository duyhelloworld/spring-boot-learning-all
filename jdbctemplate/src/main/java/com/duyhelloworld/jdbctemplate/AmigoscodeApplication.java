package com.duyhelloworld.jdbctemplate;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.duyhelloworld.jdbctemplate.config.DaoFactory;
import com.duyhelloworld.jdbctemplate.config.DataBaseType;

@SpringBootApplication
public class AmigoscodeApplication {
	public static void main(String[] args) throws SQLException {
		SpringApplication.run(AmigoscodeApplication.class, args);
		System.out.println(DaoFactory.getJdbcFactory(DataBaseType.MYSQL).getDataSource());
	}
}