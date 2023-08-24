package kr.kro.stamfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StamfoodApplication {

    public static void main(String[] args) {
        SpringApplication.run(StamfoodApplication.class, args);
    }

}
