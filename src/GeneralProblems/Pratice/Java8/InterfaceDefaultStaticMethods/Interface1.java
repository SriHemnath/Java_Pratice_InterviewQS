package GeneralProblems.Pratice.Java8.InterfaceDefaultStaticMethods;

// benefits of the functional interface is the possibility to use lambda expressions to instantiate them
@FunctionalInterface
public interface Interface1 {
    void method1();

    default void log(String s){
        System.out.println(s);
    }

    static void print(String s){
        System.out.println(s);
    }
}
