//public class Test implements Interface,Interface2{
//
//    @Override
//    public void run() {
//
//    }
//}
//public  class  Test extends Abstrack1{
//
//    @Override
//    public void eat() {
//
//    }
//}

import java.util.concurrent.ThreadPoolExecutor;

public class Test {
    public static void main(String[] args) {
//        System.out.println(fun1());
//        fun1();
    }

    public static int fun(){
        int i = 10;
        try{
            i= i/0;
            return --i;
        }catch (Exception e){
            e.printStackTrace();
            return --i;
        }finally {
            return --i;
        }
    }

    public static  void fun1(){
        Integer a = 1;
        Integer b = 2;
        System.out.println(a==b);
    }
//    private synchronized static void RunA(){
//        System.out.println("RunA");
//    }
//    private synchronized static void RunB(){
//        System.out.println("RunB");
//    }
}