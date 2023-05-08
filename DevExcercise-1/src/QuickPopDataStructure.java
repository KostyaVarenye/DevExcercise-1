import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class QuickPopDataStructure<T extends Comparable<T>> {
    private DoublyLinkedList<T> list;
    private Lock lock;

    public QuickPopDataStructure() {
        list = new DoublyLinkedList<>();
        lock = new ReentrantLock();
    }

    public void push(T value) {
        lock.lock();
        try {
            list.pushBack(value);
        } finally {
            lock.unlock();
        }
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public T pop() {
        lock.lock();
        try {
            if (list.head == null) {
                return null; // Or throw an exception, depending on the desired behavior
            }

            DoublyLinkedList.Node<T> current = list.head;
            DoublyLinkedList.Node<T> maxNode = current;

            while (current.next != null) {
                current = current.next;
                if (current.data.compareTo(maxNode.data) > 0) {
                    maxNode = current;
                }
            }

            if (maxNode == list.head) {
                list.head = list.head.next;
                if (list.head != null) {
                    list.head.prev = null;
                }
            } else if (maxNode == list.tail.prev) {
                list.popBack();
            } else {
                maxNode.prev.next = maxNode.next;
                maxNode.next.prev = maxNode.prev;
            }

            return maxNode.data;
        } finally {
            lock.unlock();
        }
    }
}
