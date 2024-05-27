package org.example;

import org.example.Entity.*;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;



public class IHM {
    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("Computer_JPA");
    EntityManager em = emf.createEntityManager();

    Scanner sc = new Scanner(System.in);

    DeviceIHM deviceIHM = new DeviceIHM();


    public void start (){
        while (true){
            System.out.println("Menu : ");
            System.out.println("1/ cree");
            System.out.println("2/ afficher tout");
            System.out.println("3/ afficher par id");
            System.out.println("4/ supprimer");
            System.out.println("5/ editer");
            System.out.println("6/ create os");
            System.out.println("7/ create processor");
            System.out.println("8/ Show OS");
            System.out.println("9/ create device");
            System.out.println("10/ afficher tous les périphériques");
            System.out.println("11/ afficher par id un périphérique");
            System.out.println("12/ supprimer un périphérique");
            System.out.println("13/ modifier un périphérique");
            System.out.println("14/ afficher les périphériques d'un ordinateur");
            System.out.println("15/ afficher tous les ordinateurs associés aux périphériques");
            int entry = sc.nextInt();
            sc.nextLine();
            switch (entry){
                case 1:
                    createComputer();
                    break;
                case 2:
                    getAllComputer();
                    break;
                case 3:
                    getComputerById();
                    break;
                case 4:
                    deleteComputer();
                    break;
                case 5:
                    editComputer();
                    break;
                case 6:
                    createOperatingSystem();
                    break;
                case 7:
                    createProcessor();
                    break;
                case 8:
                    showInfo();
                    break;
                case 9:
                    createOperatingSystem();
                    break;
                case 10:
                    createProcessor();
                    break;
                case 11:
                    createDevice();
                    break;
                case 12:
                    getAllDevices();
                    break;
                case 13:
                    getDeviceById();
                    break;
                case 14:
                    deleteDevice();
                    break;
                case 15:
                    editDevice();
                    break;
                case 16:
                    displayDevicesOfComputer();;
                    break;
                case 17:
                    displayComputersOfDevice();
                    break;
                default:
                    return;
            }
        }

    }

    private void createDevice() {
        System.out.println("Device Name:");
        String name = sc.nextLine();
        System.out.println("Device Description:");
        String description = sc.nextLine();
        Device device = Device.builder().name(name).description(description).build();
        DeviceIHM.createDevice(device);
    }

    private void editDevice() {
        Device device = getDeviceById();
        if (device != null) {
            System.out.println("Enter new name:");
            String newName = sc.nextLine();
            System.out.println("Enter new description:");
            String newType = sc.nextLine();

            device.setName(newName);
            device.setDescription(newType);

            DeviceIHM.editDevice(device);
        }
    }

    private void deleteDevice() {
        System.out.println("ID DEVICE to delete:");
        int id = sc.nextInt();
        sc.nextLine();
        DeviceIHM.deleteDevice();
    }

    private Device getDeviceById() {
        System.out.println("Device id:");
        int id = sc.nextInt();
        sc.nextLine();
        Device device = getDeviceById();
        if (device != null) {
            System.out.println(device);
        } else {
            System.out.println("device not found");
        }
        return device;
    }

    private void getAllDevices() {
        List<Device> devices = DeviceIHM.getAllDevices();
        for (Device device : devices) {
            System.out.println(device);
        }
    }
    private void displayDevicesOfComputer() {
        Computer computer = getComputerById();
        if (computer != null) {
            for (Device device : computer.getDevices()) {
                System.out.println(device);
            }
        }
    }

    private void displayComputersOfDevice() {
        Device device = getDeviceById();
        if (device != null) {
            for (Computer computer : device.getComputers()) {
                System.out.println(computer);
            }
        }
    }

    private void createComputer (){

        Identifiant identifiant = Identifiant.builder().macAddress("Mon adresse imac").ipAddress("mon adress ip").build();
        Processor processor = em.find(Processor.class,1);
        OperatingSystem operatingSystem = em.find(OperatingSystem.class,1);
        Computer computer = Computer.builder().name("MyComputer").price(1200.50f).identifiant(identifiant).processor(processor).operatingSystem(operatingSystem).build();


        em.getTransaction().begin();
        em.persist(computer);
        em.getTransaction().commit();
    }

    private void getAllComputer (){
        Query query = em.createQuery("select c from Computer c");
        List computerList = query.getResultList();

        for (Object computer : computerList){
            System.out.println(computer);
        }
    }

    private void createOperatingSystem (){
        OperatingSystem operatingSystem = OperatingSystem.builder().name("Windows").Version("10.12").build();
        em.getTransaction().begin();
        em.persist(operatingSystem);
        em.getTransaction().commit();
    }

    private void createProcessor (){
        Processor processor = Processor.builder().heart(5).thread(8000).generation(7).build();
        em.getTransaction().begin();
        em.persist(processor);
        em.getTransaction().commit();
    }


    private Computer getComputerById (){
        System.out.println("id computer :");
        int id = sc.nextInt();
        sc.nextLine();

        Computer computer = em.find(Computer.class,id);
        if(computer != null){
            System.out.println(computer);
        }else {
            System.out.println("Computer not found");
        }
        return computer;
    }

    private void deleteComputer (){
        Computer computer = getComputerById();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        if(computer != null){
            em.remove(computer);
        }
        transaction.commit();
    }

    private void editComputer (){
        Computer computer = getComputerById();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        if(computer != null){
            computer.setName("myComputer2");
            computer.setPrice(1000.99f);
        }
        transaction.commit();
    }

    private void showInfo (){
        OperatingSystem os = em.find(OperatingSystem.class,1);
        System.out.println( "OperatingSystem found : "+os);
    }
}






