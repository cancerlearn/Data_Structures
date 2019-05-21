/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kyei.william.DataStructures.LinkedList;

import java.util.Objects;

/**
 *
 * @author Albert Kyei
 */
public class LinkedList <T> {
    
    private int size = 0;
    private Node <T> head = null;
    private Node <T> tail = null;
    
    private class Node <T>{
        private T data;
        private Node <T> next;
        
        public Node(){}
        
        public Node(T data, Node <T> next){
            this.data = data;
        }
        
        @Override
        public String toString(){
            return this.data.toString();
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Node<?> other = (Node<?>) obj;
            if (!Objects.equals(this.data, other.data)) {
                return false;
            }
            if (!Objects.equals(this.next, other.next)) {
                return false;
            }
            return true;
        }
        
        public void setData(T node_data){
            this.data = node_data;
        }
        
        public T getData(){
            return this.data;
        }
        
        public void setNext(Node next_node){
            this.next = next_node;
        }
        
        public Node <T> getNext(){
            return this.next;
        }
    }
    
    public LinkedList(){}
    
    public int size(){return size;}
    
    public boolean isEmpty(){return size() == 0;}
    
    public void add(T element){
        addLast(element);
    }
    
    public void addFirst(T element){
        Node <T> temp_newNode = new Node(element, null);
        if (isEmpty()){
            head = tail = temp_newNode;
            size++;
            return;
        }
        temp_newNode.setNext(head);
        head = temp_newNode;
        size++;
    }
    
    public void addLast(T element){
        Node <T> temp_newNode = new Node(element, null);
        if (isEmpty()){
            head = tail = temp_newNode;
            size++;
            return;
        }
        tail.setNext(temp_newNode);
        tail = tail.getNext();
        size++;
    }
    
    public T removeFirst(){
        if (isEmpty()) throw new RuntimeException("Empty List");
        T first = head.getData();
        head = head.getNext();
        
        size--;
        return first;
    }
    
    public T removeLast(){
        if (isEmpty()) throw new RuntimeException("Empty List");
        Node <T> trav = head;
        T last = tail.getData();
        while (!trav.getNext().equals(tail)){
            trav = trav.getNext();
        }
        
        trav.setNext(null);
        tail = trav;
        size--;
        return last;
    }
    
    public T remove(int position){
        if (isEmpty()) throw new RuntimeException("Empty List");
        if (position < 0 || position > size-1) throw new IndexOutOfBoundsException("Illegal Position(Index): " + position);
        if (position == 0) return removeFirst();
        if (position == size-1) return removeLast();
        
        
        Node <T> trav = head;
        Node <T> newNext = null;
        T removed = null;
        
        for (int i = 0; i < position; i++){
            trav = trav.getNext();
        }
        
        newNext = trav.getNext().getNext();
        trav.getNext().setNext(null);
        trav.setNext(newNext);
        
        return removed;
    }
    
    public T searchNodeAt(int position){
        if (position < 0 || position > size-1) throw new IndexOutOfBoundsException("Illegal Position(Index): " + position);
        
        Node <T> trav = head;
        
        for (int i = 0; i < position; i++){
            trav = trav.getNext();
        }
        
        return trav.getData();
    }
    
    @Override public String toString(){
        StringBuilder sb = new StringBuilder("[");
        
        Node <T> trav;
        for(trav = head; !trav.equals(tail); trav = trav.getNext()){
            sb.append(trav.getData() + ", ");
        }
        
        sb.append(trav.getData() + "]");
        
        return sb.toString();
    }
    
    //Testing:
    public static void main(String[] args){
        LinkedList <Integer> ll = new LinkedList();
        
        ll.addLast(2);
        ll.addFirst(34);
        ll.add(13);
        ll.addFirst(90);
        ll.add(44);
        
        System.out.println("List: " + ll.toString());
        System.out.println("remove last: " + ll.removeLast());
        System.out.println("List: " + ll.toString());
        System.out.println("remove first: " + ll.removeFirst());
        System.out.println("List: " + ll.toString());
        System.out.println("remove at index 0: " + ll.remove(0));
        System.out.println("List: " + ll.toString());
        System.out.println("List, search at 1: " + ll.searchNodeAt(1));
        System.out.println("\nList: " + ll.toString() + ", Size: " + ll.size());
    }
}
