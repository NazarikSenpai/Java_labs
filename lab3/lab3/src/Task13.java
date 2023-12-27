import java.util.Scanner;

public class Task13 {
    public static double calcSum(double e) {
        if (e < 0) throw new IllegalArgumentException("e must be less than 0");

        int i = 1;
        double sum = 0;
        double term;
        while (true) {
            term = Math.pow(-1, i) / factorial(i);

            if (Math.abs(term) < e) break;

            sum += term;
            i++;
        }
        return sum;
    }

    private static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type a variable e (e>0): ");
        String x = scanner.next();
        double e = Double.parseDouble(x);

        System.out.println("e = " + e + " : sum = " + calcSum(e));

    }
}
