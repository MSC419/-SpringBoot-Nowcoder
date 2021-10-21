package com.nowcoder.community.entity;

import java.util.HashMap;
import java.util.Map;

public class Event {
    private String topic;//不同的类型：评论、点赞、关注
    private int userId;//事件触发的人
    private int entityType;
    private int entityId;//被触发的实体对象
    private int entityUserId;//实体作者
    private Map<String, Object> data = new HashMap<>();//具有扩展性

    public String getTopic() {
        return topic;
    }

    public Event setTopic(String topic) {//返回自身可以循环调用
        this.topic = topic;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public Event setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public int getEntityType() {
        return entityType;
    }

    public Event setEntityType(int entityType) {
        this.entityType = entityType;
        return this;
    }

    public int getEntityId() {
        return entityId;
    }

    public Event setEntityId(int entityId) {
        this.entityId = entityId;
        return this;
    }

    public int getEntityUserId() {
        return entityUserId;
    }

    public Event setEntityUserId(int entityUserId) {
        this.entityUserId = entityUserId;
        return this;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public Event setData(String key,Object value) {
        this.data.put(key, value);
        return this;
    }
}
