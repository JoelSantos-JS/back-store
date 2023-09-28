package com.joel.br.backstore.services;

import com.joel.br.backstore.utils.EmailUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    @Value("${spring.mail.verify.host}")
    private  String host;

    @Value("${spring.mail.username}")
    private  String fromEmail;


    private  final JavaMailSender javaMailSender;

    public void sendSimpleEmailMessage(String name, String to) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setSubject("Verificação de Email");
            simpleMailMessage.setFrom(fromEmail);
            simpleMailMessage.setTo(to);
            simpleMailMessage.setText(EmailUtils.getEmailMessage(name,  host ));
            javaMailSender.send(simpleMailMessage);

        }catch (Exception e){
            System.out.println(e.getMessage());

            throw  new RuntimeException(e.getMessage());
        }
    }    public void sendSimpleEmailMessage(String name, String to, String token) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setSubject("Verificação de Email");
            simpleMailMessage.setFrom(fromEmail);
            simpleMailMessage.setTo(to);
            simpleMailMessage.setText(EmailUtils.getEmailMessage(name,  host , token));
            javaMailSender.send(simpleMailMessage);

        }catch (Exception e){
            System.out.println(e.getMessage());

            throw  new RuntimeException(e.getMessage());
        }
    }



}
