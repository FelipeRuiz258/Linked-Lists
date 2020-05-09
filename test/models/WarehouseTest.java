package models;

import org.junit.jupiter.api.Test;
import util.DoublyLinkedList;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {

    public Warehouse warehouse = new Warehouse("casa", "calle 2");
    public DoublyLinkedList<Item> inventory;

    public WarehouseTest() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Field field = warehouse.getClass().getDeclaredField("inventory");
        field.setAccessible(true);
        inventory = (DoublyLinkedList<Item>) field.get(warehouse);
        Method method = warehouse.getClass().getMethod("getName");
        method.setAccessible(true);
        String name = (String) method.invoke(warehouse);
        testAddItem();
    }

    public void reset(){
        warehouse = new Warehouse("casa", "calle 2");
    }

    @Test
    public void testAddItem(){
        warehouse.addItem(new Item("clorox", "l1", 2, 2000));
        warehouse.addItem(new Item("libro", "l2", 20, 1000));
        warehouse.addItem(new Item("arroz", "l3", 20, 1000));
        warehouse.addItem(null);
        //System.out.println(inventory.show());
    }

    @Test
    void getItem() {
        testAddItem();
        System.out.println(warehouse.getItem("l1").toString());
        System.out.println(warehouse.getItem("l2").toString());
        System.out.println(warehouse.getItem("l3").toString());
        System.out.println(warehouse.getItem("l3").toString());
        assertNull(warehouse.getItem("l4"));
    }

    @Test
    void getItemsQuantity() {
        assertEquals(0, warehouse.getItemsQuantity());
        testAddItem();
        assertEquals(3, warehouse.getItemsQuantity());
        testAddItem();
        assertEquals(6, warehouse.getItemsQuantity());
    }

    @Test
    void calculateInventoryValue() {
        assertEquals(0, warehouse.calculateInventoryValue());
        testAddItem();
        assertEquals(44000, warehouse.calculateInventoryValue());
        testAddItem();
        assertEquals(88000, warehouse.calculateInventoryValue());
    }

    @Test
    void registryItem() {
        System.out.println(inventory.show());
        warehouse.registryItem("l2",31);
        System.out.println(inventory.show());
        warehouse.addItem(new Item("arroz","l1", 0,2000));
        System.out.println(inventory.show());
        warehouse.registryItem("l2",31);
        System.out.println(inventory.show());
        warehouse.registryItem("l1",31);
        System.out.println(inventory.show());
    }

    @Test
    void registrySold() {
        testAddItem();
        System.out.println(inventory.show());
        warehouse.registrySold("l4",31);
        System.out.println(inventory.show());
        warehouse.registrySold("l1",31);
        System.out.println(inventory.show());
    }
}