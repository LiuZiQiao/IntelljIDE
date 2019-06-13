import java.util.Scanner;

public class 反转字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuffer s = new StringBuffer(str);
        System.out.println(s.reverse());
    }
}
