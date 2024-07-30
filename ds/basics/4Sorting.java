package ds.basics;

import static ds.helper.Helper.*;

import java.util.Arrays;
import java.util.stream.Collectors;

// In all sorting techniques - first loop is for turns, 2nd does the job
class Sorting {
    
    public static void main(String[] args) {
        
        int[] originalArray = new int[]{1,-2,6,-1,3};
        mergeSort(originalArray);
        mergeSort(arrayOfZeroes());

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
 * Arrays.sort(arr);
 * Arrays.sort(int[] arr, int from_Index, int to_Index);
 * Arrays.sort(arr, Collections.reverseOrder());
 */
static void javaInbuiltSort(int array[]){
    printDashes();
    int length = array.length;

    int[] toBeSorted = Arrays.copyOf(array, array.length);

    printArray("Original array provided is ", array);

    Arrays.sort(toBeSorted);
    //---- people love to see a hero fail
    printArray("Sorting full array Using inbuilt sort ", toBeSorted);

    toBeSorted = Arrays.copyOf(array, array.length);

    printArray("Original array provided is ", array);

    Arrays.sort(toBeSorted,0,3);  //from starting index to ending index

    printArray("Sorting few indexes in array Using inbuilt sort ", toBeSorted);



    printDashes();
}



//Counting Sort - O(n + maxRange/maxElement)
/*
 * 
 * Best when range is given (find the largest element) + range is small (frequency of numbers can be high but range is less)
 * Create a frequency array(length till max element) -> where frequency of numbers is stored
 * Traverse the frequency array and store the elements in original array
 */
static void countingSort(int array[]){
    printDashes();
    int length = array.length;
    printArray("Original array provided is ", array);

    int range = 21;  //could be whatever the max element is in your array OR find the max element

    int[] freq = new int[range+1];

    for(int i=0;i<length;i++){
        freq[array[i]] ++;
    }
    //declaring int to go from 0 to length of original array to store elements from freq array to original array
    int count=0;
    for(int i=0;i<freq.length;i++){
        while(freq[i]>0){
            array[count++] = i;
            freq[i]--;
        }
    }


    printArray("Counting sort -> ", array);
    printDashes();
 }




 //Counting Sort - O(n + maxRange/maxElement)
/*
 * 
 * Best when range is given (find the largest element) + range is small (frequency of numbers can be high but range is less)
 * Create a frequency array(length till max element) -> where frequency of numbers is stored
 * Traverse the frequency array and store the elements in original array
 */
static void mergeSort(int array[]){
    printDashes();
    int length = array.length;
    printArray("Original array provided is ", array);

    mergeSortHelper(array, 0, length-1);

    printArray("Merge sort -> ", array);
    printDashes();
    
}


static void mergeSortHelper(int[] array, int startIndex, int endIndex){
    if(startIndex>=endIndex) return;

    int middleIndex = (startIndex+endIndex)/2;
    mergeSortHelper(array, startIndex, middleIndex);  //divide
    mergeSortHelper(array, middleIndex + 1, endIndex);  //divide
    mergeBoth(array,startIndex,middleIndex, endIndex);  //merge


}

static void mergeBoth(int[] array, int startIndex, int middleIndex, int endIndex){
    int[] temp = new int[endIndex-startIndex+1];
    int tempStart=0;
    int left = startIndex; 
    int right = middleIndex+1;
    
    while(left<=middleIndex && right<=endIndex){
        if(array[left]>array[right]){
            temp[tempStart++] = array[right++];
        } else{
            temp[tempStart++] = array[left++];
        }
    }
    while(left<=middleIndex){
            temp[tempStart++] = array[left++];
    }
    while(right<=endIndex){        
            temp[tempStart++] = array[right++];
    }

    tempStart=0;

    int startCopy = startIndex;

    while(startCopy<=endIndex){
        array[startCopy++] = temp[tempStart++];
    }

}


}
