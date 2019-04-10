package edu.ithaca.comp345.Rockstar;


import java.io.*;
import java.lang.reflect.InaccessibleObjectException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class Stock {
    private HashMap<String, Ingredient> ingredientMap;

    public Stock() {
        ingredientMap = new HashMap<>();
    }

    /**
     * creates a new ingredient object and adds it to to the HashMap
     * @param name     the name of the ingredient to use
     * @param cost     the cost of the ingredient to use
     * @param quantity the quantity of the ingredient to use
     */
    public void addIngredient(String name, double cost, int quantity) {
        if(isIngredientAvailable(name)){ //the ingredient already exists
            changeIngredientQuantity(name, getQuantity(name) + quantity);
        }
        else
            ingredientMap.put(name, new Ingredient(name, cost, quantity));
    }

    /**
     * gets an ingredient object based on the key
     *
     * @param nameToFind the name of the ingredient or key
     * @return the Ingredient object found
     */
    public Ingredient getIngredient(String nameToFind) {
        return ingredientMap.get(nameToFind);
    }

    /**
     * decrement stock based on an ordered menuItem
     *
     * @param item the menuItems whose items need to be removed
     */
    public void removeMenuItem(MenuItem item){
        if(item.getIngredients()!=null) {
            for (int i = 0; i < item.getIngredients().size(); i++) {
                Ingredient current = item.getIngredients().get(i);
                int count= item.ingredients.get(current);
                removeSeveralIngredients(current.getName(), count);
            }
        }
    }

    public void removeSeveralIngredients(String name, int quantity){
        if(isIngredientAvailable(name)){
            int current= ingredientMap.get(name).getQuantity();
            if(quantity<=current){
                changeIngredientQuantity(name,current-quantity);
            } else {
                throw new InaccessibleObjectException();
            }
        } else {
            throw new InaccessibleObjectException();
        }
    }

    /**
     * gets the cost of an Ingredient object
     *
     * @param nameToFind the name of the ingredient or key to find the object
     * @return the cost of the ingredient
     */
    public double getCost(String nameToFind) {
        return ingredientMap.get(nameToFind).getCost();
    }

    /**
     * get the quantity of a specified Ingredient object
     *
     * @param nameToFind the name of the ingredient or key to find the object
     * @return the quantity of the object
     */
    public int getQuantity(String nameToFind) {
        return ingredientMap.get(nameToFind).getQuantity();
    }

    /**
     * removes an ingredient from the HashMap based on the name
     *
     * @param nameToFind the name of the ingredient or key to find the object
     */
    public void removeIngredient(String nameToFind) {
        ingredientMap.remove(nameToFind);
    }

    /**
     * changes the name of a specified ingredient
     *
     * @param nameToFind the name of the ingredient or key to find the object
     * @param changeTo   the name to change the object to
     */
    public void changeIngredientName(String nameToFind, String changeTo) {

        Ingredient ingredient = ingredientMap.get(nameToFind);
        double cost = ingredient.getCost();
        int quantity = ingredient.getQuantity();

        Ingredient newIngredient = new Ingredient(changeTo, cost, quantity);

        ingredientMap.remove(nameToFind);
        ingredientMap.put(changeTo, newIngredient);
    }

    /**
     * changes the cost of the specified ingredient
     *
     * @param nameToFind the name of the ingredient or key to find the object
     * @param cost       the cost to change the object to
     */
    public void changeIngredientCost(String nameToFind, double cost) {
        ingredientMap.get(nameToFind).setCost(cost);
    }

    /**
     * changes the quantity of the specified ingredient
     *
     * @param nameToFind the name of the ingredient or key to find the object
     * @param quantity   the quantity to change the object to
     */
    public void changeIngredientQuantity(String nameToFind, int quantity) {
        ingredientMap.get(nameToFind).setQuantity(quantity);
    }

    /**
     * gets the HashMap of Ingredient objects
     *
     * @return the HashMap of Ingredient objects
     */
    public HashMap getIngredientsList() {
        return ingredientMap;
    }

    /**
     * checks if the specified ingredient exists in the HashMap
     *
     * @param nameToFind the name of the ingredient or key to find the object
     * @return a boolean - true if the object exists or false if it does not
     */
    public boolean isIngredientAvailable(String nameToFind) {
        return ingredientMap.containsKey(nameToFind);
    }

    /**
     * loads in ingredients to the stock based on the data in a file
     *
     * @param fileName the name of the file to load in
     */
    public void loadFromFile(String fileName) throws IOException {
        BufferedReader br = null;

        try
        {
            File file = new File(fileName);
            br = new BufferedReader(new FileReader(file));
        }
        catch (FileNotFoundException e) {
            throw new FileNotFoundException("The file " + fileName + " doesn't exist!");
        }

        String st;
        String itemName;
        int itemQuanity;
        double itemCost;
        while ((st = br.readLine()) != null){
            try {
                itemName = st.substring(0, st.indexOf('#'));
                itemQuanity = Integer.parseInt(st.substring(st.indexOf('#') + 1, st.indexOf('$')));
                itemCost = Double.parseDouble(st.substring(st.indexOf('$') + 1, st.length()));
                addIngredient(itemName, itemCost, itemQuanity);
            }
            catch(StringIndexOutOfBoundsException | NumberFormatException e){
                System.out.println("Invalid Input: " + st);
            }
        }


    }

    /**
     * saves the current stock to a new file
     * @param fileName the filename to save the stock to
     * @throws IOException
     */
    public void saveStockToFile(String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter("stockOutputTest.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);

        String name = "";
        double cost = 0.0;
        int quantity = 0;

        Collection<Ingredient> collection = ingredientMap.values();

        Iterator<Ingredient> iterator = collection.iterator();

        Ingredient current = null;

        ArrayList<String> array = new ArrayList<>();

        while (iterator.hasNext()) {
            current = iterator.next();
            name = current.getName();
            cost = current.getCost();
            quantity = current.getQuantity();

            if (iterator.hasNext()){
                printWriter.println(name + "#" + quantity + "$" + cost);
            }
            else{
                printWriter.print(name + "#" + quantity + "$" + cost);
            }
        }
        printWriter.close();
    }

}
