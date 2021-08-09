package com.nowcoder.community.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Component//被容器管理
public class MailClient {
    private static final Logger logger = LoggerFactory.getLogger(MailClient.class);

    @Autowired
    private JavaMailSender mailSender;
    //点进去JavaMailSender得知：就两种方法：MimeMessage邮件主题，send把邮件主题发送出去

    //发邮件的条件：发件人，收件人，标题，内容
    //发件人每次都是同一个，所以注入进来
    @Value("${spring.mail.username}")
    private String from;

    public void sendMail(String to,String subject, String content){
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);//不加第二个参数，文本是普通文本；加之后允许支持html文本
            mailSender.send(helper.getMimeMessage());
        } catch (MessagingException e) {//出错就记到日志里
            logger.error("发送邮件失败"+e.getMessage());
        }

    }
}
