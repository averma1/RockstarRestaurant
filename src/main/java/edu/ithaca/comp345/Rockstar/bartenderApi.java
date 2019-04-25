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

    /**
     * adds an item to a given order
     * @param orderNum
     * @param item item to add
     */
    public void addToOrder(int orderNum, MenuItem item){
        Table barTable= allTables.get(findTable(bar));
        if(barTable.findOrder(orderNum)==-1){
            barTable.createOrder(orderNum);
        }
        if(barStock!=null) {
            barStock.removeMenuItem(item);
        }
        barTable.addtoOrder(item, orderNum);
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

    public void seatAtBar(int numOfPeople){
        Table barTable= allTables.get(findTable(bar));
        int currentSeats= barTable.getFilledSeats();
        barTable.setNumOfSeats(currentSeats+numOfPeople);
    }

    public int seeFilledSeats(){
        Table barTable= allTables.get(findTable(bar));
        return barTable.getFilledSeats();
    }
}
