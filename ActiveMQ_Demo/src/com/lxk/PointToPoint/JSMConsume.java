package com.lxk.PointToPoint;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JSMConsume {
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
            destination = session.createQueue("QQ消息");
            messageConsumer = session.createConsumer(destination);

            for (int i = 0; i < 5; i++) {
                TextMessage message = (TextMessage) messageConsumer.receive();
                if (message != null){
                    System.out.println(message.getText());
                }
            }
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
