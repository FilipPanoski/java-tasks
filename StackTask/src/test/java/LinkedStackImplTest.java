import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.EmptyStackException;

@RunWith(JUnit4.class)
public class LinkedStackImplTest {

    private Stack stack;

    @Before
    public void setUp() throws Exception {
        stack = new LinkedStackImpl();
    }

    @Test
    public void testPushMethod() throws Exception {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek());
    }

    @Test
    public void testPopMethodWhenStackIsNotEmpty() throws Exception {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test(expected = EmptyStackException.class)
    public void testPopMethodWhenStackIsEmpty() throws Exception {
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
    public void testPeekMethodWhenStackIsEmpty() throws Exception {
        stack.push(1);
        stack.pop();
        stack.peek();
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
    public void testGetSizeMethodWhenStackHasElements() throws Exception {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.getSize());
    }

    @Test
    public void testGetSizeMethodWhenStackHasNoElements() throws Exception {
        stack.push(1);
        stack.pop();
        assertEquals(0, stack.getSize());
    }
}
