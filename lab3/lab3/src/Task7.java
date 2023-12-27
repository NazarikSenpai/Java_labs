import java.util.Scanner;

public class Task7 {
    public static double calcEquation(double t, int i) {
        if (i < 1) {
            throw new IllegalArgumentException("i must be greater than or equal to 1");
        }

        double sum = 0.0;
        if (i == 1 || i == 2) {
            sum = Math.log(t);
        } else {
            for (int k = 1; k <= i; k++) {
                sum += (Math.sin(t) / k);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type a variable t: ");
        double t = scanner.nextDouble();

        System.out.print("Type a variable i (i>=1): ");
        int i = scanner.nextInt();

        System.out.println("t = " + t + " i = " + i + ": sum = " + calcEquation(t, i));

    }
}