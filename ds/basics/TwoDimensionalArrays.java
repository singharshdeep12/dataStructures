package ds.basics;

import static ds.helper.Helper.*;

import java.util.Arrays;

public class TwoDimensionalArrays {

    public static void main(String[] args) {
        
        int[][] matrix = new int[3][3];

        //matrix.length will give us no of rows
        //matrix[0].length will give is no of columns

        //searching an element in matrix by using normal 2 for loops

        //usually memory of 2d arrays storage could be row major OR column major (both with contiguous addresses)

        //But in Java no of rows (n) -> n number of arrays are created (no contiguous addresses of these row arrays)

        int rows = matrix.length;
        int columns = matrix[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                matrix[i][j] = getARandomInt(10);
            }
        }

        printMultiDimArray(matrix);
        
//        printSpiralMatrix(matrix, rows, columns);

        diagonalSum(matrix, columns);


    }


    public static void printSpiralMatrix(int[][] matrix, int rows, int columns){

        int turns = Math.min(rows, columns);

        int startRow = 0, startColumn = 0, endRow = rows-1, endColumn = columns-1;

        while(startRow<=endRow && startColumn<=endColumn){

            //Print top row
            for(int i=startColumn; i<=endColumn;i++){System.out.print(matrix[startRow][i] + " -> ");}

            //Print right column
            for(int i=startRow+1; i<=endRow;i++){System.out.print(matrix[i][endColumn] + " -> ");}

            //Print bottom row            
            if(startRow<endRow)
            for(int i=endColumn-1; i>=startColumn;i--){System.out.print(matrix[endRow][i] + " -> ");}

            //Print left column
            if(startColumn<endColumn)
            for(int i=endRow-1; i>=startColumn+1;i--){System.out.print(matrix[i][startColumn] + " -> ");}

            startColumn++; startRow++; endColumn--; endRow--;
        }

    }

    /*
     * Diagonal sum = Primary Diagonal Sum + Secondary diagonal sum - overlapping elements (in case of n is odd)
     * only for rows=columns, find primary and secondary diagonal sum
     * This below solution is for O(n)
     * We can also do this by Brute force -> O(n^2) by traversing each element in 2 for loops & adding sum of both diagonals
    */
    public static void diagonalSum(int [][] matrix, int n){

        int primaryDiagonalSum = 0, secondaryDiagonalSum = 0;

        for(int i=0;i<n;i++){
            primaryDiagonalSum+=matrix[i][i];
            secondaryDiagonalSum+=matrix[n-1-i][i];
        }

        System.out.println("Primary Diagonal Sum is -> " + primaryDiagonalSum);
        System.out.println("Secondary Diagonal Sum is -> " + secondaryDiagonalSum);

        int totalDiagonalSum = primaryDiagonalSum + secondaryDiagonalSum;

        if(isOdd(n)){
            totalDiagonalSum = totalDiagonalSum - matrix[(n-1)/2][(n-1)/2];
        }

        System.out.println("Total Diagonal Sum is -> " + totalDiagonalSum);

    }




}
