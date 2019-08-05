package org.zmodule.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 自定义的管道，INPUT OUTPUT
 * @author Administrator
 *
 */
public interface SelfMqChannel {
	public static final String OUTPUT = "self_output";
	
	public static final String INPUT = "self_input";
	
	@Input(SelfMqChannel.INPUT)
	public SubscribableChannel input();
	
	@Output(SelfMqChannel.OUTPUT)
	public MessageChannel output();
	
}
