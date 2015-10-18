/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int675practice.Week11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;
import org.apache.derby.jdbc.ClientXADataSource;

/**
 *
 * @author Student Lab
 */
public class ConnectionBuilder {

    private static boolean load = false;
    public final static String URL = "jdbc:derby://localhost:1527/sample";
    public final static String DRIVER = "org.apache.derby.jdbc.ClientDriver";
    public final static String USER_NAME = "app";
    public final static String PASSWORD = "app";

    public static Connection getConnectionOriginal() {
        Connection conn = null;
        try {
            if (!load) {
                Class.forName(DRIVER);
                load = true;
            }
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            Statement stm = conn.createStatement();
            conn.setAutoCommit(false);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return conn;
    }

    public static Connection getConnectionServer() {
        Connection conn = null;

        return conn;
    }

    private static org.apache.derby.jdbc.ClientDataSource ds = null;
/*
    public static Connection getConnection() {
        Connection conn = null;
        try {
            if (ds == null) {
                Properties props = new Properties();
                FileInputStream fis = null;

                fis = new FileInputStream("db.properties");
                props.load(fis);

                ds = new org.apache.derby.jdbc.ClientDataSource();

                ds.setServerName(props.getProperty("DERBY_SERVER_NAME"));
                ds.setPortNumber(Integer.parseInt(props.getProperty("DERBY_SERVER_PORT")));
                ds.setDatabaseName(props.getProperty("DERBY_DB_NAME"));
                ds.setUser(props.getProperty("DERBY_DB_USERNAME"));
                ds.setPassword(props.getProperty("DERBY_DB_PASSWORD"));

            }
            conn = ds.getConnection();
        } catch (FileNotFoundException ex) {
        } catch (SQLException ex) {
        } catch (IOException ex) {
        }
        return conn;
    }
    */
    public static Connection getConnection() { 
        Connection conn = null; 
        try { 
            Context ctx = null; 
            ctx = new InitialContext(); 
            DataSource ds = (DataSource)ctx.lookup("jdbc/sample"); 
            conn = ds.getConnection(); 
        } catch (NamingException ex) { 
        } catch (SQLException ex) { 
        } 
        return conn; 
    }

}
