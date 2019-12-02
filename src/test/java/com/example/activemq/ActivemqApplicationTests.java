package com.example.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.jms.Destination;

@SpringBootTest(classes = {ActivemqApplication.class})
@ExtendWith(SpringExtension.class)
class ActivemqApplicationTests {

	@Autowired
	private JMSProducer jmsProducer;
	@Test
	void contextLoads() {
		Destination destination = new ActiveMQQueue("springboot.queue.test");

		for (int i=0;i<10;i++) {
			jmsProducer.sendMessage(destination,"hello,world!" + i);
		}
	}

}
