package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import utils.user.UserRepository;
@SpringBootApplication()
@EnableJpaRepositories(value = {"apis", "controller", "exceptions", "main", "utils"})
@EntityScan(value = {"apis", "controller", "exceptions", "main", "utils"})
@ComponentScan(basePackages = {"apis", "controller", "exceptions", "main", "utils"})


public class SpringbootApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SpringbootApplication.class, args);
        UserRepository userRepository = configurableApplicationContext.getBean(UserRepository.class);

        // These lines would add another admin to the database
        //User admin = new User("admin", "admin");
        //userRepository.save(admin);
    }
}
