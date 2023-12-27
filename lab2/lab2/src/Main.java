public class Main {
    public static void main(String[] args) {
        System.out.println("Task 16 result: " + task16(0.58, 0.34, 1.25, -1.89));
        System.out.println("Task 17 result: " + task17(-1.49, 23.4, 1.23, 2.254));
        System.out.println("Task 18 result: " + task18(2.34, 0.756, 2.23, -1.653));
    }

    public static double task16(double a, double b, double c, double d) {
        return 2 * Math.sin(a) / Math.acos(-2 * b) - Math.sqrt(Math.log(c * Math.abs(2 * d)));
    }
    public static double task17(double a, double b, double c, double d){
        return 2 * Math.sqrt(Math.tan(Math.abs(a+c))) + (Math.log(b))/Math.pow(c, d);
    }
    public static double task18(double a, double b, double c, double d) {
        return (Math.exp(c) + 2 * Math.log10(a)) / Math.sqrt(Math.pow(c, b)) * Math.abs(Math.asin(d));
    }



}