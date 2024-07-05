package it.epicode.valhallagaming.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendConfirmationEmail(String userEmail, String adminName, String adminEmail){
        System.out.println("check");
        MimeMessage message = emailSender.createMimeMessage();
        System.out.println(message);
        System.out.println("check");
        MimeMessageHelper helper = new MimeMessageHelper(message);
        System.out.println("check");
        System.out.println(helper);
        try {
            System.out.println("check");
            helper.setTo(userEmail);
            System.out.println(userEmail + adminEmail + adminName);
            helper.setSubject("Valhalla Gaming - Conferma Prenotazione");
            String text = "Gentile Utente,\n"
                    + "La sua prenotazione è stata confermata da " + adminName + ".\n"
                    + "Grazie per aver scelto Valhalla Gaming! \n"
                    + "Se hai bisogno contatta " + adminEmail;
            helper.setText(text);
            System.out.println(text);
            emailSender.send(message);
            System.out.println("check");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendDeleteEmail(String userEmail) {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(userEmail);
            helper.setSubject("Valhalla Gaming - Conferma Prenotazione");
            String text = "Gentile Utente,\n"
                    + "siamo spiacenti ma la sua prenotazione è stata annullata. \n"
                    + "Riprovi a prenotare un altra postazione o un'altra data";
            helper.setText(text);
            emailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
