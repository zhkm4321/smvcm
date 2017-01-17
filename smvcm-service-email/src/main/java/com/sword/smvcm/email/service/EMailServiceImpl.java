package com.sword.smvcm.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.sword.smvcm.email.i.EMailService;
import com.sword.smvcm.email.pojo.MailParam;

@Service("eMailService")
public class EMailServiceImpl implements EMailService {

  @Autowired
  private JavaMailSender mailSender;// spring配置中定义

  @Autowired
  private SimpleMailMessage simpleMailMessage;// spring配置中定义

  @Autowired
  private ThreadPoolTaskExecutor threadPool;

  /**
   * 发送模板邮件
   *
   * @param mailParam 需要设置四个参数 templateName,toMail,subject,mapModel
   * @throws Exception
   *
   */
  @Override
  public void threadSend(final MailParam mailParam) {
    threadPool.execute(new Runnable() {
      public void run() {
        try {
          simpleMailMessage.setFrom(simpleMailMessage.getFrom()); // 发送人,从配置文件中取得
          simpleMailMessage.setTo(mailParam.getTo()); // 接收人
          simpleMailMessage.setSubject(mailParam.getSubject());
          simpleMailMessage.setText(mailParam.getContent());
          mailSender.send(simpleMailMessage);
        }
        catch (MailException e) {
          throw e;
        }
      }
    });
  }

  @Override
  public void send(MailParam mailParam) {
    try {
      simpleMailMessage.setFrom(simpleMailMessage.getFrom()); // 发送人,从配置文件中取得
      simpleMailMessage.setTo(mailParam.getTo()); // 接收人
      simpleMailMessage.setSubject(mailParam.getSubject());
      simpleMailMessage.setText(mailParam.getContent());
      mailSender.send(simpleMailMessage);
    }
    catch (MailException e) {
      throw e;
    }
  }
}
