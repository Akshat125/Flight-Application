package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import utils.user.User;
import utils.user.UserRepository;

@SpringBootApplication()
@EnableJpaRepositories(value = {"apis", "controller", "main", "utils"})
@EntityScan(value = {"apis", "controller", "exceptions", "main", "utils"})
@ComponentScan(basePackages = {"apis", "controller", "main", "utils"})

public class SpringbootApplication {

    private static ConfigurableApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext = SpringApplication.run(SpringbootApplication.class, args);
    }

    public static ConfigurableApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
