package at.codingmiracle.ticktacktoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "at.codingmiracle.ticktacktoe.repositories")
public class TicktacktoeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicktacktoeApplication.class, args);
    }

}
