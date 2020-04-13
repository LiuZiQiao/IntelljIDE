import java.util.Arrays;
import java.util.Scanner;

public class IFFF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)<='9' && str.charAt(i)>='0'){
                sb.append(str.charAt(i));
            }
        }
        String s = new String(sb);
        if (s.length()==0)
            System.out.println(-1);
        char[] arr = s.toCharArray();
//        Arrays.sort(s.toCharArray());
        Arrays.sort(arr,0,arr.length);
        System.out.println(arr);
    }
}


//import java.util.Scanner;
//
//
//
//
//public class IFFF{
//    public static void main(String[] args) {
//        int[] arr = {11,13,15,17,19,21};
//        int ret = find(arr,0,arr.length,19);
//        System.out.println(ret+1);
//    }
//
//    static int find(int[] arr,int low,int high,int key){
//        int mid = low+(high-low)/2;
//        if (low>high){
//            return -1;
//        }
//
//        if (arr[mid] == key)
//            return mid;
//        else if(arr[mid]>key)
//            return find(arr,low,mid-1,key);
//        else if(arr[mid]<key)
//            return find(arr,mid+1,high,key);
//        return 0;
//    }
//}