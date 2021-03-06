package com.asimkilic.account;


import com.asimkilic.account.model.Customer;
import com.asimkilic.account.repository.CustomerRepository;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.time.Clock;


@SpringBootApplication
public class AccountApplication implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public AccountApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }


    @Bean
    public OpenAPI customOpenAPI(@Value("${application-description}") String description, @Value("${application-version}") String version) {
        return new OpenAPI()
                .info(new Info()
                        .title("Account API")
                        .version(version)
                        .description(description)
                        .license(new License().name("Account API licence")));
    }

    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }


    public void run(String... args) {
        Customer customer = customerRepository.save(new Customer("Asım", "KILIÇ"));
        Customer customer2 = customerRepository.save(new Customer("Muratcan", "BABA"));
        Customer customer3 = customerRepository.save(new Customer("Enes", "ZEHİR"));
        Customer customer4 = customerRepository.save(new Customer("Mert", "PALACIOĞLU"));
        Customer customer5 = customerRepository.save(new Customer("Mert", "ÖZDEMİR"));
        System.out.println(customer);
        System.out.println(customer2);
        System.out.println(customer3);
        System.out.println(customer4);
        System.out.println(customer5);
    }
}
