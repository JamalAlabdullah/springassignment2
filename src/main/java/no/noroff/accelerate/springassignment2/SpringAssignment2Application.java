package no.noroff.accelerate.springassignment2;
import no.noroff.accelerate.springassignment2.dataaccess.CustomerRepositoryImpl;
import no.noroff.accelerate.springassignment2.models.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAssignment2Application {

    public static void main(String[] args) {

        SpringApplication.run(SpringAssignment2Application.class, args);

      // System.out.println(new CustomerRepositoryImpl().findAll());
        /*
        CustomerRepositoryImpl customerRepository= new CustomerRepositoryImpl();
      customerRepository.insert(new Customer(60,
            "Jamal","Alabdullah","Norway","1111","12345678","jamal@gmail.com"));
         */

        /*
        CustomerRepositoryImpl customerRepositoryUpdate= new CustomerRepositoryImpl();
        customerRepositoryUpdate.update(new Object());

         */

        CustomerRepositoryImpl CountryMost= new CustomerRepositoryImpl();


        System.out.println(CountryMost.countryMostCustomer());






    }

}
