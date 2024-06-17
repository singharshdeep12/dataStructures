package ds.basics;

import static ds.helper.Helper.*;

import java.util.Arrays;

class ArrayProbelms {

    public static void main(String[] args) {

        int[] originalArray = new int[]{1,-2,6,-1,3};
        int key = 12;

        maximumSumOfASubArray(originalArray);

        maximumSumOfASubArrayUsingPrefix(originalArray);
        
        maximumSumOfASubArrayUsingKadaneAlgorithm(originalArray);

        maximumSumOfASubArrayUsingPrefixDP(originalArray);


    }
    
    //LINEAR SEARCH - Normal Traverse


    //FIND LARGEST/SMALLEST - Normal Traverse using INT-MIN/INT-MAX


    //REVERSE AN ARRAY
    static void reverseAnArray(int[] myArray){
        printDashes();
        System.out.println("Original given array is - " + Arrays.toString(myArray));

        for(int i =0; i<=(myArray.length - 1)/2; i++){
            int temp = myArray[i];
            myArray[i] = myArray[myArray.length-1-i];
            myArray[myArray.length-1-i] = temp;
        }

        System.out.println("Reversed array is - " + Arrays.toString(myArray));
        printDashes();
    }



    //BINARY SEARCH - Eg dictionary - TC O(log n)
    static void binarySearch(int[] myArray, int key){
        printDashes();
        //Sorting the array
        System.out.println("The original array is -> " + Arrays.toString(myArray));
        int start = 0, end = myArray.length - 1;

        while(start<=end){
            int middle = (start + end)/2;
            if(myArray[middle]==key) {
                System.out.println("Element found via binary search at index = " + middle);
                printDashes();
                return;
            }
            if(myArray[middle]>key){
                end = middle - 1;
            } else{
                start = middle + 1;
            }       
        }
        System.out.println("Element couldn't be found");
        printDashes();
    }



    //SUBARRAYS IN ARRAY
    static void subArraysInArray(int[] myArray){
        printDashes();

        System.out.println("Given original array is -> " + Arrays.toString(myArray));

        int totalSubArrays = 0;
        int length = myArray.length;

        for(int i=0; i<length; i++){       // start element - i 
            
            for(int j=i; j<length; j++){
                System.out.print(myArray[i] + " ");   // end element - j
            
                for(int k=i+1; k<=j; k++){
                    System.out.print(myArray[k] + " ");
                }
                totalSubArrays++;
                System.out.println();
            }

        }

        System.out.println("Total subarrays printed are : " + totalSubArrays);

        printDashes();
    }




    //MAXIMUM SUM OF A SUBARRAY IN ARRAY - O (n^3)
    static void maximumSumOfASubArray(int[] myArray){
        printDashes();

        System.out.println("Given original array is -> " + Arrays.toString(myArray));

        int totalSubArrays = 0;
        int sum = 0, maxSum = Integer.MIN_VALUE;
        int length = myArray.length;

        for(int i=0; i<length; i++){       // start element - i 

            for(int j=i; j<length; j++){
                System.out.print(myArray[i] + " ");   // end element - j
                sum+=myArray[i]; 
                for(int k=i+1; k<=j; k++){
                    System.out.print(myArray[k] + " ");
                    sum+=myArray[k];
                }
                totalSubArrays++;
                System.out.println("\t and its sum is -> " + sum);
                if(sum>maxSum) maxSum = sum;
                sum=0;
            }

        }
        System.out.println("Maximum sum of a subarray in all subarrays normally using nested loops -> " + maxSum);
        System.out.println("Total subarrays printed are : " + totalSubArrays);

        printDashes();
    }



    //MAXIMUM SUM OF A SUBARRAY IN ARRAY USING PREFIX- O (n^2)
    static void maximumSumOfASubArrayUsingPrefix(int[] myArray){
        printDashes();

        System.out.println("Given original array is -> " + Arrays.toString(myArray));

        int totalSubArrays = 0;
        int sum = Integer.MIN_VALUE, maxSum = Integer.MIN_VALUE;
        int length = myArray.length;

        int[] prefixArray = new int[length];

        prefixArray[0] = myArray[0];

        //finding prefix
        for(int i=1;i<length;i++){
            prefixArray[i] = prefixArray[i-1] + myArray[i];
        }
        System.out.println("\nPrefix of above array -> ");
        Arrays.stream(prefixArray).forEach((element)-> System.out.print(element + "\t"));

        for(int i=0; i<length; i++){       // start element - i 

            for(int j=i; j<length; j++){
                totalSubArrays++;
                sum = 0;
                if(i==0){
                    sum = prefixArray[j];
                    maxSum = Math.max(maxSum, sum);
                    continue;
                }
                sum = prefixArray[j] - prefixArray[i-1];
                maxSum = Math.max(maxSum, sum);
            }

        }
        System.out.println("Maximum sum of a subarray in all subarrays using PREFIX -> " + maxSum);
        System.out.println("Total subarrays printed are : " + totalSubArrays);

        printDashes();
    }




    //MAXIMUM SUM OF A SUBARRAY IN ARRAY USING KADANE's AGLORITHM - O (n)
    static void maximumSumOfASubArrayUsingKadaneAlgorithm(int[] myArray){
        printDashes();

        System.out.println("Given original array is -> ");
        Arrays.stream(myArray).forEach((element)-> System.out.print(element + "\t"));
        int totalSubArrays = 0;
        int currentSum = 0, maxSum = Integer.MIN_VALUE;
        int length = myArray.length;

        for(int i=0; i<length; i++){

            currentSum = currentSum + myArray[i];
            maxSum = Math.max(maxSum, currentSum);
            currentSum = currentSum<0? 0:currentSum;

        }
        System.out.println("Maximum sum of a subarray in all subarrays using Kadane's Algorithm  -> " + maxSum);


        printDashes();
    }

    



    //MAXIMUM SUM OF A SUBARRAY USING PREFIX SUM ARRAY + DP - O (n)
    static void maximumSumOfASubArrayUsingPrefixDP(int[] myArray){
        printDashes();

        System.out.println("Given array -> ");
        Arrays.stream(myArray).forEach((element)-> System.out.print(element + "\t"));
        int length = myArray.length;
        int[] prefixArray = new int[length];

        prefixArray[0] = myArray[0];

        //finding prefix
        for(int i=1;i<length;i++){
            prefixArray[i] = prefixArray[i-1] + myArray[i];
        }
        System.out.println("\nPrefix of above array -> ");
        Arrays.stream(prefixArray).forEach((element)-> System.out.print(element + "\t"));

        //
        int maxSum = Integer.MIN_VALUE;
        int prefix_min_sum = 0;

        for(int i=0;i<length;i++){

            maxSum = Math.max(maxSum, prefixArray[i]-prefix_min_sum);
            prefix_min_sum = Math.min(prefix_min_sum, prefixArray[i]);

        }

        System.out.println("\nMaximum sum of a possible subarray using PREFIX & DP is -> " + maxSum);

        printDashes();
    }


}
