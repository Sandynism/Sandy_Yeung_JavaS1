package com.trilogyed.emaillistqueueconsumer;

import com.trilogyed.emaillistqueueconsumer.util.messages.EmailListEntry;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

//We use the the @Service annotation to let Spring know that it should pay attention to this component.
@Service
public class MessageListener {

    //We use the @RabbitListener annotation to specify the queues this component will listen to.
    @RabbitListener(queues = EmailListQueueConsumerApplication.QUEUE_NAME)
    public void receiveMessage(EmailListEntry msg) {
        System.out.println(msg.toString());
    }
    //The receiveMessage method processes our messages. It takes an EmailListEntry message as a parameter and processes it.
    // In our case, it just prints the message; an actual application would use the message contents to create a new email list entry.
}

