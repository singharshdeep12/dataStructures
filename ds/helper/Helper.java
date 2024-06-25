package ds.helper;

import java.util.Arrays;
import java.util.Random;

public class Helper {
    public static void printDashes(){
        System.out.println("-".repeat(100));
    }

    public static void printDashes(String message){
        System.out.println("-".repeat(100));
        System.out.println("Inside -> " + message + " method");
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

    public static int getARandomInt(int bound){
        return new Random().nextInt(bound);
    }

    public static void printMultiDimArray(int[][] matrix){
        for(int i =0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static Boolean isOdd(int n){
        return n%2!=0;
    } 

    public static Boolean isEven(int n){
        return n%2==0;
    } 

    public static int binarySearch_Arsh(int[] arr, int key){
        printDashes("binarySearch_Arsh");
        boolean flag = false;
        int rowLength = arr.length;
        int startIndex = 0, endingIndex = rowLength-1;

        while(endingIndex>=startIndex){
            int searchIndex = (endingIndex+startIndex)/2;
            int currentElement = arr[startIndex];
            if(currentElement == key){
                System.out.println("Element of array -> " + Arrays.toString(arr) + "  found at index -> "  + searchIndex);
                return searchIndex;
            }
            if(currentElement>key){
                endingIndex = searchIndex-1;
                continue;
            }
            if(currentElement<key){
                startIndex = startIndex+1;
            }
        }
        System.out.println("Element not found via binary search method");
        printDashes();
        return -1;
    }
}
