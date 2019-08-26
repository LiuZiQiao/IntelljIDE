package com.lxk;

import java.util.Scanner;

public class Testtt {
    public static void main(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        String[] s = new String[n];
        for (int i=0;i<n;i++){
           s[i] = sc.nextLine();
        }
        for (int i=0;i<s.length;i++){
            System.out.println(s[i]);
        }
    }
}
