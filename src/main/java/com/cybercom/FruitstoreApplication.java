package com.cybercom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.cybercom.config.MqttConfig;

@SpringBootApplication
@EnableConfigurationProperties(MqttConfig.class)
public class FruitstoreApplication {

    public static void main(String... args) {
	SpringApplication.run(FruitstoreApplication.class, args);
    }

}
