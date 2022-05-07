package fr.hiapoe.eccmserver.eccmserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EccmServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EccmServerApplication.class, args);
    }

}
