//package com.udith.mycontacts.jms;
//
//import com.udith.mycontacts.model.User;
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.Session;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.jms.core.MessageCreator;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ContactSenderImpl implements ContactSender {
//
//  @Autowired
//  JmsTemplate jmsTemplate;
//
//  @Override
//  public void sendMyContact(final User user) {
//    jmsTemplate.send(
//            new MessageCreator() {
//              @Override
//              public Message createMessage(Session sn) throws JMSException {
//                return sn.createObjectMessage(user);
//              }
//            });
//  }
//
//}
