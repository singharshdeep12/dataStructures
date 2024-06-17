package ds.basics;

import static ds.helper.Helper.*;

import java.util.Arrays;
import java.util.stream.Collectors;


class Sorting {
    
    public static void main(String[] args) {
        
        int[] originalArray = new int[]{1,-2,6,-1,3};
        selectionSort(originalArray);
        selectionSort(arrayOfZeroes());


        String toFind = "iamfromIndiaandimproudtobeindian";
        //this will print each letter and its total literal occurences
        Arrays.stream(toFind.split(""))
                .collect(Collectors.groupingBy(c->c))
                .forEach((k,v)-> System.out.println(k+"->"+v));


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

        for(int i=0;i<length-1;i++){

            for(int j=0; j<length-1-i;j++){

                if(array[j]>array[j+1]){    // sign change to > to get descending sort
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }

            }

        }
        System.out.println("Sorted array is ->");
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
        int smallestIndex = 0;
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

    printArray("Sorted array is ->",array);
}


}
