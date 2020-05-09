package models;

import util.DoublyLinkedList;

import java.util.ArrayList;

/**
 * @author Samuel f. Ruiz
 * @version 1.0
 * @since 7/05/20
 */
public class Warehouse {

    private String name, address;
    private DoublyLinkedList<Item> inventory;

    public Warehouse(String name, String address) {
        this.name = name;
        this.address = address;
        inventory = new DoublyLinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void addItem(Item item){
        if(item != null) inventory.insert(item);
    }

    public Item getItem(String id){
        return inventory.getData(
                item -> item.getId().equals(id)
        );
    }

    public int getItemsQuantity(){
        return inventory.size();
    }

    public double calculateInventoryValue(){
        ArrayList<Double> list = inventory.getFromAll(
                item -> item.getCost() * item.getQuantity()
        );
        double totalCost = 0;
        if (list != null){
            for (double data: list){
                totalCost += data;
            }
        }
        return totalCost;
    }

    public void registryItem(String id, int quantity){
        Item item = this.getItem(id);
        if(item != null) item.add(quantity);
    }

    public void registrySold(String id, int quantity){
        Item item = this.getItem(id);
        if (item != null) item.add(-quantity);
    }
}
