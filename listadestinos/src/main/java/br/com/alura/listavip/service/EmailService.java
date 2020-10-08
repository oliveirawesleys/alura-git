package br.com.alura.listavip.service;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void enviar(String nome, String emailDestinatario) {
        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator("negromaravilh@gmail.com", "negrao10"));
            email.setSSLOnConnect(true);

            email.setFrom("negromaravilh@gmail.com");
            email.setSubject("Você foi convidada pelo Lista de Destinos!");
            email.setMsg("Olá " + nome + ", você acaba de ser convidada para a Lista de Destinos de seus sonhos!");
            email.addTo(emailDestinatario);
            email.send();
        } catch (EmailException ex) {
            ex.printStackTrace();
        }
    }
}