public class Test4{
    private String name = "abc";
    public static void main(String[] args) {
        Test4 t1 = new Test4();
        Test4 t2 = new Test4();
//        System.out.println(t1.equals(t2));
    }
}

class X{
    Y y = new Y();
    public X(){
        System.out.println("X");
    }
}

class Y{
    public Y(){
        System.out.println("Y");
    }
}