package util;

import java.util.Comparator;

/**
 * @author Samuel f. Ruiz
 * @version 1.0
 * @since 7/05/20
 */
public class SimpleLinkedList<T> extends LinkedList<T>{

    public SimpleLinkedList(Comparator<T> nodeComparator) {
        super(nodeComparator);
    }

    @Override
    public void insert(T data){
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
    public void remove(T data){
        if(!isEmpty()) {
            if(nodeComparator.compare(head.getData(), data) == 0){
                head = head.getNext();
            }else {
                Node<T> previous = head;
                Node<T> actual = head.getNext();
                while (actual != null && nodeComparator.compare(actual.getData(), data) != 0) {
                    previous = actual;
                    actual = actual.getNext();
                }
                if(actual != null) previous.setNext(actual.getNext());
            }
        }
    }
}
