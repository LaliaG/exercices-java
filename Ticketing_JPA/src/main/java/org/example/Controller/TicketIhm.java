package org.example.Controller;

import org.example.Entity.Ticket;
import org.example.Entity.Customer;
import org.example.Entity.Event;
import org.example.TypeOfSeats;
import org.example.Repository.TicketRepository;
import org.example.Repository.CustomerRepository;
import org.example.Repository.EventRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class TicketIhm {
    private TicketRepository ticketRepository;
    private CustomerRepository customerRepository;
    private EventRepository eventRepository;
    private Scanner sc;

    public TicketIhm(EntityManager em, Scanner scanner) {
        sc = scanner;
        ticketRepository = new TicketRepository(em);
        customerRepository = new CustomerRepository(em);
        eventRepository = new EventRepository(em);
    }

    public void start() {
        int entry;

        while (true) {
            System.out.println("--- Ticket Management ---");
            System.out.println("1/ Create Ticket");
            System.out.println("2/ Edit Ticket");
            System.out.println("3/ Delete Ticket");
            System.out.println("4/ Find Ticket by ID");
            System.out.println("5/ List All Tickets");
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
        System.out.println("-- Create Ticket --");
        System.out.println("Number of tickets:");
        int nbTicket = sc.nextInt();
        sc.nextLine();
        System.out.println("Type of seats (REGULAR, VIP, etc.):");
        TypeOfSeats typeOfSeats = TypeOfSeats.valueOf(sc.nextLine().toUpperCase());

        System.out.println("Customer ID:");
        int customerId = sc.nextInt();
        sc.nextLine();
        Customer customer = customerRepository.findById(customerId);
        if (customer == null) {
            System.out.println("Customer not found");
            return;
        }

        System.out.println("Event ID:");
        int eventId = sc.nextInt();
        sc.nextLine();
        Event event = eventRepository.findById(eventId);
        if (event == null) {
            System.out.println("Event not found");
            return;
        }

        Ticket ticket = Ticket.builder()
                .nbTicket(nbTicket)
                .typeOfSeats(typeOfSeats)
                .customer(customer)
                .event(event)
                .build();

        ticketRepository.save(ticket);
    }

    private void edit() {
        Ticket ticket = findById();
        if (ticket == null) return;

        System.out.println("-- Edit Ticket --");
        System.out.println("New number of tickets (current: " + ticket.getNbTicket() + "):");
        ticket.setNbTicket(sc.nextInt());
        sc.nextLine(); // consume newline
        System.out.println("New type of seats (current: " + ticket.getTypeOfSeats() + "):");
        ticket.setTypeOfSeats(TypeOfSeats.valueOf(sc.nextLine().toUpperCase()));

        System.out.println("New customer ID (current: " + ticket.getCustomer().getIdCustomer() + "):");
        int customerId = sc.nextInt();
        sc.nextLine();
        Customer customer = customerRepository.findById(customerId);
        if (customer != null) {
            ticket.setCustomer(customer);
        }

        System.out.println("New event ID (current: " + ticket.getEvent().getIdEvent() + "):");
        int eventId = sc.nextInt();
        sc.nextLine();
        Event event = eventRepository.findById(eventId);
        if (event != null) {
            ticket.setEvent(event);
        }

        ticketRepository.save(ticket);
    }

    private void delete() {
        System.out.println("-- Delete Ticket --");
        Ticket ticket = findById();
        if (ticket != null) {
            ticketRepository.delete(ticket);
        } else {
            System.out.println("Ticket not found");
        }
    }

    private Ticket findById() {
        System.out.println("Ticket ID:");
        int id = sc.nextInt();
        sc.nextLine();
        return ticketRepository.findById(id);
    }

    private void showById() {
        System.out.println("-- Show Ticket by ID --");
        Ticket ticket = findById();
        if (ticket != null) {
            System.out.println(ticket);
        } else {
            System.out.println("Ticket not found");
        }
    }

    private void showAll() {
        System.out.println("-- Show All Tickets --");
        List<Ticket> tickets = ticketRepository.findALl();
        if (tickets != null && !tickets.isEmpty()) {
            for (Ticket ticket : tickets) {
                System.out.println(ticket);
            }
        } else {
            System.out.println("No tickets found");
        }
    }
}
