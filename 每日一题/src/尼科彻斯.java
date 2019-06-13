import java.util.Scanner;
public class 尼科彻斯 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        while(sc.hasNext()){
            int N = sc.nextInt() ;
            String s = decompose(N) ;
            System.out.println(s);
        }
        sc.close();
    }

    private static String decompose(int n) {
        int [] array = new int[n] ;
        int mid = n / 2 ;
        if(n*n % 2 == 0)
            array[mid] = n*n + 1;
        else
            array[mid] = n*n ;
        for(int i = mid; i >= 1 ; i--){
            int temp = array[i] ;
            array[i - 1] = temp - 2 ;
        }
        for(int j = mid ; j < n - 1; j++){
            int temp = array[j] ;
            array[j + 1] = temp + 2 ;
        }
        StringBuffer sb = new StringBuffer() ;
        for(int k = 0 ; k < n ; k++){
            if(k != n - 1)
                sb.append(array[k] + "+") ;
        }
        sb.append(array[n - 1]) ;

        return sb.toString();
    }

}