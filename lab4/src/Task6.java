import java.util.Arrays;
import java.util.Scanner;


public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            throw new IllegalArgumentException("Array size must be greater than 0");
        }

        int[] array = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int min = minMultiOfFive(array);
        System.out.println("Minimum element that is a multiple of 5: " + min);

    }

    public static int minMultiOfFive(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        boolean multiOfFive = false;
        int minMultiOfFive = 0;
        for (int num : arr) {
            if (num % 5 == 0) {
                multiOfFive = true;
                minMultiOfFive = num;
            }
        }
        if (multiOfFive == false) {
            throw new IllegalArgumentException("There are no elements in the array that are multiples of 5");
        }

        for (int num : arr) {
            if (num < minMultiOfFive) {
                minMultiOfFive = num;
            }
        }

        return minMultiOfFive;

    }

    ;
}
