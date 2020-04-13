import java.util.Scanner;

public class 密码验证 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int count = 0;
            String str = sc.nextLine();
            if (str.length() <= 8)
                System.out.println("NG");
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) <= 9 && str.charAt(i) >= 0) {
                    count++;
                } else if (str.charAt(i) <= 'z' && str.charAt(i) >= 'a') {
                    count++;
                } else if (str.charAt(i) <= 'Z' && str.charAt(i) >= 'A') {
                    count++;
                } else {
                    count++;
                }

                if (count >= 3){
                    System.out.println("OK");
                }
            }
        }
    }
}
