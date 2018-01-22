public interface Stack<E> {

    /**
     * This method pushes a new element (@param newElement) into the stack.
     */
    void push (E newElement) throws FullStackException;

    /**
     * Returns the last element pushed into the stack and removes it from the stack.
     */
    E pop();

    /**
     * Returns the last element pushed into the stack.
     */
    E peek();

    /**
     * Increases the maximum size of the stack by (@param additionalSize).
     */
    void grow(int additionalSize);

    /**
     * Checks if the stack is empty.
     */
    Boolean isEmpty();

    /**
     * Checks if the stack is full.
     */
    Boolean isFull();

    /**
     * Returns the current number of elements in the stack.
     */
    int getSize();

    /**
     * Returns the maximum number of elements in the stack.
     */
    int getMaximumSize();
}
