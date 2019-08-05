package org.zmodule.listener;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.zmodule.channel.SelfMqChannel;
import org.zmodule.vo.Product;

@Component
@EnableBinding(SelfMqChannel.class)
public class StreamConsumerListener {
	
//    @StreamListener(Sink.INPUT)	//使用系统默认的管道
	@StreamListener(SelfMqChannel.INPUT)	//使用自定义的管道
    public void input(Message<Product> message) {
        System.err.println("【*** 消息接收1 ***】" + message.getPayload());
    }
    
}
