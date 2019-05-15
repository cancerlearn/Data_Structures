package kyei.william.DataStructures.Array;

/**
 *
 * @author Albert Kyei
 */
public class DynamicArray <T> {
    
    private int capacity;
    private int length;
    private T [] arr;
    
    public DynamicArray(){this(20);}
    
    public DynamicArray(int cap){
        
        if (cap < 0) throw new IllegalArgumentException("Capacity of array cannot be less than or equal to zero. Illegal Capacity: " + cap);
        this.capacity = cap;
        arr = (T[]) new Object[cap];
    
    }
    
    public int size(){return this.length;}
    
    public boolean isEmpty(){return size() == 0;}
    
    public T get(int index){
        if (index < 0 || index > capacity-1) throw new IndexOutOfBoundsException("Illegal Index: " + index);
        return arr[index];
    }
    
    public void set(int index, T element){
        if (index < 0 || index > capacity-1) throw new IndexOutOfBoundsException("Illegal Index: " + index);
        arr[index] = element;
    }
    
    public void clear(){
    
        for(int i = 0; i < length; i++){
            arr[i] = null;
        }
        length = 0;
    }
    
    public void add(T element){
    
        if (length+1 >= capacity){
            
            if (capacity == 0) capacity = 1;
            else capacity *= 2;
            
            T[] temp = (T[]) new Object[capacity];

            int i = 0;
            for(T elem: arr){
                temp[i] = elem;
                ++i;
            }
            arr = temp;
        }
        
        arr[length++] = element;
    
    }
    
    public T removeAt(int index){
    
        T removed = arr[index];
        
        if (length == 0 || index < 0 || index > length) throw new IndexOutOfBoundsException("Illegal Index: " + index);
        
        for (int i = index; i < length;  i++){
            
            arr[i] = arr[++i];
            
        }
        
        arr[--length] = null;
        
        return removed;
    
    }
    
    public boolean remove(Object obj){
        int index = indexOf(obj);
        
        if (index == -1) return false;
        
        removeAt(index);
        return true;
    }
    
    public int indexOf(Object obj){
        
        for(int i = 0; i < length; i++){
            if (obj == null && arr[i] == null) return i;
            else if (arr[i].equals(obj)) return i;
        }
    
        return -1;
    }
    
    public boolean contains(Object obj){
    
        return indexOf(obj) != -1;
    
    }
    
    @Override
    public String toString(){
    
        if (length == 0) return "[]";
        
        StringBuilder sb = new StringBuilder(length).append("[");
        for (int i = 0; i < length-1; i++){
            sb.append(arr[i] + ",");
        }
        return sb.append(arr[length-1] + "]").toString();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
