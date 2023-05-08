import org.junit.jupiter.api.Test;

public class DoublyLinkedList<T> {
    static class Node<T> {
        Node<T> prev;
        Node<T> next;
        T data;

        Node(T value) {
            prev = null;
            next = null;
            data = value;
        }
    }

    Node<T> head = null;
    Node<T> tail = null;

    public DoublyLinkedList() {
    }

    public void pushFront(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
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
            tail = newNode;
        }
    }

    public void pushBack(T value) {
        Node<T> newNode = new Node<>(value);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T peekFront() {
        return head.data;
    }

    public T peekBack() {
        return tail.data;
    }

    public void popBack() {
        if (tail != null) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
        }
    }

    public int size() {
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

