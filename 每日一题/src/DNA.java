import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DNA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
//        int num = sc.nextInt();
        System.out.println(fun(str));
    }

    private static int fun(String str) {
        for (int i = 0; i <= str.length() ; i++) {
            Set<String> set = new TreeSet<>();
            for (int j = 0; j <str.length()-i ; j++) {
                set.add(str.substring(j,j+i));
            }
            if (set.size() < Math.pow(4,i)){
                return i;
            }
        }
        return 1;
    }
}
