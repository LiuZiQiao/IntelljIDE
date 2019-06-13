import java.util.Scanner;

public class 兔子 {
    static int total;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(getTotalCount(num));
    }

    private static int getTotalCount(int num) {
        if (num ==1 || num == 2){
            total = 1;
        }
        if (num>2)
        total = getTotalCount(num-1)+getTotalCount(num-2);
        return total;
    }
}
