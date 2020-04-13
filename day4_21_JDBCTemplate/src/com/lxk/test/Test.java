package com.lxk.test;

import java.util.LinkedList;

public class Test{
    public static LinkedList<Integer> list = new LinkedList<Integer>();
    public static void findSum(int sum,int n){
        if(n<1 || sum <1)
            return ;
        if(sum < n)
            n = sum;
        if(sum == n){
            for(int i=0;i<list.size();i++){
                System.out.print(list.get(i)+"");
            }
            System.out.print(sum);
            System.out.println();
        }

        list.addLast(n);
        findSum(sum-1,n-1);
        list.removeLast();
        findSum(sum,n-1);
    }

    public static void main(String[] args){
        int sum = 10;
        int n = 8;
        findSum(sum,n);
    }
}