package no.noroff.accelerate.springassignment2.repositories;

import no.noroff.accelerate.springassignment2.models.Customer;

import java.sql.ResultSet;

public interface CustomerRepository extends CRUDRepository{
    int insert(Customer customer);

    ResultSet update(Customer customer);
}
