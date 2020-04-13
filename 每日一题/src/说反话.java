import java.util.Scanner;

public class 说反话 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuffer sb = new StringBuffer(str);
        String s=null;

        int start,end,i=0;
        while (i>0){
            start = i;
            if (sb.charAt(i)== ' '){
                s = sb.substring(start,i);
                StringBuffer ss = new StringBuffer(s);
                ss.reverse();
            }else {
                i++;
            }
        }
        System.out.println(s);
    }
}



