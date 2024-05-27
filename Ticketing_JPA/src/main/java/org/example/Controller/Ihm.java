package org.example.Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Ihm {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ticketing_JPA");
    private EntityManager em = emf.createEntityManager();
    private Scanner sc ;

    private CustomerIhm customerIhm;
    private EventIhm eventIhm;
    private TicketIhm ticketIhm;


    public Ihm() {
        sc = new Scanner(System.in);
        customerIhm = new CustomerIhm(em,sc);
        eventIhm = new EventIhm(em,sc);
        ticketIhm = new TicketIhm(em,sc);


    }

    public void start (){
        int entry ;
        while (true){
            System.out.println("--- Ticketing Application ---");
            System.out.println("1/ Customer");
            System.out.println("2/ Event");
            System.out.println("3/ Ticket");
            entry = sc.nextInt();
            sc.nextLine();

            switch (entry){
                case 1:
                    customerIhm.start();
                    break;
                case 2 :
                    eventIhm.start();
                    break;
                case 3:
                    ticketIhm.start();
                    break;
                default:
                    return;
            }
        }

    }
}
