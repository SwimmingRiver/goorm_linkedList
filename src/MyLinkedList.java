import java.util.Iterator;
import java.util.NoSuchElementException;

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
            if(!hasNext()){
                throw new NoSuchElementException();
            }
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
    public boolean isEmpty(){
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
        if(index < 0 || this.size <= index){throw new IndexOutOfBoundsException();}
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
        if(index < 0 || this.size <= index){throw new IndexOutOfBoundsException();}
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
        //iterator
    MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
            
        System.out.println("Pop: " + myStack.pop());
        System.out.println("Pop: " + myStack.pop());
        //Stack
    MyQueue<String> myQueue = new MyQueue<>();
        myQueue.enqueue("A");
        myQueue.enqueue("B");
        myQueue.enqueue("C");

    System.out.println(myQueue.dequeue());
    System.out.println(myQueue.dequeue());
        //Queue


    }
}
