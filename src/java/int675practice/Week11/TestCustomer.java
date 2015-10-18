/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int675practice.Week11;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Student Lab
 */
public class TestCustomer {

    public static void main(String[] args) {
        findById();
        //findByName();
    }

    public static void findById() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Search Customer ID: (0 to stop)");
        int choice = sc.nextInt();
        while (choice > 0) {
            Customer c = Customer.findById(choice);
            if (c == null) {
                System.out.println("Customer ID " + choice + "does not exist... Try again!!");
            } else {
                System.out.println("ID: " + c.getCustomerId() + ",Name: " + c.getName() + ",Email: "
                        + c.getEmail() + ",Credit limit: " + c.getCreditLimit());

            }
            System.out.println("Search Customer ID: (0 to stop)");
            choice = sc.nextInt();
        }
    }

    public static void findByName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Search Customer Name: (enter 'stop' to stop)");
        String choice = sc.next();
        while (!choice.equalsIgnoreCase("stop")) {
            List<Customer> cs = Customer.findByName(choice);
            if (cs == null) {
                System.out.println("Customer Name " + choice + " does not exist... Try again!!");
            } else {
                for (Customer c : cs) {
                    System.out.println("ID: " + c.getCustomerId() + ",Name: " + c.getName() + ",Email: "
                            + c.getEmail() + ",Credit limit: " + c.getCreditLimit());
                }

            }
            System.out.println("Search Customer Name: (enter 'stop' to stop)");
            choice = sc.next();
        }
    }
}
