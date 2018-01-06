package com.task;

import com.service.ProduceService;
import com.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author sdyang
 * @create 2018-01-05 21:13
 **/
@Component
public class ProduceTask {

    @Autowired
    private ProduceService produceService;

    @Scheduled(cron = "0/5 * * * * ?")
    public void sendMessage() {
        for (int i = 0; i < 500; i++) {
            Message message = new Message();
            message.setTopic("mytopic");
            message.setKey(new Random() + "");
            message.setValue(new Random().nextInt(1000) + "");
            produceService.send(message);
        }
    }
}
