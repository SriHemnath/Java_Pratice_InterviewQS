package LinkedList;

public class LinkedList {
    
    private Node head;
    private int size=0;

    LinkedList(){}

    LinkedList(int[] values){
        for (int value : values) {
            add(value);
        }
        this.size = values.length;
    }

    //add element
    public void add(int data){
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            size = 1;
            return;
        }

        //iterate through list until reaching last node
        Node current = head;
        while(current.next != null)
            current = current.next;
        current.next = newNode;
        size++;
    }

    //remove element
    public boolean remove(int data){
        if(head == null)
            return false;
        
        if (head.data == data){
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
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
        Node current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;    
        size++;
    }

    public int size(){
        return size;
    }
}
