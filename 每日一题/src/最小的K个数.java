import com.sun.xml.internal.ws.api.pipe.Fiber;

import java.util.Arrays;
import java.util.Scanner;

//public class 最小的K个数 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String numbers = sc.nextLine();
//            String[] str = numbers.split(" ");
//            int[] arr = new int[str.length-1];
//            for (int i = 0;i<str.length-1;i++){
//                arr[i] = Integer.parseInt(str[i]);
//            }
////            int k = arr[str.length-1];
//            Arrays.sort(arr);
////            System.out.println(arr.toString());
//        }
//    }
//}

//
public class 最小的K个数{
    private static void testMeth(){
        System.out.println("test");
    }

    public static void main(String[] args) {
        ((最小的K个数)null).testMeth();
    }
}

class 末尾{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
//        System.out.println(Fib(n));
        int num = Fib(n);
        int count = 0;
        String str = String.valueOf(num);
        for (int i=str.length()-1;i>=0;i++){
            if (str.indexOf(i)== '0'){
                System.out.println(str.indexOf(i));
                count++;
            }
        }
        System.out.println(count);
    }

    public static int Fib(int n){
        int num = 1;
        while (n>0){
            num = num*n;
            n--;
        }
        return  num;
    }
}



class 末尾1{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(trailingZeroes(n));
    }
    public static int trailingZeroes(int n) {
        int res = 0;
        while(n>4){
            n/=5;
            res = n;
        }
        return res;
    }
}

class foo{
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operate(a,b);
        System.out.println(a+"."+b);
    }

    static void operate(StringBuffer a, StringBuffer b) {
        a.append(b);
        b=a;
    }
}
