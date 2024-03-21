package app;

public class Model {

    public static double calculateDistance(double firstLatitude, double firstLongitude, double secondLatitude, double secondLongitude){
        final double R = 6371;

        double deltaLatitude = secondLatitude - firstLatitude;
        double deltaLongitude = secondLongitude - firstLongitude;

        double a = Math.pow(Math.sin(deltaLatitude/2),2) + Math.cos(firstLatitude) * Math.cos(secondLatitude) * Math.pow(Math.sin(deltaLongitude/2),2);
        double c =  2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }
}
