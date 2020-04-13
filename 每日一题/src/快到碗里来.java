import java.util.Scanner;

public class 快到碗里来 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            double l = 3.14*b*2;
            if (l > a){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
