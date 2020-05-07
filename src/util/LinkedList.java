package util;

import java.util.Comparator;
import java.util.StringJoiner;

/**
 * @author Samuel f. Ruiz
 * @version 1.0
 * @since 7/05/20
 */
public abstract class LinkedList<T> {

    protected Node<T> head;
    protected Comparator<T> nodeComparator;

    public LinkedList(Comparator<T> nodeComparator) {
        this.nodeComparator = nodeComparator;
    }

    public abstract void insert(T data);
    public abstract void remove(T data);

    public boolean exist(T data){
        if(!isEmpty()) {
            Node<T> node = head;
            while (node != null && nodeComparator.compare(node.getData(), data) != 0) {
                node = node.getNext();
            }
            return node != null;
        }
        return false;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public String show(){
        if(!isEmpty()) {
            StringJoiner joiner = new StringJoiner(", ");
            Node<T> node = head;
            while (node != null) {
                joiner.add(""+node.getData());
                node = node.getNext();
            }
            return "{"+joiner+"}";
        }
        return "{}";
    }
}
