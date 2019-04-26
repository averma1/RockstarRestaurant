package edu.ithaca.comp345.Rockstar;


import java.util.List;

public class BartenderApi extends waiterApi{
    public int seats;
    public static int bar;
    public Stock barStock;
    public Menu barMenu;

    public BartenderApi(){
        seats= 0;
        bar= 0;
        barStock= new Stock();
        barMenu= new Menu("bar", barStock);

    }

    /**
     * adds an item to a given order
     * @param orderNum
     * @param item item to add
     */
    public void addToOrder(int orderNum, String item){
        Table barTable= allTables.get(findTable(bar));
        if(barTable.findOrder(orderNum)==-1){
            barTable.createOrder(orderNum);
        }
        MenuItem Item= barMenu.getMenuItem(item);
        if(barStock!=null) {
            barStock.removeMenuItem(Item);
        }
        barTable.addtoOrder(Item, orderNum);
    }

    /**
     * allows the user to pay
     * @param orderNum
     * @return: price to pay
     */
    public double pay(int orderNum){
        Table barTable= allTables.get(findTable(bar));
        double price= barTable.getOrderPrice(orderNum);
        barTable.removeOrder(orderNum);
        int current= barTable.getFilledSeats();
        barTable.setFilledSeats(current-1);
        return price;
    }

    public static void setSeats(int seats){
        Table barTable= allTables.get(findTable(bar));
        barTable.setNumOfSeats(seats);
    }

    public static void setBar(int barIn){
        bar=barIn;
    }

    public static int getSeats(){
        Table barTable= allTables.get(findTable(bar));
        return barTable.getNumOfSeats();
    }

    public int getBar(){
        return bar;
    }

    public void seatAtBar(){
        Table barTable= allTables.get(findTable(bar));
        int currentSeats= barTable.getFilledSeats();
        barTable.setNumOfSeatsFilled(currentSeats+1);
    }

    public int seeFilledSeats(){
        Table barTable= allTables.get(findTable(bar));
        return barTable.getFilledSeats();
    }

    public List<Order> getOrders(){
        Table barTable= allTables.get(findTable(bar));
        return barTable.orders;
    }
}
