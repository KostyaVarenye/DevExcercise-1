import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class QuickPushDataStructure<T extends Comparable<T>> {
    private DoublyLinkedList<T> list;
    private Lock lock;

    public QuickPushDataStructure() {
        list = new DoublyLinkedList<>();
        lock = new ReentrantLock();
    }

    public void push(T value) {
        lock.lock();
        try {
            DoublyLinkedList.Node<T> current = list.head;

            while (current.next != null && current.next.data.compareTo(value) > 0) {
                current = current.next;
            }

            if (current == list.head) {
                list.pushFront(value);
            } else {
                list.insertAfter(current, value);
            }
        } finally {
            lock.unlock();
        }
    }

    public T pop() {
        lock.lock();
        try {
            T value = list.peekFront();
            list.head = list.head.next;
            if (list.head != null) {
                list.head.prev = null;
            }
            return value;
        } finally {
            lock.unlock();
        }
    }
}
