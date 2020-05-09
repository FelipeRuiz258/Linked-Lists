package util;

/**
 * @author Samuel f. Ruiz
 * @version 1.0
 * @since 6/05/20
 */
public class Node<T> {

    private final T data;
    private Node<T> next, previous;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
