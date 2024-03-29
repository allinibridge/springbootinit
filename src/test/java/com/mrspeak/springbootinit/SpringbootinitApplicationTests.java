package com.mrspeak.springbootinit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootinitApplicationTests {

    Logger logger = LoggerFactory.getLogger(SpringbootinitApplication.class);

    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() {
        System.out.println(0.06+0.01);
        System.out.println(1.0-0.42);
        System.out.println(4.015*100);
        System.out.println(303.1/1000);
        BigDecimal bigDecimal = new BigDecimal(Double.toString(0.48));
        logger.info(String.valueOf(0.06+0.01));
        logger.warn("你好呀！！");

    }

    @Test
    public void jdbcTest(){
        System.out.println(dataSource.getClass());
        try (Connection connection = dataSource.getConnection()) {
            System.out.println(connection);
        }catch (Exception e){
            logger.info(e.getMessage());
        }
    }

}
