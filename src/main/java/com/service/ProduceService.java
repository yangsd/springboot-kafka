package com.service;

import com.dto.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author sdyang
 * @create 2018-01-05 20:01
 **/
@Service
public class ProduceService {

    private static Logger logger = LoggerFactory.getLogger(ProduceService.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;


    /**
     * 往 Kafka 发送数据
     * @param message
     */
    public void send(final Message message) {

        if(message.getValue() == null || message.getValue().equals("")){
            return;
        }

        ListenableFuture<SendResult<Integer, String>> future = null;

        if(message.getKey() == null || message.getKey().equals("")) {
            future = kafkaTemplate.send(message.getTopic(),message.getValue());
        }else {
            future = kafkaTemplate.send(message.getTopic(), message.getKey(), message.getValue());
        }

        future.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {

            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                logger.info(String.format("发送数据：%s",message.getValue()));
            }

            @Override
            public void onFailure(Throwable ex) {
                logger.error(String.format("发送失败：%s",message.getValue()));
            }

        });

    }


}
