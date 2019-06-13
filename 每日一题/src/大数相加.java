import java.math.BigInteger;
import java.util.Scanner;

public class 大数相加 {
    public static String bigNumberSum(String bigNumberA, String bigNumberB) {

        //1.把两个大整数用数组逆序存储
        char[] charsA = new StringBuffer(bigNumberA).reverse().toString().toCharArray();
        char[] charsB = new StringBuffer(bigNumberB).reverse().toString().toCharArray();

        //2.构建result数组，数组长度等于较大整数位数+1
        int maxLength = charsA.length > charsB.length ? charsA.length : charsB.length;
        int[] result = new int[maxLength + 1];
        //3.遍历数组，按位相加
        for (int i = 0; i < result.length; i++) {
            int temp = result[i];
            if (i < charsA.length) {
                temp += charsA[i] - '0';
            }
            if (i < charsB.length) {
                temp += charsB[i] - '0';
            }

            //判断是否进位
            if (temp >= 10) {
                temp = temp - 10;
                result[i + 1] = 1;
            }
            result[i] = temp;
        }

        //4.把result数组再次逆序并转成String
        StringBuilder sb = new StringBuilder();
        // 判断最后一位是否发生了进位
        int head=result.length-1;
        if (result[result.length-1] == 0 )
            head=result.length-2;
        for (int i = head; i >= 0; i--)
            sb.append(result[i]);
        return sb.toString();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
//        BigInteger number1 = sc.nextBigInteger();
//        BigInteger number2 = sc.nextBigInteger();
        String str = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(bigNumberSum(str, str2));
    }
}
