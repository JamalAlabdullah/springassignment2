package no.noroff.accelerate.springassignment2.repositories;

import no.noroff.accelerate.springassignment2.models.Customer;

public interface CustomerRepository extends CRUDRepository{
    int insert(Customer customer);
}
