package edu.ithaca.comp345.Rockstar;

public class Employee {
    private int pin;
    private String name;
    private String type;

    public Employee(int pinIn, String nameIn, String typeIn){
        pin=pinIn;
        name=nameIn;
        type=typeIn;
    }

    public void setPin(int pinIn){
        pin=pinIn;
    }

    public void setName(String nameIn){
        name=nameIn;
    }

    public void setType(String typeIn){
        type=typeIn;
    }

    public int getPin(){
        return pin;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

}
