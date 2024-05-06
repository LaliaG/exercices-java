package org.example;

public class NotificationAdapter implements SmsService{
    private EmailService emailService;

    public NotificationAdapter(EmailService emailService) {
        this.emailService = new EmailService();
    }

    @Override
    public void sendSms(String number, String message) {
        emailService.sendEmail(number, "Notification", message);
        String email = number + "@example.com";
        emailService.sendEmail(email, "SMS Notification", message);

    }
}
