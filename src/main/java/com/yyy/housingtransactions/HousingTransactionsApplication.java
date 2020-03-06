package com.yyy.housingtransactions;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.yyy.housingtransactions.dao")
@SpringBootApplication
public class HousingTransactionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HousingTransactionsApplication.class, args);
    }

}
