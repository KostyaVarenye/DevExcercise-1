import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class QuickPushDataStructureMTTest {
    @Test
    public void testQuickPushDataStructureMultiThreaded() throws InterruptedException {
        QuickPushDataStructure<Person> q = new QuickPushDataStructure<>();

        List<Person> people = Arrays.asList(
                new Person("Alice", 35),
                new Person("Bob", 28),
                new Person("Charlie", 42),
                new Person("David", 50),
                new Person("Eve", 19),
                new Person("Frank", 29),
                new Person("Grace", 31),
                new Person("Heidi", 45),
                new Person("Ivan", 23),
                new Person("Judy", 60),
                new Person("Kevin", 32),
                new Person("Linda", 37),
                new Person("Mike", 25),
                new Person("Nancy", 51),
                new Person("Oscar", 40)
        );

        int numThreads = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        Runnable task = () -> {
            for (Person person : people) {
                q.push(person);
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < numThreads; i++) {
            executorService.submit(task);
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        Person prevPerson = null;
        while (!q.isEmpty()) {
            Person person = q.pop();
            System.out.println(person);
            if (prevPerson != null) {
                assertTrue(prevPerson.compareTo(person) >= 0);
            }
            prevPerson = person;
        }
    }
}
