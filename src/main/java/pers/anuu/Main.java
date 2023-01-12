package pers.anuu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author ${USER}
 * @title: ${NAME}
 * @projectName ${PROJECT_NAME}
 * @description: TODO
 * @date ${DATE}${TIME}
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableAutoConfiguration
@MapperScan({"pers.anuu.**.mapper"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}