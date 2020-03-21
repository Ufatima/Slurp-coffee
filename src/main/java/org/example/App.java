package org.example;

import java.util.Scanner;

public class App
{
    public static final int volumeOf200g = 16 * 23 * 2;
    public static final int volumeOf400g = 22 * 26 * 2;
    public static final int volumeOf1000g = 14 * 26 * 10;
    public static final int volumeOfBox = 60 * 60 * 60;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Coffee Bag Types");
        int numberOfCoffeeBagTypes = sc.nextInt();
        sc.nextLine();
        String[] order= new String[numberOfCoffeeBagTypes];
        for(int i = 0; i < numberOfCoffeeBagTypes; i++){
            order[i] = sc.nextLine();
        }
        int[] volumes = processInput(numberOfCoffeeBagTypes, order);
        int n = volumes.length;
        System.out.println("Minimum number of boxes that are needed to fit the coffee bags : " +
                calculateBox(volumes, n , volumeOfBox));
    }

    /**
     * Process input and calculate volumes of coffee bag
     * @param numberOfCoffeeBagTypes
     * @param order
     * @return
     */
    private static int[] processInput(int numberOfCoffeeBagTypes, String[] order) {
        int[] volumes = new int[numberOfCoffeeBagTypes];
        for (int j = 0; j < order.length; j++){

            String[] parts = order[j].split("x");
            String qty = parts[0].trim();
            String bag = parts[1].trim();

            if(bag.equals("200g")){
                volumes[j] = Integer.parseInt(qty) * volumeOf200g;
            } else if(bag.equals("400g")){
                volumes[j] = Integer.parseInt(qty) * volumeOf400g;
            } else if(bag.equals("1000g")){
                volumes[j] = Integer.parseInt(qty) * volumeOf1000g;
            } else {
                System.out.println("Invalid Input");
                System.exit(0);
            }
        }
        return volumes;
    }

    /**
     * calculates the minimum number of boxes that are needed to fit all
     * the different sizes of coffee bags
     * @param volumes
     * @param n
     * @param volumeOfBox
     * @return
     */
    static int calculateBox(int[] volumes, int n, int volumeOfBox){

        int numberOfBox = 1, remVol = volumeOfBox;

        for (int i = 0; i < n; i++) {
            if (volumes[i] > remVol) {
                numberOfBox++;
                remVol = volumeOfBox - volumes[i];
            }
            else
                remVol -= volumes[i];
        }
        return numberOfBox;
    }
}
