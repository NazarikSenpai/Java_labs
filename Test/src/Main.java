import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        int[] nums = new int[10];
        for (int i = 0; i<nums.length;i++){
            nums[i] = i*2;
        }

        for (int num:nums){
            System.out.println(num);
        }
    }
}