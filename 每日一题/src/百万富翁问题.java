public class 百万富翁问题 {
    public static void main(String[] args) {
        long poor = 0;
        long rich = 0;
        for (int i = 1; i <=30 ; i++) {
            rich+=10;
            poor = (long) (poor+ Math.pow(2,i-1));
        }
        System.out.println(rich+" "+poor);
    }
}
