package test;

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class TestNum {

    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            num = sc.nextInt();
            for (int i = 2; i <= sqrt(num); i++) {
                while(num !=i  && num%i == 0) {
                    System.out.println(i);
                    num /=i;
                }
            }
            System.out.println(num);
        }
    }
}
