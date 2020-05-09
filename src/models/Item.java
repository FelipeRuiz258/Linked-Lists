package models;

/**
 * @author Samuel f. Ruiz
 * @version 1.0
 * @since 7/05/20
 */
public class Item {

    private String name, id;
    private int quantity;
    private double cost;

    public Item(String name, String id, int quantity, double cost) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public double getCost() {
        return cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void add(int quantity){
        this.quantity += quantity;
    }

    @Override
    public String toString() {
        return "{" +
                "name= '" + name + '\'' +
                ", id= '" + id + '\'' +
                ", quantity= " + quantity +
                ", cost= " + cost +
                '}';
    }
}
