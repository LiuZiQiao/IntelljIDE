import java.util.Arrays;
import java.util.Scanner;

public class 组个最小数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[] strs = str.split(" ");
            int[] arr = new int[strs.length];
            for (int i=0;i<arr.length;i++){
                arr[i] = Integer.parseInt(strs[i]);
            }
            Arrays.sort(arr);
            if (arr[0] == 0){
                for (int i=1;i<arr.length;i++){
                    if(arr[i] != 0){
                        int tmp = arr[0];
                        arr[0] =  arr[i];
                        arr[i] = tmp;
                    }
                }
            }
            System.out.println(arr.toString());
        }
    }
}
