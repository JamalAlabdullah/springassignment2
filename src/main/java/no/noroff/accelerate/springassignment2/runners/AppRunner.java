package no.noroff.accelerate.springassignment2.runners;

import no.noroff.accelerate.springassignment2.dataaccess.CustomerRepositoryImpl;
import no.noroff.accelerate.springassignment2.repositories.CustomerRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {
    private final CustomerRepository customerRepository;

    public AppRunner(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        CustomerRepositoryImpl customerRepository= new CustomerRepositoryImpl();
        System.out.println( customerRepository.totalSpender());
        customerRepository.findAll();

    }
}
