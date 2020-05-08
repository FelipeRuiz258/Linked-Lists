package util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author Samuel f. Ruiz
 * @version 1.0
 * @since 7/05/20
 */
public abstract class LinkedList<T> {

    protected Node<T> head;
    protected int size;

    public abstract void insert(T data);
    public abstract void remove(Predicate<T> finder);

    public <V> ArrayList<V> getFromAll(Function<T,V> getter){
        if (!isEmpty()) {
            ArrayList<V> list = new ArrayList<>(size);
            Node<T> node = head;
            while (node != null){
                list.add(getter.apply(node.getData()));
                node = node.getNext();
            }
            return list;
        }
        return null;
    }

    public T getData(Predicate<T> finder){
        if(!isEmpty()){
            Node<T> node = head;
            while (node != null && !finder.test(node.getData())) {
                node = node.getNext();
            }
            return node == null? null: node.getData();
        }
        return null;
    }

    public boolean exist(Predicate<T> finder){
        if(!isEmpty()) {
            Node<T> node = head;
            while (node != null && !finder.test(node.getData())) {
                node = node.getNext();
            }
            return node != null;
        }
        return false;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        return size;
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
