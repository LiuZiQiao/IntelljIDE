package com.lxk.PointToPoint;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JSMProduct {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String  URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        Session session = null;
        Destination destination = null;
        MessageProducer messageProducer = null;

        connectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,URL);
        try{
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
            destination = session.createTopic("QQ消息");
            messageProducer = session.createProducer(destination);

            String text = "1870000000";
            for(int i = 0;i<10;i++){
                TextMessage msg = session.createTextMessage(text+i);
                System.out.println(text+i);
                messageProducer.send(destination,msg);
            }
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(connection != null){
                    session.close();
                    messageProducer.close();
                    connection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
