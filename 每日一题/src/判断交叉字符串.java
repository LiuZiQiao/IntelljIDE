import java.util.Scanner;

public class 判断交叉字符串 {
    public  static boolean isInterleave(String s1, String s2, String s3)
    {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 + len2 != s3.length())
            return false;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        int i = 1, j = 1;
        while (i <= len1 && s1.charAt(i - 1) == s3.charAt(i - 1))
            dp[i++][0] = true;
        while (j <= len2 && s2.charAt(j - 1) == s3.charAt(j - 1))
            dp[0][j++] = true;
        for (i = 1; i <= len1; i++) {
            for (j = 1; j <= len2; j++) {
                if ((dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)))
                    dp[i][j] = true;
            }
        }
        return dp[len1][len2];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1= sc.nextLine();
        String str2 = sc.nextLine();
        String str3 = sc.nextLine();
        if(isInterleave(str1,str2,str3)==true){
            System.out.println("TRUE");
        }else{
            System.out.println("FLASE");
        }
    }
}