//import java.util.Scanner;
//import java.util.Stack;
//
//public class Test1 {
//    public static void main(String[] args) {
////        String str = "hello";
////        String str2 = "hello";
////        System.out.println(str == str2);
//
//        Parenthesis p = new Parenthesis();
//        System.out.println(p.chkParenthesis("(()())",6));
//    }
//}

//
//import java.util.Scanner;
//public class Test1 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        StringBuffer sb = new StringBuffer();
//        int max = 0;
//        for(int i=0;i<str.length();i++){
//            if(str.indexOf(i)<'9'&& str.indexOf(i)>'0'){
//                sb.append(str.indexOf(i));
//            }else{
//                int len = sb.length();
//                if(len > max){
//                    max = len;
//                    sb = null;
//                }
//            }
//        }
//        System.out.println(max);
//    }
//}


// ( () () )
//class Parenthesis {
//    public boolean chkParenthesis(String A, int n) {
//        // write code here
//        if (n %2 != 0) return  false;
//        Stack stack = new Stack();
//        for (int i = 0; i < n; i++) {
//            if (A.indexOf(i) == '('){
//                stack.push(A.charAt(i));
//            }else if (!stack.empty()){
//                Object c = stack.peek();
//                if (c.equals('(') && A.indexOf(i) == ')'){
//                    stack.pop();
//                }
//            }else {
//                return false;
//            }
//        }
//        if (!stack.empty()){
//            return false;
//        }
//        return true;
//    }
//}

class AntiOrder {
    public int count(int[] A, int n) {
        // write code here
        int count = 0;
        for (int i = 0; i <n; i++) {
            for (int j = i; j <n; j++) {
                if(A[i] > A[j]){
                    count ++;
                }
            }
        }
        System.out.println(count);
        return count;
    }
}

public class  Test1{
    public static void main(String[] args) {
        AntiOrder antiOrder = new AntiOrder();
        int[] A = {1,2,3,4,5,6,7,0};
        antiOrder.count(A,8);
    }
}