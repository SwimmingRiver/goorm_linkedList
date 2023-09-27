public class MyQueue<T> {
    private MyLinkedList<T> list;
    
    public MyQueue(){
        list = new MyLinkedList<>();
    }
    public void push(T data) {
        list.add(data);
    }
    public T pop() {
        T data = list.get(0);
        list.delete(0);
        return data;
    }
    public static void main(String[] args) {
        
    }

}
