package Java8.InterfaceDefaultStaticMethods;

public class MyClass implements Interface1, Interface2 {

    @Override
    public void method1(){
        System.out.println("overridden methods 1 & 2");
    }

    //since both interface has default method with same signature, implemented class has to provide implementation
    @Override
    public void log(String s){
        System.out.println(s);
    }
}

class Mainclass {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.log("logging something...");
        obj.method1();
    }
}
