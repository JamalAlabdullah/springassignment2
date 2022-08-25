package no.noroff.accelerate.springassignment2.repositories;

import no.noroff.accelerate.springassignment2.models.Customer;
import no.noroff.accelerate.springassignment2.models.CustomerCountry;
import no.noroff.accelerate.springassignment2.models.CustomerGenre;
import no.noroff.accelerate.springassignment2.models.CustomerSpender;

import java.sql.ResultSet;
import java.util.List;

public interface CustomerRepository extends CRUDRepository{

    /*
    Returns customer with same firstname as parameter
     */
    Customer findByName(String firstName);

    /*
    Returns list of customer which starts at row offset, and i limit long
     */
    List<Customer> findLimitOffset(int limit, int offset);

    /*
    Inserts given customer into database
     */
    int insert(Customer customer);

    /*
    Returns name of country with the most customers
     */
    CustomerCountry countryMostCustomer();

    /*
    Returns the customer which has spent the most
     */
    CustomerSpender totalSpender();

    /*
    Returns the most popular genre(s) for given customer
     */
    CustomerGenre mostPopularGenre(int id);
}
