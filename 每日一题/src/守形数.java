import java.util.Scanner;

public class 守形数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String s1 = String.valueOf(num);
        int num2 = num*num;

        String s2 = String.valueOf(num2);
        if (s2.substring(s2.length()-2, s2.length()-2).equals(s1)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
