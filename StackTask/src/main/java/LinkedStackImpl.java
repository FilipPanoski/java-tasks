import java.util.EmptyStackException;

public class LinkedStackImpl<E> implements Stack {

    private LinkedStackNode<E> top;
    private int size;

    public LinkedStackImpl(){
        top = null;
    }

    @Override
    public synchronized void push(Object newElement) {
        top = new LinkedStackNode<E>((E) newElement, top);
        size++;
    }

    @Override
    public synchronized E pop() {
        if (top == null){
            throw new EmptyStackException();
        }
        E lastElement = top.element;
        top = top.successor;
        size--;
        return lastElement;
    }

    @Override
    public synchronized E peek() {
        if (top == null){
            throw new EmptyStackException();
        }
        return top.element;
    }

    @Override
    public synchronized Boolean isEmpty() {
        return (top == null);
    }

    @Override
    public synchronized int getSize() {
        return size;
    }


    /**
     * This method is redundant for a LinkedStack implementation.
     */
    @Override
    public void grow(int additionalSize) {

    }

    /**
     * This method is redundant for a LinkedStack implementation.
     */
    @Override
    public Boolean isFull() {
        return null;
    }

    /**
     * This method is redundant for a LinkedStack implementation.
     */
    @Override
    public int getMaximumSize() {
        return 0;
    }
}
