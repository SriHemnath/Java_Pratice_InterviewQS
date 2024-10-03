package LinkedListGenerics;

public class TestLLGenerics {
    public static void main(String[] args) {
        LinkedList<String> strList = new LinkedList<>();
        strList.add("Hemnath");
        strList.add("Jaishankar");
        strList.print();
        System.out.println("Size of list:"+strList.size());
        strList.addFirst("Master");
        strList.print();
        System.out.println(strList.size());

        LinkedList<Integer> intList = new LinkedList<>(new Integer[]{10,11,12,13,14,15});
        intList.add(1);
        intList.print();
        System.out.println("Size of integer list:"+intList.size());
    }
}
