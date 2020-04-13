import java.util.Scanner;

public class 数字之和 {

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        while(sc.hasNext()){
            int a = sc.nextInt();
            int b = a;
            int sum1 = 0;
            while (b>0){
                int b1 = b%10;
                sum1 += b1;
                b1 /= 10;
            }

            double powNum = Math.pow(b,2);

            int sum2 = 0;
            while (powNum>0){
                double b2 = powNum%10;
                sum1 += b2;
                b2 /= 10;
            }

            System.out.println(sum1+" "+sum2);
        }
    }
}

