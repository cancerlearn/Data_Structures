/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kyei.william.DataStructures.DoublyLinkedList;

import java.util.Objects;

/**
 *
 * @author Albert Kyei
 */
public class DoublyLinkedList <T> {
    
    private int size = 0;
    private Node <T> head = null;
    private Node <T> tail = null;
    
    private class Node <T>{
        private T data;
        private Node <T> next;
        private Node <T> prev;
        
        public Node(){}
        
        public Node(T data, Node <T> prev, Node <T> next){
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
            if (!Objects.equals(this.prev, other.prev)) {
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
        
        public void setPrev(Node prev_node){
            this.prev = prev_node;
        }
        
        public Node <T> getPrev(){
            return this.prev;
        }
        
        public void setNext(Node next_node){
            this.next = next_node;
        }
        
        public Node <T> getNext(){
            return this.next;
        }
    }
    
    public int size(){return size;}
    
    public boolean isEmpty(){return size() == 0;}
    
    public void add(T element){addLast(element);}
    
    public void addFirst(T element){
        Node <T> temp = new Node(element, null, null);
        if (head == null) head = tail = temp;
        else{
            temp.setNext(head);
            head.setPrev(temp);
            head = temp;
        }
        size++;
    }
    
    public void addLast(T element){
        Node <T> temp = new Node(element, null, null);
        if (head == null) head = tail = temp;
        else{
            temp.setPrev(tail);
            tail.setNext(temp);
            tail = temp;
        }
        size++;
    }
    
    public T removeFirst(){
        if (isEmpty()) throw new RuntimeException("Empty List");
        
        T first = head.getData();
        head = head.getNext();
        --size;
        
        if (isEmpty()) tail = null;
        else {
            head.getPrev().setNext(null);
            head.setPrev(null);
        }
        
        return first;
    }
    
    public T removeLast(){
        if (isEmpty()) throw new RuntimeException("Empty List");
        
        T last = tail.getData();
        tail = tail.getPrev();
        --size;
        
        if (isEmpty()) tail = null;
        else {
            tail.getNext().setPrev(null);
            tail.setNext(null);
        }
        
        return last;
    }
    
    private T remove (Node <T> node){
        T removed = node.getData();
        
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        
        node.setPrev(null);
        node.setNext(null);
        node.setData(null);
        
        return removed;
    }
    
    //remove a particular value
    public boolean remove(Object obj){
        
        Node <T> trav;
        
        if (obj == null){ //searching for null
            for (trav = head; trav != null; trav = trav.getNext()){
                if (trav.data == null) {
                    remove(trav);
                    return true;
                }
            }
        }
        else { //searching for an actual (non-null) value
            for (trav = head; trav != null; trav = trav.getNext()){
                if (trav.data.equals(obj)){
                    remove(trav);
                    return true;
                }
            }
        }
     
        return false;
    }
    
    public T removeAt(int position){
        if (isEmpty()) throw new RuntimeException("Empty List");
        if (position < 0 || position > size-1) throw new IndexOutOfBoundsException("Illegal Position(Index): " + position);
        if (position == 0) return removeFirst();
        if (position == size-1) return removeLast();
        
        Node <T> trav;
        int i;
        
        if (position < size/2){
            for (i = 0, trav = head; i != position; i++){
            trav = trav.getNext();
            }
        }
        else{
            for (i = size-1, trav = tail; i != position; i--){
            trav = trav.getPrev();
            }
        }
        
        --size;
        return remove(trav);
    }
    
    public T peekFirst(){
        if (isEmpty()) throw new RuntimeException("Empty List");
        return head.getData();
    }
    
    public T peekLast(){
        if (isEmpty()) throw new RuntimeException("Empty List");
        return tail.getData();
    }
    
    //Index of a particular value in the linked list; O(n)
    public int indexOf(Object obj){
        
        Node <T> trav;
        int index = 0;
        
        //Searching for null
        if (obj == null){
            for (trav = head; trav != null; trav = trav.getNext(), ++index){
                if (trav.getData() == null){
                    return index;
                }
            }
        }
        //Searching for a non-null value
        else {
            for (trav = head; trav != null; trav = trav.getNext(), ++index){
                if (trav.getData().equals(obj)){
                    return index;
                }
            }
        }
        
        return -1;
    }
    
    public boolean contains(Object obj){return indexOf(obj) != -1;}
    
    @Override public String toString(){
        StringBuilder sb = new StringBuilder("[");
        
        Node <T> trav;
        for(trav = head; !trav.equals(tail); trav = trav.getNext()){
            sb.append(trav.getData() + ", ");
        }
        
        sb.append(trav.getData() + "]");
        
        return sb.toString();
    }
}
