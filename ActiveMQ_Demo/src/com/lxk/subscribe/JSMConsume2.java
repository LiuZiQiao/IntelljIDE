package com.lxk.subscribe;

import com.lxk.PointToPoint.MyMessageListen;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JSMConsume2 {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String  URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        Session session = null;
        Destination destination = null;
        MessageConsumer messageConsumer= null;

        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, URL);

        try{
            connection = connectionFactory.createConnection();
            connection.start();
            session =connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
            destination = session.createTopic("QQ消息");
            messageConsumer = session.createConsumer(destination);

            messageConsumer.setMessageListener(new MyMessageListen2());
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class MyMessageListen2 implements MessageListener {
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

