package models;

import util.SimpleLinkedList;

import java.util.ArrayList;

/**
 * @author Samuel f. Ruiz
 * @version 1.0
 * @since 7/05/20
 */
public class WarehouseChain {

    private SimpleLinkedList<Warehouse> warehouses;

    public void createWarehouse(String name, String address){
        warehouses.insert(new Warehouse(name, address));
    }

    public double calculateChaneValue(){
        ArrayList<Double> list = warehouses.getFromAll(
                Warehouse::calculateInventoryValue
        );
        int totalValue = 0;
        if (list != null){
            for (double inventoryValue: list){
                totalValue += inventoryValue;
            }
        }
        return totalValue;
    }

    public Warehouse getWarehouse(String name){
        return warehouses.getData(
                warehouse -> warehouse.getName().equals(name)
        );
    }
}
