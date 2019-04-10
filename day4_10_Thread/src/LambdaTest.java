public class LambdaTest {
    public static void main(String[] args) {
        invokeCook(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("做饭啦");
            }
        });

        invokeCook(()->{
            System.out.println("做饭啦");
        });
    }

    public static void invokeCook(Cook cook) {
        cook.makeFood();
    }
}

