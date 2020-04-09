package com.curd.utils;

import java.util.UUID;

/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/9 21:59
 */
public class RenamePhoto {
    public static String rename(String origin) {
        StringBuffer sb = new StringBuffer(origin);
        String reverseStr = sb.reverse().toString();
        int indexOf = reverseStr.indexOf(".");
        String subString = reverseStr.substring(0, indexOf + 1);
        String str2 = new StringBuffer(subString).reverse().toString();
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // System.out.println(str);
        String newStr = str.replace("-", "");
        return newStr.concat(str2);
    }

}