package util;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author Samuel f. Ruiz
 * @version 1.0
 * @since 7/05/20
 */
public class SimpleLinkedList<T> extends LinkedList<T>{

    @Override
    public void insert(T data){
        Objects.requireNonNull(data);
        if(head == null){
            head = new Node<>(data);
        }else {
            Node<T> node = head;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(new Node<>(data));
        }
    }

    @Override
    public void remove(Predicate<T> finder){
        if(!isEmpty()) {
            if(finder.test(head.getData())){
                head = head.getNext();
            }else {
                Node<T> previous = head;
                Node<T> actual = head.getNext();
                while (actual != null && !finder.test(actual.getData())) {
                    previous = actual;
                    actual = actual.getNext();
                }
                if(actual != null) previous.setNext(actual.getNext());
            }
        }
    }
}
