package edu.ithaca.comp345.Rockstar;

import edu.ithaca.comp345.Rockstar.ui.WaiterGui;

import java.io.IOException;

public class WaiterGUITest {
    public static Restaurant buildBaseRest(){
        Restaurant main= new Restaurant("test.txt");

        main.createTable(1, 10);
        main.createTable(2, 10);
        main.createTable(3, 10);
        main.createTable(4, 10);

        main.stock.addIngredient("ravioli", .50, 200);
        main.stock.addIngredient("chicken", .50, 600);
        main.stock.addIngredient("breadSticks", .50, 350);

        MenuItem item1= new MenuItem("chicken parm", 10);
        item1.addIngredient(main.stock.getIngredient("chicken"), 10);
        MenuItem item2= new MenuItem("cheese ravioli", 10);
        item2.addIngredient(main.stock.getIngredient("ravioli"), 5);
        MenuItem item3= new MenuItem("bread sticks", 10);
        item3.addIngredient(main.stock.getIngredient("breadSticks"), 50);
        MenuItem item4= new MenuItem("coffee", 10);
        MenuItem item5= new MenuItem("chocolate cake", 10);
        MenuItem item6= new MenuItem("beer", 10);

        main.menu.addMenuItem(item1);
        main.menu.addMenuItem(item2);
        main.menu.addMenuItem(item3);
        main.menu.addMenuItem(item4);
        main.menu.addMenuItem(item5);
        main.menu.addMenuItem(item6);

        main.bartender.barStock.addIngredient("tequila", .50, 20);
        main.bartender.barStock.addIngredient("beer", .50, 60);
        main.bartender.barStock.addIngredient("soup", .50, 350);

        main.stock.addIngredient("tequila", .50, 20);
        main.stock.addIngredient("beer", .50, 60);
        main.stock.addIngredient("soup", .50, 350);

        MenuItem item7= new MenuItem("margarita", 10);
        item7.addIngredient(main.bartender.barStock.getIngredient("tequila"), 5);
        MenuItem item8= new MenuItem("red wine", 10);
        MenuItem item9= new MenuItem("soup", 10);
        item9.addIngredient(main.bartender.barStock.getIngredient("soup"), 50);
        MenuItem item10= new MenuItem("coffee", 10);
        MenuItem item11= new MenuItem("mojito", 10);
        MenuItem item12= new MenuItem("beer", 10);
        item12.addIngredient(main.bartender.barStock.getIngredient("beer"), 10);

        main.bartender.barMenu.addMenuItem(item7);
        main.bartender.barMenu.addMenuItem(item8);
        main.bartender.barMenu.addMenuItem(item9);
        main.bartender.barMenu.addMenuItem(item10);
        main.bartender.barMenu.addMenuItem(item11);
        main.bartender.barMenu.addMenuItem(item12);

        main.createBar(50);

        main.manager.addEmployee(1234, "Kaylee", "waiter");
        main.manager.addEmployee(2345, "Julia", "host");
        main.manager.addEmployee(3234, "John", "waiter");
        main.manager.addEmployee(4234, "Priya", "bartender");

        main.manager.addTableToWaiter(1, 1234, "Kaylee");
        main.manager.addTableToWaiter(2, 1234, "Kaylee");
        main.manager.addTableToWaiter(3, 3234, "John");
        main.manager.addTableToWaiter(4, 3234, "John");

        main.waiter.takeOrder("chicken parm", 1, 10);
        main.waiter.takeOrder("chicken parm", 2, 11);

        return main;
    }

    public static void main(String[] args) throws IOException {
        Restaurant main= buildBaseRest();
        Employee test1= main.manager.employees.get(main.manager.findEmployee(1234));
        SwingTestUtil.showPanelInTestFrame(new WaiterGui(main.waiter, test1));
    }
}
