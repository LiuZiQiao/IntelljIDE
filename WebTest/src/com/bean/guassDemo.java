package com.bean;

import com.dao.UserDao;

public class guassDemo {

//    public static void main(String[] args) {
//        String driver = "com.huawei.gauss.jdbc.ZenithDriver";
//        String url = "jdbc:zenith:@121.36.96.161:1888";
//        String user = "lxk";
//        String password = "liuxiaokun@123";
//        String sql = "select * from users";
//        Connection conn = null;
//        try {
//            Class.forName(driver).newInstance();
//            conn = DriverManager.getConnection(url, user, password);
////            System.out.println(conn);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User user = userDao.Login("lxk", "lxk123456");
        System.out.println(user);
    }
}
