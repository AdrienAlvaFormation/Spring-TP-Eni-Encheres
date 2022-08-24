package fr.eni.springtpeniencheres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//TODO enlever quand impl de la security
@SpringBootApplication//(exclude = SecurityAutoConfiguration.class)//  (exclude = SecurityAutoConfiguration.class) => desactive Spring security
public class SpringTpEniEncheresApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTpEniEncheresApplication.class, args);
    }

}
