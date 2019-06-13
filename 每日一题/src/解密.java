import java.util.HashMap;
import java.util.Scanner;

public class 解密 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for (int i=0;i<str.length();i++){
            if (str.charAt(i) >='A' && str.charAt(i)<='Z'){
//                if (c>='A' && c<='Z') putchar((c-'A'+21)%26+'A');
//                str.indexOf(i);
                System.out.print((str.indexOf(i)+21)%26);
            }else {
                System.out.print(str.charAt(i));
            }
        }
    }
}