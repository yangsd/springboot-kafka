package com.task;

import com.dto.Message;
import com.service.ProduceService;
import com.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author sdyang
 * @create 2018-01-05 21:13
 **/
@Component
public class ProduceTask {

    private static Logger logger = LoggerFactory.getLogger(ProduceTask.class);

    @Value("${kafka.producer.topic}")
    private String topic;
    @Autowired
    private ProduceService produceService;

    @Scheduled(cron = "0/5 * * * * ?")
    public void sendMessage1() {
        for (int i = 0; i < 5; i++) {
            Message message = new Message();
            message.setTopic(topic);
            message.setValue(DateUtil.getNow() + new Random().nextInt(2000));
            produceService.send(message);
        }
    }

    @Scheduled(cron = "0/3 * * * * ?")
    public void sendMessage2() {
        for (int i = 0; i < 1; i++) {
            Message message = new Message();
            message.setTopic(topic);
            message.setValue(DateUtil.getNow() + new Random().nextInt(2000));
            produceService.send(message);
        }
    }


}
