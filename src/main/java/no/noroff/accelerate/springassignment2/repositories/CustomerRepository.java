package no.noroff.accelerate.springassignment2.repositories;

import no.noroff.accelerate.springassignment2.models.Customer;

import java.sql.ResultSet;
import java.util.List;

public interface CustomerRepository extends CRUDRepository{


    Customer findByName(String firstName);

    List<Customer> findLimitOffset(int limit, int offset);

    int insert(Customer customer);

    ResultSet update(Customer customer);
}
