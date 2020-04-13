import java.util.Scanner;

public class 偶串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int n = str.length();
        int k = 0;
        for (int i=0;i<n/2;i++){
            n -= 2;
            for(int j= 0;j<n/2;j++){
                if(str.charAt(j) == str.charAt(j+n/2)){
                    k++;
                }else {
                    k=0;
                    break;
                }
            }
            if (k== n/2)
                break;
        }
        System.out.println(2*k);
    }
}
