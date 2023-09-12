package edu.remad.springconfig.services;

import java.io.IOException;
import java.util.Map;

import javax.mail.MessagingException;
import javax.naming.OperationNotSupportedException;

import freemarker.template.TemplateException;

public interface EmailService {

	void sendSimpleMessage(String to, String subject, String text);

	void sendSimpleMessageUsingTemplate(String to, String subject, String... templateModel) throws OperationNotSupportedException;

	void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) throws OperationNotSupportedException;

	void sendMessageUsingThymeleafTemplate(String to, String subject, Map<String, Object> templateModel)
			throws IOException, MessagingException, OperationNotSupportedException;

	void sendMessageUsingFreemarkerTemplate(String to, String subject, Map<String, Object> templateModel)
			throws IOException, TemplateException, MessagingException, OperationNotSupportedException;
}