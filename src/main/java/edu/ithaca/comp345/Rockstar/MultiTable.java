package edu.ithaca.comp345.Rockstar;

import java.util.ArrayList;
import java.util.List;

public class MultiTable extends Table {
    public List<Integer> tableSizes= new ArrayList<>();

    public MultiTable(int tableNumber, int numOfSeats, int size1, int size2){
        super(tableNumber, numOfSeats);
        tableSizes.add(size1);
        tableSizes.add(size2);
        isMultiTable=true;
    }

    public void addAnotherTable(int size){
        tableSizes.add(size);
        super.setNumOfSeats(super.getNumOfSeats()+size);
    }
}
