package LinkedList;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.print();
        System.out.println("Size of list: "+list.size());
        System.out.println("\nAdding element to first:");
        list.addFirst(0);
        list.print();
        System.out.println("Size of list: "+list.size());
        System.out.println("After removing one element");
        list.remove(3);
        list.print();
        System.out.println("Size of list: "+list.size());
        
        LinkedList plist = new LinkedList(new int[]{10,11,12,13,14,15});
        plist.print();
        System.out.println("Size of list: "+plist.size());
    }

}
