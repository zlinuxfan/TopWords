import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StatusTest {
    private final Status status = new Status();
    private final Status status2 = new Status();

    @Test
    void increment() {
        assertEquals(2, status.increment().getCounter());
    }

    @Test
    void getCounter() {
        assertEquals(1, status.getCounter());
    }

    @Test
    void testEquals() {
        assertEquals(new Status(), new Status());
        assertEquals(new Status().increment(), new Status().increment());
        assertEquals(status.increment().increment(), status2.increment().increment());
    }
}