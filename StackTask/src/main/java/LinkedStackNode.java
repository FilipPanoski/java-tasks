public class LinkedStackNode<E> {

    protected E element;
    protected LinkedStackNode<E> successor;

    public LinkedStackNode(E element, LinkedStackNode<E> successor){
        this.element = element;
        this.successor = successor;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}
