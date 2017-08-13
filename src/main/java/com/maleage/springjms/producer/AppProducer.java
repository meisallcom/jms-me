package com.maleage.springjms.producer;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * Created by PerryZhang on 2017/8/13.
 */
public class AppProducer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
        ProducerService service = context.getBean(ProducerService.class);
        for (int i=0; i<10; i++){
            service.sendMessage("testSpring: "+i);
        }
        context.close();
    }
}
