import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T>{
    private Node<T> head;
    private int size;

    public Iterator<T> iterator(){
        return new LinkedListIterator();
    }
    private class LinkedListIterator implements Iterator<T>{
        private Node<T> current = head;

        public boolean hasNext(){
            return current != null;
        }

        public T next(){
            T data = current.data;
            current = current.next;
            return data;
        }
    }

    private static class Node<T>{
        T data;
        Node<T> next;

        Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    public MyLinkedList(){
        head = null;
        size = 0;
        
    }
    public int size(){
        return size;
    }
    public boolean inEmpty(){
        return size ==0;
    }

   public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void delete(int index){
        if (index == 0) {
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }
    public T get(int index){
        Node<T> current = head;
        for(int i=0;i<index;i++){
            current = current.next;
        }
        return current.data;
    }
    public static void main(String[] args) throws Exception {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("a");
        myLinkedList.add("b");
        myLinkedList.add("c");

        myLinkedList.delete(0);

        for (String data : myLinkedList) {
            System.out.println(data);
        }

       
    }
}
