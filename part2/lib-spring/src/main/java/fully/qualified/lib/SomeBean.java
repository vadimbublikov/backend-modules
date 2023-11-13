package fully.qualified.lib;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component //org.springframework:spring-context
public class SomeBean {

    @PostConstruct //jakarta.annotation:jakarta.annotation-api
    void init() {
        System.out.println("Bean");
    }

}
