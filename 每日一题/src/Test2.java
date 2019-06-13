public class Test2 {
    public static void main(String[] args) {
        System.out.println(isAdmin("Admin"));
    }
    public static boolean isAdmin(String s){
        System.out.println(s.toLowerCase());
        return s.toLowerCase() == "admin";
    }


}
//
//class Test{
//    public int aMethod(){
//        static int i = 0;
//        i++;
//        return i;
//    }
//}

