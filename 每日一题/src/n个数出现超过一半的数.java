import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;

public class n个数出现超过一半的数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            String[] strs = str.split(" ");
            int[] arr = new int[strs.length];
            for (int i = 0;i<arr.length;i++){
                arr[i] = Integer.valueOf(strs[i]);
            }
            int num = arr[0];
            int count = 0;
            for (int i=0;i<arr.length;i++){
                if (arr[i] == num){
                    count++;
                }else  if (count > 0){
                    count--;
                }else {
                    num = arr[i];
                }
            }
            System.out.println(num);
        }
    }
}

class main1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            float A = (a+c)/2f;
            float B = (c-a)/2f;
            float C = (d-b)/2f;
            if (A-((a+c)/2) != 0){
                System.out.print("No");
                return;
            }
            if ((B-((c-a)/2)!=0) || (b!=(b+d)/2)){
                System.out.print("No");
                return;
            }
            if ((c-(d-b)/2)!=0){
                System.out.println("No");
                return;
            }
            System.out.println(A+" "+B+" "+C);
        }

    }
}