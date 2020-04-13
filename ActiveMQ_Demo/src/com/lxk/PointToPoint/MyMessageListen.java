package com.lxk.PointToPoint;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyMessageListen implements MessageListener {
    @Override
    public void onMessage(Message message) {
        for (int i = 0; i < 5; i++) {
            if (message != null){
                try {
                    TextMessage msg = (TextMessage) message;
                    System.out.println(msg.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
