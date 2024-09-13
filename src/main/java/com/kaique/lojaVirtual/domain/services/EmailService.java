package com.kaique.lojaVirtual.domain.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.kaique.lojaVirtual.domain.dto.EmailDTO;
import com.kaique.lojaVirtual.domain.exceptions.EmailException;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


@Service
public class EmailService {
	
	@Value("${spring.mail.username}")
	private String emailFrom;
	
    @Autowired
    private JavaMailSender emailSender;

    public void sendEmail(EmailDTO obj) {
        try{
        	 // Cria uma mensagem MIME para e-mails HTML
            MimeMessage mimeMessage = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            
            // Define remetente e destinatário
            helper.setFrom(emailFrom);
            helper.setTo(obj.getTo());
            helper.setSubject(obj.getSubject());
            helper.setText(obj.getBody(), true);
            emailSender.send(mimeMessage);

        } 
        catch (MessagingException  e){
        	throw new EmailException("Failed to send email");
        } 
    }
}