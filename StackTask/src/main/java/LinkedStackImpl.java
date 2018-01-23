import java.util.EmptyStackException;

public class LinkedStackImpl<E> implements Stack {

    private LinkedStackNode<E> top;
    private int size;
    private int maximumSize;

    public LinkedStackImpl(){
        top = null;
        size = 0;
        maximumSize = 1;
    }

    @Override
    public synchronized void push(Object newElement) {
        top = new LinkedStackNode<E>((E) newElement, top);
        size++;
        maximumSize++;
    }

    @Override
    public synchronized E pop() {
        if (top == null){
            throw new EmptyStackException();
        }
        E lastElement = top.element;
        top = top.successor;
        size--;
        maximumSize--;
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
    public synchronized Boolean isFull() {
        return (size == maximumSize);
    }

    @Override
    public synchronized void grow(int additionalSize) {
        maximumSize += additionalSize;
    }

    @Override
    public synchronized int getSize() {
        return size;
    }

    @Override
    public synchronized int getMaximumSize() {
        return maximumSize;
    }
}
