package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InaccessibleObjectException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class managerApiTest {

    @Test
    public void addAndGetIngredientTest(){
        //add Ingredients


        ManagerApi.addIngredient("chicken", 9.50, 30);
        ManagerApi.addIngredient("potatoes", 1.30, 50);
        ManagerApi.addIngredient("onion", 2.00, 20);

        //test getIngredient
        Ingredient testIngredient1 = ManagerApi.getIngredient("chicken");
        Ingredient testIngredient2 = ManagerApi.getIngredient("potatoes");
        Ingredient testIngredient3 = ManagerApi.getIngredient("pickels");

        assertTrue(testIngredient1.getName() == "chicken");
        assertTrue(testIngredient1.getQuantity() == 30);
        assertTrue(testIngredient1.getCost() == 9.5);
    }

    @Test
    public void checkIfAvailableAndRemoveIngredientTest(){
        //add Ingredients
        ManagerApi.addIngredient("chicken", 9.50, 30);
        ManagerApi.addIngredient("potatoes", 1.30, 50);
        ManagerApi.addIngredient("onion", 2.00, 20);

        //check if Available
        assertTrue(ManagerApi.isIngredientAvailable("chicken"));
        assertFalse(ManagerApi.isIngredientAvailable("pickels"));
        //remove Ingredients
        ManagerApi.removeIngredient("chicken");

        //check if Available
        assertFalse(ManagerApi.isIngredientAvailable("chicken"));
    }

    @Test
    public void addEmployeeTest(){
        Restaurant main= new Restaurant("test");
        ManagerApi manager= main.manager;

        List<Integer> pins= new ArrayList<>();
        manager.addEmployee(1234, "Kaylee", "manager");
        pins.add(1234);
        manager.addEmployee(2345, "Julia", "host");
        pins.add(2345);
        manager.addEmployee(3234, "John", "waiter");
        pins.add(3234);
        manager.addEmployee(4234, "Priya", "bartender");
        pins.add(4234);

        for(int i=0; i<manager.employees.size(); i++){
            assertNotEquals(-1, manager.findEmployee(pins.get(i)));
        }

        assertThrows(InaccessibleObjectException.class, ()->{manager.addEmployee(4234, "Alexia", "bartender"); });
        assertThrows(InaccessibleObjectException.class, ()->{manager.addEmployee(42341, "Ben", "bartender"); });
        assertThrows(InaccessibleObjectException.class, ()->{manager.addEmployee(6666, "Lydia", "busboy"); });
        assertThrows(InaccessibleObjectException.class, ()->{manager.addEmployee(423, "Jen", "bartender"); });
    }

    @Test
    public void removeEmployeeTest(){
        Restaurant main= new Restaurant("test");
        ManagerApi manager= main.manager;

        manager.addEmployee(1234, "Kaylee", "manager");
        manager.addEmployee(2345, "Julia", "host");
        manager.addEmployee(3234, "John", "waiter");
        manager.addEmployee(4234, "Priya", "bartender");

        manager.removeEmployee(3234, "John");
        assertEquals(-1, manager.findEmployee(3234));

        manager.removeEmployee(2345, "Julia");
        assertEquals(-1, manager.findEmployee(2345));

        assertThrows(InaccessibleObjectException.class, ()->{manager.removeEmployee(2345, "Julia"); });
    }

    @Test
    public void changeEmployeePinTest(){
        Restaurant main= new Restaurant("test");
        ManagerApi manager= main.manager;

        manager.addEmployee(1234, "Kaylee", "manager");
        manager.changeEmployeePin(1234, 5432);
        Employee test1= manager.employees.get(manager.findEmployee(5432));
        assertEquals(5432, test1.getPin());

        assertThrows(InaccessibleObjectException.class, ()->{manager.changeEmployeePin(5432, 54321); });
    }

    @Test
    public void changeEmployeeTypeTest(){
        Restaurant main= new Restaurant("test");
        ManagerApi manager= main.manager;

        manager.addEmployee(1234, "Kaylee", "manager");
        manager.addEmployee(2345, "Julia", "host");
        manager.changeEmployeeType(1234, "Kaylee", "waiter");
        Employee test1= manager.employees.get(manager.findEmployee(1234));
        assertEquals("waiter", test1.getType());

        assertThrows(InaccessibleObjectException.class, ()->{manager.changeEmployeeType(1234, "Kaylee", "busboy");  });
    }

    @Test
    public void addTableToWaiterTest(){
        Restaurant main= new Restaurant("test");
        ManagerApi manager= main.manager;

        manager.addEmployee(1234, "Kaylee", "waiter");
        manager.addEmployee(3234, "John", "waiter");
        manager.addEmployee(2345, "Julia", "host");

        main.createTable(1, 10);
        main.createTable(2, 10);
        main.createTable(3, 10);
        main.createTable(4, 10);
        main.createTable(5, 10);

        manager.addTableToWaiter(1, 1234, "Kaylee");
        manager.addTableToWaiter(2, 1234, "Kaylee");
        manager.addTableToWaiter(3, 3234, "John");
        manager.addTableToWaiter(4, 3234, "John");

        Employee test1= manager.employees.get(manager.findEmployee(1234));
        Employee test2= manager.employees.get(manager.findEmployee(3234));

        List<Table> table1= new ArrayList<>();
        table1.add(main.allTables.get(main.findTable(1)));
        table1.add(main.allTables.get(main.findTable(2)));
        List<Table> table2= new ArrayList<>();
        table2.add(main.allTables.get(main.findTable(3)));
        table2.add(main.allTables.get(main.findTable(4)));

        assertEquals(table1, main.waiters.get(test1));
        assertEquals(table2, main.waiters.get(test2));

        assertThrows(InaccessibleObjectException.class, ()->{ manager.addTableToWaiter(5, 1237, "Kaylee");});
        assertThrows(InaccessibleObjectException.class, ()->{ manager.addTableToWaiter(5, 2345, "Julia");});

    }
}
