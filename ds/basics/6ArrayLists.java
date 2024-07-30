package ds.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static ds.helper.Helper.*;

class ArrayListProblems {
    
    public static void main(String[] args) {
        Integer[] heightArray = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        ArrayList<Integer> heights = new ArrayList<>();
        heights.addAll(Arrays.asList(heightArray));
        
        containerWithMostWater2PointerApproach(heights);

    }




    /*
    * Container with most water Problem 
    * For given n lines on x-axis, use 2 lines to form a container such that
    * it holds maximum water
    * This below solution is of O(n^2)
    */
    static void containerWithMostWater(List<Integer> heights){
        printDashes("containerWithMostWater O(n^2)");
        int maxLeft = 0;
        int maxRight = 0;
        int maxWater = 0;
        int length = heights.size();

        for(int i=0; i<length; i++){
            for(int j=i+1; j<length; j++){
                int minHeight = Math.min(heights.get(i), heights.get(j));
                int base = j-i;
                int waterHold = base * minHeight;
                if(maxWater<waterHold){
                    maxWater=waterHold;
                    maxLeft=i;
                    maxRight=j;
                }
            }
        }

        System.out.println("Max amount of water that can be holded is -> " + maxWater);
        System.out.println("And this is between -> " + maxLeft +" and " + maxRight);
        printDashes();
    }

    /*
    * Container with most water Problem 
    * For given n lines on x-axis, use 2 lines to form a container such that
    * it holds maximum water
    * This below solution is of O(n) with 2 pointer approach
    */
    static void containerWithMostWater2PointerApproach(List<Integer> heights){
        printDashes("containerWithMostWater2PointerApproach O(n)");
        int length = heights.size();
        int leftPointer = 0;
        int rightPointer = length-1;
        int maxWater = 0;
        int maxLeft = 0;
        int maxRight = 0;

        while(leftPointer<=rightPointer){
            int base = rightPointer-leftPointer;
            int height = Math.min(heights.get(leftPointer), heights.get(rightPointer));
            int waterHolded = base*height;
            if(maxWater<waterHolded){
                maxWater=waterHolded;
                maxLeft=leftPointer;
                maxRight=rightPointer;
            }
            if(heights.get(leftPointer)<heights.get(rightPointer)){
                leftPointer++;
            }
            else{
                rightPointer--;
            }
        }


        System.out.println("Max amount of water that can be holded is -> " + maxWater);
        System.out.println("And this is between -> " + maxLeft +" and " + maxRight);
        printDashes();
    }


    /*
     * An Arraylist is monotonic if it is either monotone increasing or monotone decreasing.
     * An Arraylist nums is monotone increasing if for all i<=j, nums.get(i) <= nums.get(j).
     * An Arraylist nums is monotone decreasing if for all i <= j, nums.get(i) >= nums.get(j). 
     * Given an integer Arraylist nums, return true if the given list is monotonic, or false otherwise.
     * Sample Input 1: 
     * nums = [1,2,2,3]
     * Sample Output 1: true
     * Sample Input 2: 
     * nums = [6,5,4,4]
     * Sample Output 2: true
     * Sample Input 3: 
     * nums = [1,3,2]
     * Sample Output 3: false
     */
 
}
