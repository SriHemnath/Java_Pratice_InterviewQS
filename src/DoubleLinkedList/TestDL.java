package DoubleLinkedList;

public class TestDL {
    public static void main(String[] args) {
        DoubleLinkedList<String> dl = new DoubleLinkedList<String>();
        dl.add("Hemnath");
        dl.add("Karthick");
        dl.add("Jack");
        dl.print();
        dl.printReverse();
    }
}
