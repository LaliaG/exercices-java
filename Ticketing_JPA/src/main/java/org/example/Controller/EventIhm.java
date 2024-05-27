package org.example.Controller;

import org.example.Entity.Event;
import org.example.Entity.Location;
import org.example.Repository.EventRepository;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class EventIhm {
    private Scanner sc;
    private EventRepository eventRepository;

    public EventIhm(EntityManager em, Scanner scanner) {
        this.sc = scanner;
        this.eventRepository = new EventRepository(em);
    }

    public void start() {
        int entry;

        while (true) {
            System.out.println("--- Event Management ---");
            System.out.println("1/ Create Event");
            System.out.println("2/ Edit Event");
            System.out.println("3/ Delete Event");
            System.out.println("4/ Find Event by ID");
            System.out.println("5/ Find All Events");
            System.out.println("6/ Check Available Seats");
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
                case 6:
                    checkAvailableSeats();
                    break;
                default:
                    return;
            }
        }
    }

    private void add() {
        System.out.println("-- Create Event --");
        System.out.println("Event name:");
        String name = sc.nextLine();
        System.out.println("Event date (YYYY-MM-DD):");
        LocalDate date = LocalDate.parse(sc.nextLine());
        System.out.println("Event hour (HH:MM):");
        LocalTime hour = LocalTime.parse(sc.nextLine());
        System.out.println("Number of seats:");
        int nbOfSeats = sc.nextInt();
        sc.nextLine();

        System.out.println("Location details");
        System.out.println("Location street:");
        String street = sc.nextLine();
        System.out.println("Location city:");
        String city = sc.nextLine();
        System.out.println("Location capacity:");
        int capacity = sc.nextInt();
        sc.nextLine();

        Location location = Location.builder().street(street).city(city).capacity(capacity).build();

        Event event = Event.builder()
                .name(name)
                .date(date)
                .hour(hour)
                .nbOfSeats(nbOfSeats)
                .location(location)
                .build();

        eventRepository.save(event);
    }

    private void edit() {
        Event event = findById();
        if (event == null) return;

        System.out.println("-- Edit Event --");
        System.out.println("Event name: (current: " + event.getName() + ")");
        event.setName(sc.nextLine());
        System.out.println("Event date (YYYY-MM-DD): (current: " + event.getDate() + ")");
        event.setDate(LocalDate.parse(sc.nextLine()));
        System.out.println("Event hour (HH:MM): (current: " + event.getHour() + ")");
        event.setHour(LocalTime.parse(sc.nextLine()));
        System.out.println("Number of seats: (current: " + event.getNbOfSeats() + ")");
        event.setNbOfSeats(sc.nextInt());
        sc.nextLine();

        System.out.println("Location details");
        System.out.println("Location street: (current: " + event.getLocation().getStreet() + ")");
        event.getLocation().setStreet(sc.nextLine());
        System.out.println("Location city: (current: " + event.getLocation().getCity() + ")");
        event.getLocation().setCity(sc.nextLine());
        System.out.println("Location capacity: (current: " + event.getLocation().getCapacity() + ")");
        event.getLocation().setCapacity(sc.nextInt());
        sc.nextLine();

        eventRepository.save(event);
    }

    private void delete() {
        System.out.println("-- Delete Event --");
        Event event = findById();
        if (event != null) {
            eventRepository.delete(event);
        } else {
            System.out.println("Event not found");
        }
    }

    private Event findById() {
        System.out.println("Event ID:");
        int id = sc.nextInt();
        sc.nextLine();
        return eventRepository.findById(id);
    }

    private void showById() {
        System.out.println("-- Show Event by ID --");
        Event event = findById();
        if (event != null) {
            System.out.println(event);
        } else {
            System.out.println("Event not found");
        }
    }

    private void showAll() {
        System.out.println("-- Show All Events --");
        List<Event> events = eventRepository.findALl();
        if (events != null && !events.isEmpty()) {
            for (Event event : events) {
                System.out.println(event);
            }
        } else {
            System.out.println("No events found");
        }
    }

    private void checkAvailableSeats() {
        System.out.println("Event ID:");
        int idEvent = sc.nextInt();
        sc.nextLine();
        System.out.println("Number of tickets requested:");
        int ticketsRequested = sc.nextInt();
        sc.nextLine();

        if (checkAvailability(idEvent, ticketsRequested)) {
            System.out.println("Sufficient tickets available");
        } else {
            System.out.println("Not enough tickets available");
        }
    }

    public boolean checkAvailability(int idEvent, int ticketsRequested) {
        Event event = eventRepository.findById(idEvent);
        if (event == null) {
            System.out.println("Event not found");
            return false;
        }

        int bookedTickets = event.getTickets().stream().mapToInt(ticket -> ticket.getNbTicket()).sum();
        return (event.getNbOfSeats() - bookedTickets) >= ticketsRequested;
    }
}
