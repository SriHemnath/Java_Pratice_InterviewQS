package DoubleLinkedList;

public class TestDL {
    public static void main(String[] args) {
        DoubleLinkedList<String> dl = new DoubleLinkedList<String>();
        dl.add("Hemnath");
        dl.add("Karthick");
        dl.add("Jack");
        dl.print();
        System.out.println("after add first");
        dl.addFirst("Samantha");
        dl.printReverse();

        dl.remove();
        System.out.println("AFTER REMOVING LAST:");
        dl.print();

        dl.removeFirst();
        dl.print();
    }
}
