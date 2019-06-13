import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        System.out.println(s1+s2);
        for (int i=0;i<s1.length();i++){
            StringBuffer sb = new StringBuffer(s1);
            sb.insert(i,s2);
            System.out.println(sb);
            if (isHuiwen(sb.toString())){
                System.out.println("...");
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isHuiwen(String s){
        int i=0;
        int j = s.length()-1;
        while (i<j){
            if(s.charAt(i) != s.charAt(j)){
                return  false;
            }
            i++;
            j--;
        }
        return true;
    }
}

//
//import java.util.*;
//
//public class Main {
//    public int findKth(int[] a, int n, int K) {
//        // write code here
//        return findKth(a, n-1,K);
//    }
//    public int findKth(int[] a,int low,int high,int k){
//        int part = partation(a,low,high);
//        if (k == part -low +1)
//            return a[part];
//        else if (k > part-low+1)
//            return findKth(a,part+1,high,k-part+low-1);
//        else return findKth(a,low,part-1,k);
//    }
//
//    public int partation(int[] a,int low,int high){
//        int key = a[low];
//        while(low < high){
//            while (low<high && a[high] <= key)
//                high--;
//            a[low] =a[high];
//            while (low < high && a[low]>= key)
//                low++;
//            a[high] = a[low];
//        }
//        a[low] = key;
//        return  low;
//    }
//}