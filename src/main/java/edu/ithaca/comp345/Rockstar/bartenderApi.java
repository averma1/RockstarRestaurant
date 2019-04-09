package edu.ithaca.comp345.Rockstar;


public class bartenderApi extends waiterApi{
    public int seats;
    public static int bar;
    public Stock stock;
    //public Menu menu;

    public bartenderApi(){
        seats= 0;
        bar= 0;
        stock= null;
        //menu= null;
    }

    public void createOrder(int orderNum, MenuItem item){
        Table barTable= allTables.get(findTable(bar));
        barTable.createOrder(orderNum);
        barTable.addtoOrder(item,orderNum);
    }

    public void addToOrder(int orderNum, MenuItem item){
        Table barTable= allTables.get(findTable(bar));
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
