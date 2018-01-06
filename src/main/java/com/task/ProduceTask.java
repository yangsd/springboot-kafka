package com.task;

import com.service.ProduceService;
import com.vo.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author sdyang
 * @create 2018-01-05 21:13
 **/
@Component
public class ProduceTask {

    private static Logger logger = LoggerFactory.getLogger(ProduceTask.class);

    @Autowired
    private ProduceService produceService;

    @Scheduled(cron = "0/5 * * * * ?")
    public void sendMessage() {
        for (int i = 0; i < 500; i++) {
            Message message = new Message();
            message.setTopic("mytopic");
            message.setValue(this.getNow() + new Random().nextInt(2000));
            produceService.send(message);
        }
    }

    public String getNow(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return format.format(date);
    }
}
