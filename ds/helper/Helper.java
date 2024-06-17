package ds.helper;

import java.util.Arrays;

public class Helper {
    public static void printDashes(){
        System.out.println("-".repeat(100));
    }

    public static int[] arrayOfZeroes(){
        return new int[]{0,0,0,0,0,0,0,0,0};
    }

    public static void printArray(int[] array){
        Arrays.stream(array).forEach(element -> System.out.print(element + "\t"));
        System.out.println();
    }

    public static void printArray(String message, int[] array){
        System.out.println(message);
        Arrays.stream(array).forEach(element -> System.out.print(element + "\t"));
        System.out.println();
    }

}
