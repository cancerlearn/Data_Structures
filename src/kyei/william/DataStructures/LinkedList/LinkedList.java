/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kyei.william.DataStructures.LinkedList;

/**
 *
 * @author Albert Kyei
 */
public class LinkedList <T> {
    
    private Node head;
    
    private class Node <T>{
        private T data;
        private Node next;
        
        public Node(T data){
            this.data = data;
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
        
        public Node getNext(){
            return this.next;
        }
    }
    
    public void add(T element){}
    
    public void addFirst(T element){}
    
    public void addLast(T element){}
    
    public void remove(T element){}
    
    public void removeFirst(){}
    
    public void removeLast(){}
    
    private void insertBetween(Node prev, Node next){}
    
}
