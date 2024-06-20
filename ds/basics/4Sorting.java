package ds.basics;

import static ds.helper.Helper.*;

import java.util.Arrays;
import java.util.stream.Collectors;

// In all sorting techniques - first loop is for turns, 2nd does the job
class Sorting {
    
    public static void main(String[] args) {
        
        int[] originalArray = new int[]{1,-2,6,-1,3};
        javaInbuiltSort(originalArray);
        javaInbuiltSort(arrayOfZeroes());

    }


//BUBBLE SORT ASC - O(n^2)
/*
 * Bubbles of 2 and sort
 * 
 * If already sorted array is given, then also O(n^2)
 * 
 * But i can take count swap & check after inner loop run if swap==0; then array is already sorted - O(n), but this is in case of sorted array only
 * 
 */
    static void bubbleSortAscending(int[] array){
        printDashes();

        System.out.println("Given array is ->");
        Arrays.stream(array).forEach(element -> System.out.print(element + "\t"));
        System.out.println();

        int length = array.length;

        for(int i=0;i<length-1;i++){      //this loop calculates turns

            for(int j=0; j<length-1-i;j++){

                if(array[j]>array[j+1]){    // sign change to > to get descending sort
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }

            }

        }
        System.out.println("Bubble Sorted array is ->");
        Arrays.stream(array).forEach(element -> System.out.print(element + "\t"));
        System.out.println();

        printDashes();
    }

    


//SELECTION SORT
/*
 * Select smallest and place at beginning
 */
static void selectionSort(int array[]){
    printDashes();

    System.out.println("Given array is ->");
    printArray(array);

    int length = array.length;

    for(int i=0;i<length-1;i++){
        int smallest = array[i];
        int smallestIndex = i;
        for(int j=i+1;j<length;j++){
            if(array[j]<smallest){       // sign change to > to get descending sort
                smallest = array[j];
                smallestIndex = j; 
            }
        }
        int temp = array[i];
        array[i] = smallest;
        array[smallestIndex] = temp;
    }

    printArray("Selection Sorted array is ->",array);
}



//INSERTION SORT - O(n^2)
/*
 * Pick element and insert at right place starting from front
 */
 static void insertionSort(int array[]){
    printDashes();
    int length = array.length;
    printArray("Original array provided is ", array);

    for(int i=1; i<length; i++){

        int j = i;
        int temp = array[i];

        while(j>0 && (temp<array[j-1])){
            array[j] = array[j-1];
            j--;
        }

        array[j] = temp;

    }

    printArray("Insertion sort -> ", array);
    printDashes();
 }




 //JAVA INBUILT SORT - O(n * log n)
/*
 * 
 */
static void javaInbuiltSort(int array[]){
    printDashes();
    int length = array.length;

    int[] toBeSorted = Arrays.copyOf(array, array.length);

    printArray("Original array provided is ", array);

    Arrays.sort(toBeSorted);

    printArray("Sorting full array Using inbuilt sort ", toBeSorted);

    toBeSorted = Arrays.copyOf(array, array.length);

    printArray("Original array provided is ", array);

    Arrays.sort(toBeSorted,0,3);  //from starting index to ending index

    printArray("Sorting few indexes in array Using inbuilt sort ", toBeSorted);



    printDashes();
}






}
