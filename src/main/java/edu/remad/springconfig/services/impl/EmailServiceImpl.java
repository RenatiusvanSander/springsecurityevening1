package edu.remad.springconfig.services.impl;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.naming.OperationNotSupportedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import edu.remad.springconfig.services.EmailService;
import edu.remad.springconfig.systemenvironment.SystemEnvironment;
import freemarker.template.TemplateException;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private SystemEnvironment env;

	@Override
	public void sendSimpleMessage(String to, String subject, String text) {
		SimpleMailMessage emailMessage = new SimpleMailMessage();
		emailMessage.setFrom(env.getSmtpUsername());
		emailMessage.setTo(to);
		emailMessage.setSubject(subject);
		emailMessage.setText(text);
		emailMessage.setSentDate(Date.valueOf( LocalDateTime.now().toLocalDate()));
		
		mailSender.send(emailMessage);
	}

	@Override
	public void sendSimpleMessageUsingTemplate(String to, String subject, String... templateModel) throws OperationNotSupportedException {
		SimpleMailMessage emailMessage = new SimpleMailMessage();
		emailMessage.setFrom(env.getSmtpUsername());
		emailMessage.setTo(to);
		emailMessage.setSubject(subject);
		emailMessage.setText(text);
		emailMessage.setSentDate(Date.valueOf( LocalDateTime.now().toLocalDate()));
		
		mailSender.send(emailMessage);
	}

	@Override
	public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) throws OperationNotSupportedException {
		throw new OperationNotSupportedException("This method is not supported: sendMessageWithAttachment.");
	}

	@Override
	public void sendMessageUsingThymeleafTemplate(String to, String subject, Map<String, Object> templateModel)
			throws IOException, MessagingException, OperationNotSupportedException {
		throw new OperationNotSupportedException("This method is not supported: sendMessageUsingThymeleafTemplate.");
	}

	@Override
	public void sendMessageUsingFreemarkerTemplate(String to, String subject, Map<String, Object> templateModel)
			throws IOException, TemplateException, MessagingException, OperationNotSupportedException {
		throw new OperationNotSupportedException("This method is not supported: sendMessageUsingFreemarkerTemplate.");
	}
	
	private void sendHtmlMail(String to, String subject, String htmlBody) throws MessagingException {
	    MimeMessage message = mailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
	    helper.setTo(to);
	    helper.setSubject(subject);
	    helper.setText(htmlBody, true);
	    mailSender.send(message);
	}
}
