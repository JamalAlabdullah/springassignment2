package no.noroff.accelerate.springassignment2.repositories;

import java.sql.ResultSet;
import java.util.List;

public interface CRUDRepository<T, U> {
    List<T> findAll();
    T findById(U id);
    T insert(U object);
    ResultSet update(T object);
    int delete(T object);
    ResultSet countryMostCustomer(T object);
    int deleteById(U id);
}