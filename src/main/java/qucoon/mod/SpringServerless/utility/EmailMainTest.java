package qucoon.mod.SpringServerless.utility;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import qucoon.mod.SpringServerless.service.EmailService;

import java.util.Properties;

public class EmailMainTest {
    public static void main(String[] args) {
        // Configure JavaMailSenderImpl with Gmail SMTP settings
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("authvalidationtest@gmail.com");
        mailSender.setPassword("siqyaybbrfmcbigd");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");


        // Instantiate your EmailService
        EmailService emailService = new EmailService(mailSender);

        // Send test email
        emailService.sendSimpleEmail(
            "topeolaks@gmail.com",
            "Test Email",
            "Hello! This email test"
        );

        System.out.println("Email sent");
    }
}
