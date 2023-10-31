package com.purexua;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.purexua.mapper")
@SpringBootApplication
public class OnlineBookstoreManagementBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(OnlineBookstoreManagementBackendApplication.class, args);
  }

}
