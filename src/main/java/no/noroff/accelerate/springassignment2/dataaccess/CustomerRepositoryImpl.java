package no.noroff.accelerate.springassignment2.dataaccess;

import no.noroff.accelerate.springassignment2.models.Customer;
import no.noroff.accelerate.springassignment2.models.CustomerCountry;
import no.noroff.accelerate.springassignment2.models.CustomerGenre;
import no.noroff.accelerate.springassignment2.models.CustomerSpender;
import no.noroff.accelerate.springassignment2.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class  CustomerRepositoryImpl implements CustomerRepository {

    @Value("${spring.datasource.url}")
    private String url = "jdbc:postgresql://localhost:5432/chinook";
    @Value("${spring.datasource.username}")
    private String username = "postgres";
    @Value("${spring.datasource.password}")
    private String password = "postgres";

    public CustomerRepositoryImpl(){
    }

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
    public Customer findByName(String firstName) {
        String sql = "SELECT * FROM customer WHERE first_name LIKE '"+firstName+"%'";
        Customer customer = null;
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            // Execute statement
            ResultSet result = statement.executeQuery();
            // Handle result
            result.next();
            customer = new Customer(
                    result.getInt("customer_id"),
                    result.getString("first_name"),
                    result.getString("last_name"),
                    result.getString("country"),
                    result.getString("postal_code"),
                    result.getString("phone"),
                    result.getString("email")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> findLimitOffset(int limit, int offset) {
        String sql = "SELECT * FROM customer LIMIT "+limit+" OFFSET "+offset;
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

    public CustomerCountry countryMostCustomer() {
       String sql = "SELECT country FROM   customer WHERE  country IS NOT DISTINCT FROM (SELECT MAX(country) FROM customer)";
        CustomerCountry customerCountry = null;
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            // Execute statement
            ResultSet result = statement.executeQuery();
            result.next();
            customerCountry = new CustomerCountry(result.getString("Country"));
            //return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerCountry;

    }


    public CustomerSpender totalSpender(){
        String sql = "SELECT customer.customer_id, customer.first_name, invoice.total AS total_spender FROM customer \n" +
                "LEFT OUTER JOIN invoice ON customer.customer_id= invoice.customer_id \n" +
                "AND invoice.total = (SELECT MAX(total) FROM invoice\n" +
                "WHERE customer.customer_id= invoice.customer_id)\n" +
                "ORDER BY invoice.total DESC";
        CustomerSpender customerSpender = null;
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            // Execute statement
            ResultSet result = statement.executeQuery();
            result.next();
            customerSpender = new CustomerSpender(result.getInt("customer_id"),result.getString("first_name"), result.getDouble("total_spender"));
            //return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerSpender;
    }

    @Override
    public CustomerGenre mostPopularGenre(int id){
        String sql = "SELECT invoice.invoice_id, invoice.customer_id,genre.name,\n" +
                "((SELECT COUNT(genre.name) AS most_genr FROM genre)),\n" +
                "((SELECT MAX(track.name) AS track_name FROM track)),\n" +
                "invoice.invoice_id, invoice.total\n" +
                "FROM invoice_line,genre,track,invoice\n" +
                "WHERE invoice.customer_id= "+id+"\n" +
                "AND genre.genre_id= track.track_id\n" +
                "AND invoice_line.invoice_id= invoice.invoice_id\n" +
                "AND invoice_line.track_id= track.track_id\n" +
                "GROUP BY invoice.invoice_id, genre.name\n" +
                "ORDER BY COUNT(invoice.customer_id)DESC;";
        CustomerGenre customerGenre = null;
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            // Execute statement
            ResultSet result = statement.executeQuery();
            List<String> genreList = new ArrayList<String>();
            result.next();
            genreList.add(result.getString("name"));
            customerGenre = new CustomerGenre(result.getInt("customer_id"), genreList);
            while(result.next()) genreList.add(result.getString("name"));
            //return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerGenre;
    }



}
