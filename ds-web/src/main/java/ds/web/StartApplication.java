package ds.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "ds.dataservice")
@EntityScan(basePackages = "ds.model")
@ComponentScan(basePackages = { "ds.*" })
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class);
    }
}
