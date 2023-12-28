import java.util.Scanner;

public class Task36 {
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

        System.out.println("Geometric mean of the maximum and minimum array elements: " + geomMeanOf(array));

    }

    public static double geomMeanOf(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }

        return Math.sqrt(maxIndex * minIndex);
    }
}
