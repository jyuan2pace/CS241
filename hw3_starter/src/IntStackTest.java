import org.junit.Test;
import static org.junit.Assert.*;

public class IntStackTest {
    @Test
    public void testPush() {
        IntStack stack = new IntStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(new IntStack(1,2,3), stack);
    }
    @Test
    public void testPopUnderBound() {
        IntStack stack = new IntStack(1);
        stack.pop();
        try {
            stack.pop();
        } catch (IndexOutOfBoundsException e) {
            assertEquals(new IntStack(), stack);
        }
    }
    @Test
    public void testPop() {
        IntStack stack = new IntStack(3,2,1);
        int x =stack.pop();
        assertEquals(1, x);
    }
    @Test
    public void testPeekOutOfBound() {
        IntStack stack = new IntStack(3,2,1);
        int x =stack.pop();
        assertEquals(1, x);
    }
    @Test
    public void testPeekAt() {
        IntStack stack = new IntStack(4,3,2,1);
        int x =stack.peek_at(3);
        assertEquals(4, x);
    }
}
