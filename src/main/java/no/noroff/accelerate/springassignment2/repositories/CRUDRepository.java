package no.noroff.accelerate.springassignment2.repositories;

import no.noroff.accelerate.springassignment2.models.Customer;

import java.sql.ResultSet;
import java.util.List;

public interface CRUDRepository<T, U> {

    /*
    Returns a list of all records of given type in database
     */
    List<T> findAll();
    /*
    Returns record of given type by ID
     */
    T findById(U id);

    /*
    Inserts given object into database
     */
    T insert(U object);

}