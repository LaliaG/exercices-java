package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Créer une instance du service de notification par email
        EmailService emailService = new EmailService();

        // Créer une instance de l'adaptateur en lui passant le service de notification par email
        NotificationAdapter notificationAdapter = new NotificationAdapter(emailService);

        // Utiliser l'adaptateur pour envoyer une notification SMS
        notificationAdapter.sendSms("123456789", "Hello from SMS (sent via Email)");
    }
}