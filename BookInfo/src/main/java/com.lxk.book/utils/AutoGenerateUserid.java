package com.LibraryManageInfo.www.utils;

/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/9 21:59
 */
public class AutoGenerateUserid {
    private static int userid = 1;

    public int getUserid_auto() {
        userid++;
        return userid;
    }
}