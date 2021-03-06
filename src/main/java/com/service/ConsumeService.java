package com.service;

import com.util.DateUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sdyang
 * @create 2018-01-05 20:01
 **/
@Service
public class ConsumeService {

    private static Logger logger = LoggerFactory.getLogger(ConsumeService.class);

    @KafkaListener(topics = {"topic_test"},containerFactory = "kafkaListenerContainerFactory")
     public void listen(List<ConsumerRecord<?, ?>> records, Acknowledgment ack) {

        logger.info("***********  接收到" + records.size() + "条数据  ****************");

        try {
            for (ConsumerRecord record : records) {
                logger.info(String.format("---------------------接收到数据：  Timestamp:%s Partition:%s Offset:%s Value:%s --------------", DateUtil.toString(record.timestamp()),record.partition(),record.offset(),record.value()));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("处理异常：",e);
        } finally {
            ack.acknowledge();
        }
    }

}
