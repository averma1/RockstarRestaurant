package edu.ithaca.comp345.Rockstar;


public class bartenderApi extends waiterApi{
    public int seats;
    public static int bar;
    public Stock barStock;
    public Menu barMenu;

    public bartenderApi(){
        seats= 0;
        bar= 0;
        barStock= new Stock();
        barMenu= new Menu("bar", barStock);
    }

    public void addToOrder(int orderNum, MenuItem item){
        Table barTable= allTables.get(findTable(bar));
        if(barTable.findOrder(orderNum)==-1){
            barTable.createOrder(orderNum);
        }
        if(barStock!=null) {
            barStock.removeMenuItem(item);
        }
        barTable.addtoOrder(item,orderNum);
    }

    public double pay(int orderNum){
        Table barTable= allTables.get(findTable(bar));
        double price= barTable.getOrderPrice(orderNum);
        barTable.removeOrder(orderNum);
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
}
