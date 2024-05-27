package org.example;

import org.example.Entity.Device;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DeviceIHM {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Computer_JPA");
        private static EntityManager em = emf.createEntityManager();

        public static void createDevice(Device device) {
            em.getTransaction().begin();
            em.persist(device);
            em.getTransaction().commit();
        }

    public static List<Device> getAllDevices() {
    }

    public static Device getDeviceById(int id) {
            return em.find(Device.class, id);
        }

        public List<Device> getAllPeripherals() {
            return em.createQuery("SELECT d FROM Device d", Device.class).getResultList();
        }

        public static void editDevice(Device device) {
            em.getTransaction().begin();
            em.merge(device);
            em.getTransaction().commit();
        }

        public static void deleteDevice() {
            Device device = getDeviceById();
            if (device != null) {
                em.getTransaction().begin();
                em.remove(device);
                em.getTransaction().commit();
            }
        }
}



