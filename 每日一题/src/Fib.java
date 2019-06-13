//import java.util.Scanner;
//
//public class Fib {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        int a=0,b=1,c = 1;
//        int leftstep = 0,rightstep = 0;
//        while (true){
//            a = b;
//            b = c;
//            c = a+b;
//            if (num < c){
//                rightstep = c-num;
//                break;
//            }else{
//                leftstep = num - c;
//            }
//        }
//        System.out.println(leftstep < rightstep ? leftstep:rightstep);
//    }
//}


import java.util.Scanner;

public class Fib {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int n = 0;
        String str = "";
        while(true){
            if (num < 1){
                break;
            }
            n = num%2;
            str += n;
            num = num/2;
        }
        int count =  0;
        int max = 0;
        for (int i=0;i<str.length();i++){
            if (str.charAt(i) == '1'){
                count++;
                max = count;
            }else if (str.charAt(i) == '0'){
                if(max<count){
                    max = count;
                    count = 0;
                }
            }
        }
        System.out.println(max);
    }
}