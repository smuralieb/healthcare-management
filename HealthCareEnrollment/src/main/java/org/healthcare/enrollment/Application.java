package org.healthcare.enrollment;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "classpath:healthcare_enrollment.properties")
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception
    {
        log.info("Starting the Enrollment application!");
        SpringApplication.run(Application.class, args);
        log.info("Enrollment application started successfully!");
    }
}
