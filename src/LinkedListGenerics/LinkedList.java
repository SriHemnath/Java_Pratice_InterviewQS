package LinkedListGenerics;

public class LinkedList<T> {
    private Node<T> head;
    private int size=0;

    LinkedList(){}

    LinkedList(T[] values){
        for (T v : values) {
            add(v);
        }
        this.size = values.length;
    }

    public void add(T data){
        Node<T> newNode = new Node<T>(data);

        if (head == null){
            head = newNode;
            size++;
            return;
        }

        Node<T> currentNode = head;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        size++;
    }

    public void addFirst(T data){
        Node<T> newNode = new Node<T>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public boolean remove(T data){
        if(head == null)
            return false;

        Node<T> current = head;
        while(current.next != null){
            if(current.next.data == data){
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
    return false;
    }

    //display elements
    public void print(){
        Node<T> current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public int size(){
        return this.size;
    }
}
