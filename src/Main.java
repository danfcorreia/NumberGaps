import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] arrayOfNumbers = new int[]{0, 5, 1209, 6, 2, 6, 111, 112, 33, 1, 2, 6, 7, 45, 90, 89, 12, 25};
        int minimumGap = 0;
        int[] arraySavedNumbers = new int[2];
        boolean startingLoop = true;
        int counter = 0;
        ArrayList<int[]> myList = new ArrayList<>();

        for (int i = 0; i < arrayOfNumbers.length - 1; ++i) {

            int differenceBetweenNumbers = Math.abs(arrayOfNumbers[i] - arrayOfNumbers[i + 1]);

            if (differenceBetweenNumbers <= minimumGap || startingLoop) {
                Thread.sleep(1000);
                // If the gap between numbers is lower, add those numbers to our local array
                arraySavedNumbers[0] = arrayOfNumbers[i];
                arraySavedNumbers[1] = arrayOfNumbers[i + 1];

                if(differenceBetweenNumbers == minimumGap) {
                    System.out.println("Found a new equal minimum gap between numbers! The value is " + differenceBetweenNumbers + " and it is between " + arrayOfNumbers[i] + " and " + arrayOfNumbers[i + 1] + ".");
                    myList.add(counter, arraySavedNumbers);
                    System.out.println(Arrays.toString(myList.get(counter)));
                    System.out.println(counter);
                    counter++;
                } else {
                    System.out.println("I found a smaller gap between two numbers! The value is " + differenceBetweenNumbers + " and it is between " + arrayOfNumbers[i] + " and " + arrayOfNumbers[i + 1] + ".");
                    myList.clear();
                    counter = 0;
                }

                minimumGap = differenceBetweenNumbers;
                startingLoop = false;
            }
        }
        counter++;

        if(!myList.isEmpty()){
            System.out.println("\nThere were " + counter + " pairs of numbers with a minimum gap of " + minimumGap + ".");
        }
    }
}