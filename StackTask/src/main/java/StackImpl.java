import java.util.EmptyStackException;

public class StackImpl<E> implements Stack<E> {

    private E[] elements;
    private int size;

    public StackImpl(int maxSize){
        elements = (E[]) new Object[maxSize];
        size = 0;
    }

    @Override
    public synchronized void push(E newElement) throws FullStackException {
        try {
            elements[size++] = newElement;
        } catch (Exception ex){
            throw new FullStackException("Unable to push new element, stack is full!");
        }
    }

    @Override
    public synchronized E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E lastElement = elements[--size];
        elements[size] = null;
        return lastElement;
    }

    @Override
    public synchronized E peek() {
        if (size == 0){
            throw new EmptyStackException();
        }
        return elements[size - 1];
    }

    @Override
    public synchronized void grow(int additionalSize) {
       E[] updatedStack = (E[]) new Object[elements.length + additionalSize];
       for(int i = 0; i<size; i++){
           updatedStack[i] = elements[i];
        }
        elements = updatedStack;
    }


    @Override
    public synchronized Boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public synchronized Boolean isFull() {
        return (elements.length == size);
    }

    @Override
    public synchronized int getSize() {
        return size;
    }

    @Override
    public synchronized int getMaximumSize(){
        return elements.length;
    }
}
