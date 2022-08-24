package no.noroff.accelerate.springassignment2;

import no.noroff.accelerate.springassignment2.dataaccess.CustomerRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringAssignment2ApplicationTests {

    @Test
    void contextLoads() {
        CustomerRepositoryImpl customerRepository= new CustomerRepositoryImpl();

        System.out.println(customerRepository.countryMostCustomer(new Object()));
    }

}
