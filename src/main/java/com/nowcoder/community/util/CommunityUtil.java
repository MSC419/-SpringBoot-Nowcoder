package com.nowcoder.community.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.UUID;

public class CommunityUtil {
    //生成随机字符串
    public static String generateUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    //提交密码提交的是明文，存的时候要加密
    //MD5 特点1、只能加密不能解密2、确定加密（一样的明文加密出来的密文一样）
    //解决办法：在密码后面+随机字符串
    public static String md5(String key){
        if(StringUtils.isBlank(key)){//如果是空值就不处理
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }
}
