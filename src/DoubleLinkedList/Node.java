package DoubleLinkedList;

public class Node<T> {
     T data;
     Node<T> prev;
     Node<T> next;

     Node(){}

    Node(T data){
         this.data = data;
         this.prev = null;
         this.next = null;
    }
}
