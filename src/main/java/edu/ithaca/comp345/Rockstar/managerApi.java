package edu.ithaca.comp345.Rockstar;

import java.lang.reflect.InaccessibleObjectException;
import java.util.ArrayList;
import java.util.List;

public class managerApi extends Restaurant{
    public static void addIngredient(String name, double cost, int quantity){
        stock.addIngredient(name, cost, quantity);
    }

    public static void removeIngredient(String name){
        stock.removeIngredient(name);
    }

    public static Ingredient getIngredient(String nameToFind){
        return stock.getIngredient(nameToFind);
    }

    public static double getCostOfIngredient(String nameToFind){
        return stock.getCost(nameToFind);
    }

    public static int getQuantityOfIngredient(String nameToFind){
        return stock.getQuantity(nameToFind);
    }

    public static boolean isIngredientAvailable(String ingredientName){
        return stock.isIngredientAvailable(ingredientName);
    }

    public static void addEmployee(int pin, String name, String type){
        int index= findEmployee(pin);
        if(index!=-1) {
            throw new InaccessibleObjectException();
        } if(type!="waiter" && type!="host" && type!="manager" && type!="bartender"){
                throw new InaccessibleObjectException();
        } if(!isPinValid(pin)){
            throw new InaccessibleObjectException();
        }
        Employee new1= new Employee(pin, name, type);
        employees.add(new1);
        pins.add(pin);
        if(type=="waiter"){
            waiters.put(new1, null);
        }
    }

    private static boolean isPinValid(int pin){
        int length = (int) (Math.log10(pin) + 1);
        if(length==4) {
            if (!pins.contains(pin)) {
                return true;
            }
        }
        return false;
    }

    public static void removeEmployee(int pin, String name){
        int index= findEmployee(pin);
        if(index==-1){
            throw new InaccessibleObjectException();
        }
        Employee fired= employees.get(index);
        employees.remove(index);
        if(fired.getType()=="waiter"){
            waiters.remove(fired);
        }
        int pinIndex=-1;
        for(int i=0; i<pins.size();i++){
            if(pins.get(i)==fired.getPin()){
                pinIndex=i;
            }
        }
        pins.remove(pinIndex);

    }

    public static void changeEmployeePin(int pinOld, int pinNew){
        int index= findEmployee(pinOld);
        if(index==-1){
            throw new InaccessibleObjectException();
        }
        if(!isPinValid(pinNew)){
            throw new InaccessibleObjectException();
        }
        Employee changed= employees.get(index);
        int pinIndex=-1;
        for(int i=0; i<pins.size();i++){
            if(pins.get(i)==pinOld){
                pinIndex=i;
            }
        }
        pins.remove(pinIndex);
        pins.add(pinNew);
        changed.setPin(pinNew);
    }

    public static void changeEmployeeType(int pin, String name, String typeNew){
        int index= findEmployee(pin);
        if(index==-1){
            throw new InaccessibleObjectException();
        }
        if(typeNew!="waiter" && typeNew!="host" && typeNew!="manager" && typeNew!="bartender"){
            throw new InaccessibleObjectException();
        }
        Employee changed= employees.get(index);
        changed.setType(typeNew);

    }

    public void removeTablesFromWaiter(int pin, String Name, int tablenum){
        int index=findEmployee(pin);
        if(index==-1){
            throw new InaccessibleObjectException();
        }
        Employee changed= employees.get(index);
        if(changed.getType()!="waiter"){
            throw new InaccessibleObjectException();
        }

        if(findTable(tablenum)==-1){
            throw new InaccessibleObjectException();
        }

        List<Table> newlist= waiters.get(changed);
        if(newlist==null){
            throw new InaccessibleObjectException();
        }
        int tableIndex=-1;
        for(int i=0; i<newlist.size(); i++){
            if(newlist.get(i).getTableNumber()==tablenum){
                tableIndex=i;
            }
        }
        if(tableIndex==-1){
            throw new InaccessibleObjectException();
        }
        newlist.remove(tableIndex);
        waiters.replace(changed, newlist);
    }

    public void addTableToWaiter(int tablenum, int pin, String name){
        int index=findEmployee(pin);
        if(index==-1){
            throw new InaccessibleObjectException();
        }
        Employee changed= employees.get(index);
        if(changed.getType()!="waiter"){
            throw new InaccessibleObjectException();
        }

        int tableIndex=findTable(tablenum);
        if(tableIndex==-1){
            throw new InaccessibleObjectException();
        }

        Table toAdd= allTables.get(tableIndex);
        List<Table> newlist= waiters.get(changed);
        if(newlist==null){
            newlist= new ArrayList<>();
        }
        newlist.add(toAdd);
        waiters.replace(changed, newlist);
    }
}
