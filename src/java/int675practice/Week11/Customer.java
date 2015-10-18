/* 
 * To change this license header, choose License Headers in Project Properties. 
 * To change this template file, choose Tools | Templates 
 * and open the template in the editor. 
 */
package int675practice.Week11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Meme
 */
public class Customer {

    private static final String SQL_FIND_BY_ID = "select * from customer where customer_id = ?";
    private static final String SQL_FIND_BY_NAME = "select * from customer where name like ?";

    private int customerId;
    private String name;
    private String email;
    private int creditLimit;

    public static Customer findById(int id) {
        Customer c = null;
        Connection conn = ConnectionBuilder.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement(SQL_FIND_BY_ID);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                c = new Customer();
                getCustomer(rs, c);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return c;
    }

    public static List<Customer> findByName(String str) {
        List<Customer> customers = null;
        Connection conn = ConnectionBuilder.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement(SQL_FIND_BY_NAME);
            pstm.setString(1, str + "%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                if (customers == null) {
                    customers = new ArrayList<Customer>();
                }
                Customer tmp = new Customer();
                getCustomer(rs, tmp);
                customers.add(tmp);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return customers;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    private static void getCustomer(ResultSet rs, Customer c) throws SQLException {
        c.setCustomerId(rs.getInt("customer_id"));
        c.setCreditLimit(rs.getInt("credit_limit"));
        c.setEmail(rs.getString("email"));
        c.setName(rs.getString("name"));
    }

}
