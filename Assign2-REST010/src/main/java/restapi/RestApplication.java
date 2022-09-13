package restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ui.LoginPage;

import java.io.IOException;

@SpringBootApplication
@EntityScan("models")
@EnableJpaRepositories("repos")
public class RestApplication {

    public static void main(String[] args) throws IOException {
        LoginPage.displayLoginPage();

        SpringApplication.run(RestApplication.class, args);

    }


}