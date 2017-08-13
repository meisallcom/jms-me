package com.maleage.jms.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by PerryZhang on 2017/8/13.
 */
public class AppProducer {

    private static final String url = "tcp://localhost:61616";
    private static final String topicName="topic-test";
    public static void main(String[] args) {
        Connection connection = null;
        //1.创建ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        try{
            //2.创建Connection
             connection = connectionFactory.createConnection();
            //3.启动连接
            connection.start();
            //4.创建会话
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //5.创建一个目标
            Destination destination = session.createTopic(topicName);
            //6.创建一个生产者
            MessageProducer producer = session.createProducer(destination);
            for(int i=0;i<100;i++){
                //7.创建消息体
                TextMessage textMessage =  session.createTextMessage("test"+i);
                //8.发布消息
                producer.send(textMessage);
                System.out.println("发送消息： "+textMessage.getText());
            }
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
