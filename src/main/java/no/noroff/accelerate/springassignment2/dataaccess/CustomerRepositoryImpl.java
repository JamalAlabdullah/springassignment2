package no.noroff.accelerate.springassignment2.dataaccess;

import no.noroff.accelerate.springassignment2.models.Customer;
import no.noroff.accelerate.springassignment2.repositories.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private String url = "jdbc:postgresql://localhost:5432/chinook";
    private String username = "postgres";
    private String password = "postgres";

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
    public int insert(Object object) {
        return 0;
    }

    @Override
    public int update(Object object) {
        return 0;
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
