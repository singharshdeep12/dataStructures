package ds.basics;

import static ds.helper.Helper.*;

class TwoDimensionalArrays {

    public static void main(String[] args) {

        int[][] matrix = new int[2][5];

        //matrix.length will give us no of rows
        //matrix[0].length will give is no of columns

        //searching an element in matrix by using normal 2 for loops

        //usually memory of 2d arrays storage could be row major OR column major (both with contiguous addresses)

        //But in Java no of rows (n) -> n number of arrays are created (no contiguous addresses of these row arrays)

        int rows = matrix.length;
        int columns = matrix[0].length;
        int start = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                matrix[i][j] = start+=10;
            }
        }

        printMultiDimArray(matrix);

//        printSpiralMatrix(matrix, rows, columns);

//        diagonalSum(matrix, columns);

//        searchInSortedMatrix_StaircaseSearch(matrix,221);

        transposeOfMatrix(matrix);
    }


    public static void printSpiralMatrix(int[][] matrix, int rows, int columns){

        printDashes();


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


        printDashes();

    }

    /*
     * Diagonal sum = Primary Diagonal Sum + Secondary diagonal sum - overlapping elements (in case of n is odd)
     * only for rows=columns, find primary and secondary diagonal sum
     * This below solution is for O(n)
     * We can also do this by Brute force -> O(n^2) by traversing each element in 2 for loops & adding sum of both diagonals
    */
    public static void diagonalSum(int [][] matrix, int n){

        printDashes("Diagonal Sum");

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

        printDashes();

    }

    /*
     * Search in sorted matrix (sorted both row wise and column wise)
     *
     * 1st way -> Using Brute force O(n^2) -> traverse each element and match.
     *
     * 2nd way (this method) ->
     * Search each row using binary search O(n * log(m))
     * n for no of rows & log(m) for each row binary search
     *
     * 3rd way (next method) -> Staircase Search
     */
    public static void searchInSortedMatrix_RowWiseSearch(int[][] matrix, int key){
        printDashes("searchInSortedMatrix_RowWiseSearch");
        boolean flag = false;
        for(int i=0; i<matrix.length; i++){

            int rowLength = matrix[i].length;
            int startIndex = 0, endingIndex = rowLength-1;

            while(endingIndex>=startIndex){
                int searchIndex = (endingIndex+startIndex)/2;
                int currentElement = matrix[i][startIndex];
                if(currentElement == key){
                    System.out.println("Element found at index -> " + i + "," + searchIndex);
                    flag = true;
                    break;
                }
                if(currentElement>key){
                    endingIndex = searchIndex-1;
                    continue;
                }
                if(currentElement<key){
                    startIndex = startIndex+1;
                }
            }

            if(flag) break;


        }

        if(!flag) System.out.println("Element not found");
        printDashes();
    }


    /*
     * Search in sorted matrix (sorted both row wise and column wise)
     *
     * 3rd way (next method) -> Staircase Search
     *
     * - We can start from either arr[0,m-1] or arr[n-1,0]
     * - We need to search and progress in a staircase manner
     * - If start_key = arr[0,m-1] -> 2 conditions either key > than this or <
     *   if(key > start_key) then move downwards => start_key = arr[1,m-1]
     *   if(key < start_key) then move leftwards => start_key = arr[0,m-2]
     *
     * - Code below for above start_key
     * - For start_key = arr[n-1,0] -> move rightwards or up accordingly
     *
     * Time complexity
     * if (n>>m) -> O(n)
     * if (n<<m) -> O(m)
     * else worst case -> O(n+m)  -> you are climbing each and every stair to reach the other end of diagonal
     *
     */
    public static void searchInSortedMatrix_StaircaseSearch(int[][] matrix, int key){
        printDashes("searchInSortedMatrix_StaircaseSearch");

        boolean flag = false;
        int startRowIndex = 0;
        int startColumnIndex = matrix[0].length-1;

        while(true){  //condition can be given here also for checking row/cols
            int startKey = matrix[startRowIndex][startColumnIndex];
            if(key==startKey){
                System.out.println("Key found at index-> " + startRowIndex + "," + startColumnIndex);
                flag=true;
                break;
            }
            if(key>startKey){
                startRowIndex++;
                if(startRowIndex>= matrix.length){break;}
            }
            if(key<startKey){
                startColumnIndex--;
                if(startColumnIndex<0){break;}
            }
        }
        if(!flag) System.out.println("Element not found in matrix");
        printDashes();
    }

    /*
     * Transpose of a matrix is the process of swapping the rows to columns.
     * Rows become columns and columns become rows
     */
    public static void transposeOfMatrix(int[][] matrix){
        printDashes("transposeOfMatrix");

        int[][] transposeMatrix = new int[matrix[0].length][matrix.length];

        for(int i=0;i< matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                transposeMatrix[j][i] = matrix[i][j];
            }
        }
        System.out.println("For given matrix below -> ");
        printMultiDimArray(matrix);

        System.out.println("Below is the transpose matrix -> ");
        printMultiDimArray(transposeMatrix);

        printDashes();
    }




}
