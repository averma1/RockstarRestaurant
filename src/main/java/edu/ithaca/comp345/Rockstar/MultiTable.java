package edu.ithaca.comp345.Rockstar;

import java.util.ArrayList;
import java.util.List;

public class MultiTable extends Table {
    public List<Table> tableSizes= new ArrayList<>();

    public MultiTable(int tableNumber, Table table1, Table table2){
        super(tableNumber, table1.getNumOfSeats()+table2.getNumOfSeats());
        tableSizes.add(table1);
        tableSizes.add(table2);
        isMultiTable=true;
    }

    public void addAnotherTable(Table table){
        tableSizes.add(table);
        super.setNumOfSeats(super.getNumOfSeats()+table.getNumOfSeats());
    }
}
