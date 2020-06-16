package util;

import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.function.Predicate;

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

    /**
     * Crea un arraylist con los datos que se quieren sacar de cada objeto de la lista
     * Ejemplo: si en la lista hay articulos y queremos extraer el id de cada uno
     * el parametro seria una funcion que recibe un Objeto de tipo artículo(T) y retorna el id del articulo(V)
     * @param getter funcion encargada de extraer el atributo o dato de cada uno de los objetos
     * @param <V> Es el tipo de dato que se quiere extraer de cada objeto:
     *            por ejemplo el id de cada item
     * @return una lista con datos extraidos de los objetos
     */
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
