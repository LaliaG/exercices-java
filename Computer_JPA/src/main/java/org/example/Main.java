package org.example;

import org.example.Entity.Computer;
import org.example.Entity.Device;

import javax.persistence.*;
import javax.transaction.Transaction;
import java.util.List;
import java.util.Scanner;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        IHM ihm = new IHM();
        ihm.start();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Computer_JPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        //        Serre serre = Serre.builder().surface(50).plantes(new ArrayList<>()).build();
//        serre.add(em.find(Plante.class,2));
//        serre.add(em.find(Plante.class,3));
//        serre.add(em.find(Plante.class,4));

//        em.persist(serre);

        Device device = em.find(Device.class,1);
        System.out.println("Mon périphérique : "+ device.getComputers().toString());

        Computer computer = em.find(Computer.class,3);
        System.out.println("Mon ordinateur : "+ computer.getDevices().toString());

        em.getTransaction().commit();
    }
}