import java.util.Scanner;

public class Task66 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array A: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            throw new IllegalArgumentException("Array size must be greater than 0");
        }

        int[] arrayA = new int[n];

        System.out.println("Enter array A elements:");
        for (int i = 0; i < n; i++) {
            arrayA[i] = scanner.nextInt();
        }

        System.out.print("Enter the number of elements in the array B: ");
        int m = scanner.nextInt();
        if (m <= 0) {
            throw new IllegalArgumentException("Array size must be greater than 0");
        }

        int[] arrayB = new int[m];

        System.out.println("Enter array elements:");
        for (int i = 0; i < m; i++) {
            arrayB[i] = scanner.nextInt();
        }

        int[] arrayC = new int[arrayA.length + arrayB.length];
        arrayC = mergeArrays(arrayA, arrayB);

        System.out.println("Merged array C: ");
        for (int num : arrayC) {
            System.out.print(num + " ");
        }

    }

    public static int[] mergeArrays(int[] arrA, int[] arrB) {
        if (arrA == null || arrA.length == 0 || arrB == null || arrB.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int aSize = arrA.length;
        int bSize = arrB.length;
        int[] mergedArray = new int[aSize + bSize];

        for (int i = 0; i < aSize; i++) {
            mergedArray[i] = arrA[i];
        }

        for (int i = 0; i < bSize; i++) {
            mergedArray[i + aSize] = arrB[i];
        }

        return mergedArray;
    }
}
