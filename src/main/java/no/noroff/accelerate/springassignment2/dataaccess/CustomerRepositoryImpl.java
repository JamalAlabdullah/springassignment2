package no.noroff.accelerate.springassignment2.dataaccess;

import no.noroff.accelerate.springassignment2.models.Customer;
import no.noroff.accelerate.springassignment2.repositories.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class  CustomerRepositoryImpl implements CustomerRepository {

    private String url = "jdbc:postgresql://localhost:5432/chinook";
    private String username = "postgres";
    private String password = "454107";

    @Override
    public List<Customer> findAll() {
        String sql = "SELECT * FROM customer";
        List<Customer> customers = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            // Execute statement
            ResultSet result = statement.executeQuery();
            // Handle result
            while(result.next()) {
                Customer customer = new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("country"),
                        result.getString("postal_code"),
                        result.getString("phone"),
                        result.getString("email")
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Object findById(Object id) {
        return null;
    }

    @Override
    public Object insert(Object object) {
        return null;
    }

    @Override
    public ResultSet update(Object object) {
        return null;
    }

    @Override

    public int insert(Customer customer) {
        String sql = "INSERT INTO customer(customer_id,first_name,last_name,country,postal_code,phone,email) VALUES (?,?,?,?,?,?,?)";
        int result = 0;
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, customer.id());
            statement.setString(2,customer.firstName());
            statement.setString(3, customer.lastName());
            statement.setString(4, customer.country());
            statement.setString(5, customer.postalCode());
            statement.setString(6, customer.phoneNumber());
            statement.setString(7, customer.email());
            // Execute statement
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public ResultSet update(Customer customer) {
        String sql = "UPDATE Customer SET last_name='JamalJamal' WHERE customer_id=60";
        ResultSet result = null;
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            // Execute statement
            result = statement.executeQuery();
            //return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(Object object) {
        return 0;
    }

    @Override
    public int deleteById(Object id) {
        return 0;
    }
}
