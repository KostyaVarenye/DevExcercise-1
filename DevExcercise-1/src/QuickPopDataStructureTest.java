import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuickPopDataStructureTest {
    @Test
    void testQuickPopDataStructure() {
        QuickPopDataStructure<Integer> q = new QuickPopDataStructure<>();
        q.push(3);
        q.push(6);
        q.push(7);
        q.push(2);
        q.push(4);
        Assertions.assertEquals(7, q.pop());
        Assertions.assertEquals(6, q.pop());
        Assertions.assertEquals(4, q.pop());
        Assertions.assertEquals(3, q.pop());
        Assertions.assertEquals(2, q.pop());
    }

}
