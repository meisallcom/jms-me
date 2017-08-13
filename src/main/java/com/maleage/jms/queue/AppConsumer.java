package com.maleage.jms.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by PerryZhang on 2017/8/13.
 */
public class AppConsumer {

    private static final String url = "tcp://localhost:61616";
    private static final String queueName="queue-test";
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
            Destination destination = session.createQueue(queueName);
            //6.创建一个消费者
            MessageConsumer consumer = session.createConsumer(destination);

            //7.创建一个监听
            consumer.setMessageListener(new MessageListener() {
                public void onMessage(Message message) {
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println("接受消息： " + textMessage.getText());
                    }catch(JMSException e){
                        e.printStackTrace();
                    }
                }
            });

            //connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
