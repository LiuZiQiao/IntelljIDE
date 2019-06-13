//import java.util.Scanner;
//
//public class Test3 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        String str2 = sc.nextLine();
////        System.out.println(str+"---"+str2);
//        String ret = null;
//        int[] hashtable = new int[256];
//        for (int i = 0; i <str2.length() ; i++) {
//            hashtable[str.charAt(i)]++;
//        }
//        for (int i = 0; i < str.length(); i++) {
//            if (hashtable[i] != 0){
//                ret += str.charAt(i);
//            }
//        }
//        System.out.println(ret);
//    }
//}

import java.util.Scanner;

public class Test3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int min = 0;
        if (num < 6){
            min = -1;
        }else if (num <8){
            int n = num % 6 ;
            if (n==0){
                min = n;
            }else if (num >8){

            }
        }
        System.out.println(min);
    }
}