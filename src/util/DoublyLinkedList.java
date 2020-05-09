package util;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author Samuel f. Ruiz
 * @version 1.0
 * @since 7/05/20
 */
public class DoublyLinkedList<T> extends LinkedList<T>{

    @Override
    public void insert(T data) {
        Objects.requireNonNull(data);
        Node<T> newNode = new Node<>(data);
        if(isEmpty()){
            head = newNode;
        }else {
            Node<T> node = head;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(newNode);
            newNode.setPrevious(node);
        }
        this.size++;
    }

    @Override
    public void remove(Predicate<T> finder) {
        if(!isEmpty()) {
            if(finder.test(head.getData())){
                head = head.getNext();
                head.setPrevious(null);
                size--;
            }else {
                Node<T> actual = head.getNext();
                while (actual != null && !finder.test(actual.getData())) {
                    actual = actual.getNext();
                }
                if(actual != null) {
                    actual.getNext().setPrevious(actual.getPrevious());
                    actual.getPrevious().setNext(actual.getNext());
                    size--;
                }
            }
        }
    }
}
