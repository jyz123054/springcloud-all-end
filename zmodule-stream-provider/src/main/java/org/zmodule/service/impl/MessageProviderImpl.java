package org.zmodule.service.impl;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.zmodule.channel.SelfMqChannel;
import org.zmodule.service.IMessageProvider;
import org.zmodule.vo.Product;

import javax.annotation.Resource;

@EnableBinding(SelfMqChannel.class)
public class MessageProviderImpl implements IMessageProvider{
    @Resource
    @Qualifier("self_output")
    private MessageChannel output;  // 消息的发送管道

    @Override
    public void send(Product product) {
        output.send(MessageBuilder.withPayload(product).build());
    }
}