package DoubleLinkedList;

public class DoubleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    DoubleLinkedList(){
        head=null;
        tail=null;
        size=0;
    }

    DoubleLinkedList(T[] values){
        for (T value : values) {
            add(value);
        }
    }

    public void add(T value){
        Node<T> newNode = new Node<T>(value);
        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
            this.head.prev = null;
            this.tail.next = null;
            size++;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        tail.next = null;
        size++;
    }

    public void print(){
        Node<T> current = head;
        while (current!=null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void printReverse(){
        Node<T> current = tail;
        while (current!=null){
            System.out.println(current.data);
            current=current.prev;
        }
    }
}
