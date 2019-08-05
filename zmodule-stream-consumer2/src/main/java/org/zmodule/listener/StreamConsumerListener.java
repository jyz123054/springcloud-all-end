package org.zmodule.listener;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.zmodule.vo.Product;

@Component
@EnableBinding(Sink.class)
public class StreamConsumerListener {
	
    @StreamListener(Sink.INPUT)
    public void input(Message<Product> message) {
        System.err.println("【*** 消息接收2 ***】" + message.getPayload());
    }
    
}
