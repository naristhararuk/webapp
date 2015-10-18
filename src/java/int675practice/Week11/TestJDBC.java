/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int675practice.Week11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Student Lab
 */
public class TestJDBC {

    final static String URL = "jdbc:derby://localhost:1527/sample";

    public static void main(String[] args) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection(URL, "app", "app");
            Statement stm = conn.createStatement();
            conn.setAutoCommit(false);
            /*stm.executeUpdate("Insert into product_code values('X1','N','Access')");
             stm.executeUpdate("Insert into product_code values('X2','N','Access')");
             stm.executeUpdate("Insert into product_code values('X3','N','Access')");
             stm.executeUpdate("Insert into product_code values('X4','N','Access')");*/
            //stm.executeUpdate("delete from product_code where description ='Access'");

            //conn.commit();
            System.out.println("id.....Description..........................................Cost....");
            String sqlCmd = "Select p.product_id,p.purchase_cost,p.description as product_name,"+
                    " pc.description as product_type from product p, product_code pc "+
                    "where p.product_code = pc.prod_code";
            ResultSet rs = stm.executeQuery(sqlCmd);
            while (rs.next()) {
                System.out.printf("%5d %-47s %12.2f %-47s \n",rs.getInt("product_id"), 
                        rs.getString("product_name"),rs.getDouble("purchase_cost"),rs.getString("product_type"));
            }
            
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i < rsmd.getColumnCount(); i++) {
                System.out.println("Column "+i+": "+rsmd.getColumnName(i)+", "
                        +rsmd.getColumnTypeName(i)+", Lable: "+rsmd.getColumnLabel(i));
            }
            conn.commit();
            conn.close();
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        } catch (SQLException ex) {
            System.err.println(ex);
        }

    }
}
