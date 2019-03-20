package edu.ithaca.comp345.Rockstar;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    public String name;
    private List<Table> Tables= new ArrayList<>();
    private Stock stock = new Stock();

    public Restaurant(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }
}
