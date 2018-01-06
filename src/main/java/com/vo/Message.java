package com.vo;

/**
 * @author sdyang
 * @create 2018-01-05 21:03
 **/
public class Message {

    /**
     * 主题
     */
    private String topic;

    /**
     * key
     */
    private String key;

    /**
     * value
     */
    private String value;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
