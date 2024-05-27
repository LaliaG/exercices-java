package org.example.Controller;

import org.example.Entity.Customer;
import org.example.Entity.Address;
import org.example.Repository.CustomerRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class CustomerIhm {
    private static CustomerRepository customerRepository;
    private static Scanner sc;

    public CustomerIhm(EntityManager em, Scanner scanner) {
        sc = scanner;
        customerRepository = new CustomerRepository(em);
    }

    public void start() {
        int entry;

        while (true) {
            System.out.println("--- Customer Management ---");
            System.out.println("1/ Create Customer");
            System.out.println("2/ Edit Customer");
            System.out.println("3/ Delete Customer");
            System.out.println("4/ Find Customer by ID");
            System.out.println("5/ List All Customers");
            entry = sc.nextInt();
            sc.nextLine();
            switch (entry) {
                case 1:
                    add();
                    break;
                case 2:
                    edit();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    showById();
                    break;
                case 5:
                    showAll();
                    break;
                default:
                    return;
            }
        }
    }

    private void add() {
        System.out.println("-- Create Customer --");
        System.out.println("Customer firstname:");
        String firstname = sc.nextLine();
        System.out.println("Customer lastname:");
        String lastname = sc.nextLine();
        System.out.println("Customer age:");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Customer phone:");
        String phone = sc.nextLine();

        System.out.println("Address details");
        System.out.println("Street:");
        String street = sc.nextLine();
        System.out.println("City:");
        String city = sc.nextLine();

        Address address = Address.builder().street(street).city(city).build();

        Customer customer = Customer.builder()
                .firstname(firstname)
                .lastname(lastname)
                .age(age)
                .phone(phone)
                .address(address)
                .build();

        customerRepository.save(customer);
    }

    private void edit() {
        Customer customer = findById();
        if (customer == null) return;

        System.out.println("-- Edit Customer --");
        System.out.println("New firstname (current: " + customer.getFirstname() + "):");
        customer.setFirstname(sc.nextLine());
        System.out.println("New lastname (current: " + customer.getLastname() + "):");
        customer.setLastname(sc.nextLine());
        System.out.println("New age (current: " + customer.getAge() + "):");
        customer.setAge(sc.nextInt());
        sc.nextLine(); // consume newline
        System.out.println("New phone (current: " + customer.getPhone() + "):");
        customer.setPhone(sc.nextLine());

        System.out.println("Address details");
        System.out.println("New street (current: " + customer.getAddress().getStreet() + "):");
        customer.getAddress().setStreet(sc.nextLine());
        System.out.println("New city (current: " + customer.getAddress().getCity() + "):");
        customer.getAddress().setCity(sc.nextLine());

        customerRepository.save(customer);
    }

    private void delete() {
        System.out.println("-- Delete Customer --");
        Customer customer = findById();
        if (customer != null) {
            customerRepository.delete(customer);
        } else {
            System.out.println("Customer not found");
        }
    }

    private Customer findById() {
        System.out.println("Customer ID:");
        int id = sc.nextInt();
        sc.nextLine();
        return customerRepository.findById(id);
    }

    private void showById() {
        System.out.println("-- Show Customer by ID --");
        Customer customer = findById();
        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("Customer not found");
        }
    }

    private void showAll() {
        System.out.println("-- Show All Customers --");
        List<Customer> customers = customerRepository.findALl();
        if (customers != null && !customers.isEmpty()) {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        } else {
            System.out.println("No customers found");
        }
    }
}
