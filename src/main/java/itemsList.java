package main.java;


public class itemsList {
    private String[] items;
    private int count;
    public itemsList() {
        count = 0;
        items = new String[100];
    }

    /**
     * Adds item to the list if there are 99 or less items
     * if there are 100 items prints List is full cannot store more than 100 items
     * @param item item to be added to the list
     *
     */
    public void addItem(String item){
        if (count == 100){
            System.out.println("\tList is full cannot store more than 100 items");
        } else {
            items[count] = item;
            count++;
            System.out.println("\tadded " + item);
        }
    }

    /**
     * Prints all items with serial numbers
     * if there are no items prints List is empty
     */
    public void printItems(){
        if (count == 0){
            System.out.println("\tList is empty");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println("\t" + (i + 1) + ". " + items[i]);
            }
        }
    }
}