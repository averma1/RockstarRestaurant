package edu.ithaca.comp345.Rockstar;

import java.util.ArrayList;
import java.util.List;

public class MultiTable extends Table {
    public List<Table> tables= new ArrayList<>();

    public MultiTable(int tableNumber, Table table1, Table table2){
        super(tableNumber, table1.getNumOfSeats()+table2.getNumOfSeats());
        tables.add(table1);
        tables.add(table2);
        isMultiTable=true;
    }

    public void addAnotherTable(Table table){
        tables.add(table);
        super.setNumOfSeats(super.getNumOfSeats()+table.getNumOfSeats());
    }
}
