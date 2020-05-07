package util;

import java.util.Comparator;

/**
 * @author Samuel f. Ruiz
 * @version 1.0
 * @since 7/05/20
 */
public class DoublyLinkedList<T> extends LinkedList<T>{

    public DoublyLinkedList(Comparator<T> nodeComparator) {
        super(nodeComparator);
    }

    @Override
    public void insert(T data) {
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
    }

    @Override
    public void remove(T data) {
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
