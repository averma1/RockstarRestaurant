package edu.ithaca.comp345.Rockstar;

import java.lang.reflect.InaccessibleObjectException;
import java.util.ArrayList;
import java.util.List;

public class Table {
    public List<Order> orders= new ArrayList<>();
    private boolean isEmpty;
    private int numOfSeats;
    private int filledSeats;
    private int tableNumber;
    public boolean isMultiTable;

    public Table(){
        this.numOfSeats= 0;
        this.tableNumber= 0;
        isEmpty=true;
        isMultiTable=false;
        filledSeats=0;
    }

    /**
     * creates a table
     * @param tableNumber
     * @param numOfSeats
     */
    public Table(int tableNumber, int numOfSeats){
        this.numOfSeats= numOfSeats;
        this.tableNumber= tableNumber;
        filledSeats=0;
        isEmpty=true;
        isMultiTable=false;
    }

    /**
     * gets the table number
     * @return returns table number
     */
    public int getTableNumber(){
        return this.tableNumber;
    }

    /**
     * sets the table number
     * @param tableNumber: table number to set
     * @return returns table number
     */
    public int setTableNumber(int tableNumber){
        this.tableNumber=tableNumber;
        return this.tableNumber;
    }

    /**
     * gets the number of seats
     * @return returns the number of seats
     */
    public int getNumOfSeats(){
        return this.numOfSeats;
    }

    /**
     * sets the number of sears
     * @param numOfSeats: number of seats to be set
     * @return number of seats
     */
    public int setNumOfSeats(int numOfSeats){
        this.numOfSeats=numOfSeats;
        return this.numOfSeats;
    }

    /**
     * gets the number of seats filled
     * @return returns the number of seats that are filled
     */
    public int getNumOfSeatsFilled(){
        return this.filledSeats;
    }

    /**
     * sets the number of seats that are filled
     * @param numOfSeats: the number of seats that are filled
     * @return returns the number of seats filled
     */
    public int setNumOfSeatsFilled(int numOfSeats){
        this.filledSeats=numOfSeats;
        return this.filledSeats;
    }


    /**
     * sets the table to be no longer empty
     * @return returns that the table is no longer empty
     */
    public void peopleSeated(){isEmpty=false;}


    /**
     * sets the table to be empty
     * @return returns that the table is empty
     */
    public void clearTable(){isEmpty=true;}


    /**
     * checks to see if the table is empty or not
     * @return returns the the table is empty or not
     */
    public boolean isTableEmpty(){ return isEmpty ;}


    /**
     * finds the order
     * @param number: the order number
     * @return index: the index of the order number in the list of orders if found, else -1
     */
    public int findOrder(int number){
        int index=-1;
        for(int i=0; i<orders.size(); i++){
            if(orders.get(i).getNumber()==number){
                index=i;
            }
        }
        return index;
    }


    /**
     * creates an order and adds it to the list of orders
     * @param number: order number
     */
    public void createOrder(int number){
        if(findOrder(number)==-1){
            Order newOrder= new Order(number);
            orders.add(newOrder);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }


    /**
     * adds a MenuItem to the order
     * @param item: the menuItem to be added to the order
     * @param number: the order number
     */
    public void addtoOrder(MenuItem item, int number){

        if(findOrder(number) != -1){
            for(int i = 0; i < orders.size(); i++){
                if(orders.get(i).getNumber() == number){
                    orders.get(i).addItem(item);
                }
            }
        }
        else{
            throw new InaccessibleObjectException();
        }
    }

    public void removeOrder(int number){
        if(findOrder(number) != -1){
            for(int i = 0; i < orders.size(); i++){
                if(orders.get(i).getNumber() == number){
                    orders.remove(orders.get(i));
                }
            }
        }
        else{
            throw new InaccessibleObjectException();
        }
    }


    /**
     * gets a list of all the items in the order
     * @param number: the order number
     * @return: a list of all the menu items in the order
     */
    public List<MenuItem> getItems(int number){

        List<MenuItem> itemsInOrder = new ArrayList<>();
        if(findOrder(number) != -1) {
            for (int i = 0; i < orders.size(); i++) {
                if (orders.get(i).getNumber() == number) {
                    return orders.get(i).getItems();
                }
            }
        }
        else{
            throw new InaccessibleObjectException();
        }
        return itemsInOrder;

    }


    /**
     * gets the total price for that specific order
     * @param number: the order number
     * @return: a double with the entire order price, -1 if that order is not found
     */
    public double getOrderPrice(int number){
        if(findOrder(number) != -1) {
            for (int i = 0; i < orders.size(); i++) {
                if (orders.get(i).getNumber() == number) {
                    return orders.get(i).getTotalPrice();
                }
            }
        }
        else {
            throw new InaccessibleObjectException();
        }
        return -1;
    }


    /**
     * gets the total price of every order in the restaurant
     * @return count: the running count of price in the restaurant
     */
    public double getOrdersTotalPrice(){

        double count = 0;
        for(int i = 0; i < orders.size(); i++){
            count += orders.get(i).getTotalPrice();
        }
        return count;
    }

    /**
     * gets the order of the table number
     * @param number: the table number to get the order for
     * @return index: the index at which the order is at
     */
    public Order getOrder(int number){
        int index= findOrder(number);
        if(index!=-1){
            return orders.get(index);
        } else {
            throw new InaccessibleObjectException();
        }
    }


    /**
     * gets all the orders in the restaurant
     * @return orders: the list of orders
     */
    public List<Order> getAllOrders(){
        return orders;
    }
}