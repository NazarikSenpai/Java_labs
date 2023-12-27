import java.util.Scanner;

public class Task1 {
    public static double calcEquation(double m, int k) {
        if (k > 30) {
            throw new IllegalArgumentException("k must be less than or equal to 30");
        }

        double sum = 0.0;
        for (int i = 1; i <= k; i++) {
            sum += Math.sqrt(m * (1.0 / i)) * Math.sin(m * i);
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type a variable m: ");
        double m = scanner.nextDouble();

        System.out.print("Type a variable k (k<=30): ");
        int k = scanner.nextInt();

        System.out.println("m = " + m + " k = " + k + ": sum = " + calcEquation(m, k));

    }
}
