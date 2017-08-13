package com.maleage.springjms.consumer;

import com.maleage.springjms.producer.ProducerService;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

/**
 * Created by PerryZhang on 2017/8/13.
 */
public class AppConsumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
    }
}
