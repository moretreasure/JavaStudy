package 자바의정석;

@FunctionalInterface
interface MyFunction{
    void run();
}

public class how {
    //매개변수의 타입이 MyFunction(함수형 인터페이스)인 메서드
    static void execute(MyFunction f){
        f.run();
    }

    //반환 타입이 MyFunction(함수형 인터페이스)인 메서드
    static MyFunction getMyFunction(){
//        MyFunction f = () -> System.out.println("f3.run()");
//        return f;
        return () -> System.out.println("f3.run()");
    }

    public static void main(String[] args) {
        //람다식으로 MyFunction의 run()을 구현
        MyFunction f1 = () -> System.out.println("f1.run()");

        //익명클래스로 run()을 구현
        MyFunction f2 = new MyFunction() {
            @Override
            public void run() {     //public을 반드시 붙여야 함
                System.out.println("f2.run()");
            }
        };

        MyFunction f3 = getMyFunction();

        f1.run();
        f2.run();
        f3.run();

        execute(f1);
        execute(()-> System.out.println("run()"));
    }
}

