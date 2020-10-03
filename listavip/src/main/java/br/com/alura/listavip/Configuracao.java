package br.com.alura.listavip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;

@SpringBootApplication
public class Configuracao {

    @RequestMapping("/")
    @ResponseBody
    String ola() {
        return "<h1>Ola! Bem vindo ao sistema de lista VIP!</h1>";
    }

    public static void main(String[] args) {
        SpringApplication.run(Configuracao.class, args);
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.driver");
        dataSource.setUrl("jdbc:mysql//localhost3306/bancodedestino");
        dataSource.setUsername("root");
        dataSource.setPassword("apartamento141");
        return dataSource;
    }
}
