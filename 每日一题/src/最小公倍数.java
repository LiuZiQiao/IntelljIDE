//import java.util.Scanner;
//
//public class 最小公倍数 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            int max = a>b?a:b;
//            while(true){
//                if ((max%a==0) && (max%b==0)) {
//                    System.out.println(max);
//                    int n = (int) Math.pow(max%10,3);
//                    break;
//                }
//            }
//        }
//    }
//}

//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Solution {
//    /**
//     * @param A: An integer array
//     * @return: An integer
//     */
//    public int singleNumber(int[] A) {
//        // write your code here
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int i=0;i<A.length;i++){
//            if(map.containsKey(A[i])){
//                map.put(A[i],-1);
//            }else{
//                map.put(A[i],i);
//            }
//        }
//
//        for(Integer i:map.keySet()){
//            if(map.get(i)>=0){
//                return i.intValue();
//            }
//        }
//        return 1;
//    }
//}
//
//public class Solution2 {
//    /**
//     * @param numbers: An array of Integer
//     * @param target: target = numbers[index1] + numbers[index2]
//     * @return: [index1, index2] (index1 < index2)
//     */
//    public int[] twoSum(int[] numbers, int target) {
//        // write your code here
//        HashMap<Integer,Integer> map = new HashMap<>();
//        int[] A = new int[2];
//        for (int i=0;i<numbers.length;i++){
//            if(map.containsKey(target-numbers[i])){
//                A[0] = i;
//                A[1] = map.get(target-numbers[i]);
//                break;
//            }
//            map.put(numbers[i],i);
//        }
//        return  A;
//    }
//}