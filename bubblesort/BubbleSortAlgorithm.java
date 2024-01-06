package bubblesort;

import java.util.Scanner;

public class BubbleSortAlgorithm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        System.out.println("Enter the values of the array separated by spaces:");
        scanner.nextLine(); // Consume the newline character left by nextInt()

        String input = scanner.nextLine();
        String[] values = input.split(" ");

        if (values.length != size) {
            System.out.println("The number of values entered does not match the array size.");
            scanner.close();
            return;
        }

        // Populate the array with user input values
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(values[i]);
        }

        // Bubble Sort algorithm
        boolean isSorted = false;  // Flag to check if the array is already sorted

        for (int i = 0; i < size - 1 && !isSorted; i++) {
            isSorted = true;  // Assume the array is sorted at the beginning of each pass

            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap elements if they are in the wrong order
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    isSorted = false;  // If a swap is made, the array is not sorted
                }
            }
        }

        // Print the sorted array
        System.out.print("Sorted array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]);
            if (i < size - 1) {
                System.out.print(" ");
            }
        }

        // Find the most frequent number without using a separate array
        int mostFrequentNumber = array[0];
        int currentNumber = array[0];
        int currentCount = 1;
        int maxCount = 1;

        for (int i = 1; i < size; i++) {
            if (array[i] == currentNumber) {
                currentCount++;
            } else {
                currentNumber = array[i];
                currentCount = 1;
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
                mostFrequentNumber = currentNumber;
            }
        }

        // Print the most frequent number and its count
        System.out.println("\nNumber(s) that appear most and their count(s):");
        System.out.println("Number: " + mostFrequentNumber + " | Count: " + maxCount);

        scanner.close();
    }
}
