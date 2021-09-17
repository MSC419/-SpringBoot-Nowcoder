package com.nowcoder.community.util;

public class RedisKeyUtil {
    //简单工具不需要由容器管理，提供静态方法就行了
    private static final String SPLIT = ":";
    private static final String PREFIX_ENTITY_LIKE = "like:entity";
    private static final String PREFIX_USER_LIKE = "like:user";

    //某个实体获得的赞
    //like:entity:entityType:entityId  谁给实体点赞，userId存入entityLikeKey对应的set里
    public static String getEntityLikeKey(int entityType,int entityId){
        return PREFIX_ENTITY_LIKE + SPLIT + entityType + SPLIT + entityId;
    }

    //某个用户获得的赞
    //like:user:userId 谁给用户点赞，存入userLikeKey对应的容器里，存入的是数字
    public static String getUserLikeKey(int userId){
        return PREFIX_USER_LIKE+SPLIT+userId;
    }
}
