import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.EmptyStackException;

@RunWith(JUnit4.class)
public class StackImplTest {

    private Stack stack;

    @Before
    public void setUp() throws Exception {
        stack = new StackImpl(2);
    }

    @Test
    public void testPushMethodWhenStackIsNotFull() throws Exception {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek());
    }

    @Test(expected = FullStackException.class)
    public void testPushMethodWhenStackIsFull_ShouldThrowException() throws Exception {
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    public void testPopMethodWhenStackIsNotEmpty() throws Exception {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test(expected = EmptyStackException.class)
    public void testPopMethodWhenStackIsEmpty_ShouldThrowException() throws Exception {
        stack.push(1);
        stack.pop();
        stack.pop();
    }

    @Test
    public void testPeekMethodWhenStackIsNotEmpty() throws Exception {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek());
        assertEquals(2, stack.peek());
    }

    @Test(expected = EmptyStackException.class)
    public void testPeekMethodWhenStackIsEmpty_ShouldThrowException() throws Exception {
        stack.peek();
    }

    @Test
    public void testGrowMethod() throws Exception {
        stack.grow(3);
        assertEquals(5, stack.getMaximumSize());
    }

    @Test
    public void testIsEmptyMethodWhenStackIsEmpty() throws Exception {
        stack.push(1);
        stack.pop();
        assertEquals(true, stack.isEmpty());
    }

    @Test
    public void testIsEmptyMethodWhenStackIsNotEmpty() throws Exception {
        stack.push(1);
        assertEquals(false, stack.isEmpty());
    }

    @Test
    public void testIsFullMethodWhenStackIsFull() throws Exception {
        stack.push(1);
        stack.push(2);
        assertEquals(true, stack.isFull());
    }

    @Test
    public void testIsFullMethodWhenStackIsNotFull() throws Exception {
        stack.push(1);
        assertEquals(false, stack.isFull());
    }

    @Test
    public void testGetSizeMethod() throws Exception {
        stack.push(1);
        assertEquals(1, stack.getSize());
    }

    @Test
    public void testGetMaximumSizeMethod() throws Exception {
        stack.push(1);
        assertEquals(2, stack.getMaximumSize());
    }
}