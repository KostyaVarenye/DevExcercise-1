import org.junit.jupiter.api.Test;

public class DoublyLinkedList<T> {
    private static class Node <T>{
        private Node<T> prev;
        private Node<T> next;
        T data;

        private Node(T value){
            prev = null;
            next = null;
            data = value;
        }
        private Node<T> createNewNode(Node<T> prev, Node<T> next, T value){
            Node<T> newNode = new Node<>(value);
            newNode.prev = prev;
            newNode.next = next;

            return newNode;
        }
        private T getData(Node<T> node){
            return node.data;
        }
    }

    private Node<T> head = null;
    private Node<T> tail = null;
    public DoublyLinkedList(){
        tail = new Node<>(null);
        head = tail;
    }

    public void pushFront(T value){
        if(head == tail){
            head = new Node<>(value);
            tail.prev = head;
        } else {
            head = head.createNewNode(null, head, value);
        }
    }

    public void insertAfter(Node<T> node, T value) {
        Node<T> newNode = new Node<>(value);
        newNode.prev = node;
        newNode.next = node.next;
        node.next = newNode;
        if (newNode.next != null) {
            newNode.next.prev = newNode;
        } else {
            tail.prev = newNode;
        }
    }

    public void pushBack(T value){
        if (tail.prev == null) {
            // Special case when the list is empty
            tail.prev = new Node<>(value);
            head = tail.prev;
        } else {
            tail.prev.next = tail.createNewNode(tail.prev, tail, value);
            tail.prev = tail.prev.next;
        }
    }

    public boolean isEmpty(){
        return head.equals(tail);
    }

    public T peekFront(){
        return head.data;
    }
    public T peekBack(){
        return tail.prev.data;
    }

    public void popBack() {
        if (tail.prev != null) {
            tail.prev = tail.prev.prev;
            if (tail.prev != null) {
                tail.prev.next = tail;
            } else {
                head = tail;
            }
        }
    }

    public int size(){
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }


    @Test
    void testPrintList(){
        DoublyLinkedList<String> dls = new DoublyLinkedList<>();
        String hello = "Hello";
        String a = "A";
        String b = "B";
        String c = "C";
        dls.pushBack(hello);
        dls.pushBack(a);
        dls.pushBack(b);
        dls.pushBack(c);

        // Print the doubly linked list
        DoublyLinkedList.Node<String> current = dls.head;
        while (current.next != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.print(current.data + "\n");
    }
}

