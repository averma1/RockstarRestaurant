package edu.ithaca.comp345.Rockstar;

public class bartenderUI extends bartenderApi{
    public boolean addToOrderUI(int orderNum, MenuItem item){
        try{
            addToOrder(orderNum, item);
            return true;
        } catch (IndexOutOfBoundsException e){
            return false;
        }
    }

    public double payUI(int orderNum){
        try{
            double payed= pay(orderNum);
            return payed;
        } catch (IndexOutOfBoundsException e){
            return -1;
        }
    }

    public boolean seatPerson(int numOfPeople){
        try{
            seatAtBar(numOfPeople);
            return true;
        } catch (IndexOutOfBoundsException e){
            return false;
        }
    }

    public int getFilledSeatsUI(){
        return seeFilledSeats();
    }
}
