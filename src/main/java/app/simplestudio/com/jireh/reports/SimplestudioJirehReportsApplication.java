package app.simplestudio.com.jireh.reports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableEurekaClient
@EnableReactiveMongoRepositories
@SpringBootApplication
public class SimplestudioJirehReportsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimplestudioJirehReportsApplication.class, args);
    }

}
