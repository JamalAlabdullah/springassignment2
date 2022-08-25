package no.noroff.accelerate.springassignment2.runners;

import no.noroff.accelerate.springassignment2.dataaccess.CustomerRepositoryImpl;
import no.noroff.accelerate.springassignment2.models.Customer;
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
        customerRepository.countryMostCustomer();
        customerRepository.update(new Object());
        customerRepository.findById(3);
        customerRepository.findByName("Emma");
        customerRepository.findLimitOffset(4,1);
        customerRepository.insert(new Customer(60,"Jamal/Nathaniel","Abdullah/Maaskant",
                "Norway","1234","123456","asd@asdd"));




    }
}
