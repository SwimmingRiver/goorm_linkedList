public class MyStack<T> {
    private MyLinkedList<T> list;
    public MyStack(){
        list = new MyLinkedList<>();
    }
    public void push(T data){
        list.add(data);
    }
    public T pop(){
        if(list.isEmpty()){
            throw new IllegalStateException("stack is null");
        }
        int lastIndex = list.size() - 1;
        T data = list.get(lastIndex);
        list.delete(lastIndex);
        return data;
    }
    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        
    }
}
