package com.alex.ali.mail;

import com.alex.ali.BaseGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Locale;

public abstract class BaseMailService extends BaseGenericService {

    private JavaMailSender mailSender;
    private TemplateEngine templateEngine;

    protected boolean sender(MailOnly mailOnly) {
        try {
            MimeMessage mimeMessage = this.mailSender.createMimeMessage();
            mimeMessage.setRecipient(Message.RecipientType.TO,
                    new InternetAddress(mailOnly.getEmail()));
            mimeMessage.setFrom(new InternetAddress("admin@support.nerchain.com", mailOnly.getName()));
            mimeMessage.setSubject(mailOnly.getSubject());
            Context context = new Context(Locale.US);
            context.setVariables(mailOnly.getVariables());
            String process = this.templateEngine.process(mailOnly.getTemplate(), context);
            mimeMessage.setText(process, "Utf-8", "html");
            this.mailSender.send(mimeMessage);
            return true;
        } catch (MailException | MessagingException | IOException e) {
            this.logger.error("邮件发送失败,错误信息:" + e.getMessage());
        }
        return false;
    }

    @Autowired
    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Autowired
    public void setTemplateEngine(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }
}
