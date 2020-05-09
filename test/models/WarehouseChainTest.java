package models;

import org.junit.jupiter.api.Test;
import util.SimpleLinkedList;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseChainTest {

    WarehouseChain warehouseChain = new WarehouseChain();
    SimpleLinkedList<Warehouse> warehouses;

    public WarehouseChainTest() throws NoSuchFieldException, IllegalAccessException {
        Field field = WarehouseChain.class.getDeclaredField("warehouses");
        field.setAccessible(true);
        warehouses = (SimpleLinkedList<Warehouse>) field.get(warehouseChain);
    }

    @Test
    void createWarehouse() {
        System.out.println(warehouses.show());
        warehouseChain.createWarehouse("rockport","1937-as");
        System.out.println(warehouses.show());
        warehouseChain.createWarehouse("rockport","1937-as");
        System.out.println(warehouses.show());
        warehouseChain.createWarehouse(null, null);
        System.out.println(warehouses.show());
    }

    @Test
    void calculateChaneValue() {
        warehouseChain.createWarehouse("rockport","123");
        warehouseChain.createWarehouse("rosewood","1234");
        warehouseChain.createWarehouse("cammdel","1235");
        assertEquals(0, warehouseChain.calculateChaneValue());
        warehouseChain.getWarehouse("rockport").addItem(new Item("a","1",10,100));
        assertEquals(1000, warehouseChain.calculateChaneValue());
        warehouseChain.getWarehouse("rosewood").addItem(new Item("a","1",10,100));
        warehouseChain.getWarehouse("cammdel").addItem(new Item("a","1",10,100));
        assertEquals(3000, warehouseChain.calculateChaneValue());
    }

    @Test
    void getWarehouse() {

    }
}