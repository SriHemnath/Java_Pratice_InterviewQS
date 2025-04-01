package GeneralProblems.Java8.InterfaceDefaultStaticMethods;

@FunctionalInterface
public interface Interface2 {
    void method1();

    default void log(String s){
        System.out.println(s);
    }

    static void print(String s){
        System.out.println(s);
    }
}
