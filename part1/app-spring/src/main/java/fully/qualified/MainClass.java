package fully.qualified;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainClass {

    @PostConstruct
    public static void main(String[] args) {
        SpringApplication.run(MainClass.class, args);
    }

}
