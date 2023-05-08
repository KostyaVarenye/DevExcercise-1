import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class DoublyLinkedListTest {

    private static DoublyLinkedList<String> dls = null;
    private static DoublyLinkedList<Integer> dli = null;

    @BeforeAll
    static void setUp(){
        dls = new DoublyLinkedList<>();
        String hello = "Hello";
        dls.pushBack(hello);

        dli = new DoublyLinkedList<>();
        Integer value = 5;
        dli.pushFront(value);
    }

    @Test
    void testIntegerValues(){
        assertNotNull(dli);
        assertEquals(5, dli.peekFront());
        assertEquals(1, dli.size());
        assertFalse(dli.isEmpty());
    }
    @Test
    void testValueEqual5(){
        DoublyLinkedList<Integer> dli = new DoublyLinkedList<>();
        Integer expected = 5;
        dli.pushFront(expected);

        assertNotNull(dli);
        System.out.println(dli.peekFront());
        assertEquals(5, dli.peekFront());
        assertEquals(1, dli.size());
        assertFalse(dli.isEmpty());
    }

    @Test
    void testValueEqualHello(){
        DoublyLinkedList<String> dls = new DoublyLinkedList<>();
        String hello = "Hello";
        dls.pushBack(hello);
        assertNotNull(dls);
        assertEquals("Hello", dls.peekFront());
        assertEquals(1, dls.size());
    }

}