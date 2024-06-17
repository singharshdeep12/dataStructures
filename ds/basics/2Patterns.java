package ds.basics;

import static ds.helper.Helper.*;

/*

3 things to look at - 
1. no of rows/lines to print? - outer loop (i)
2. no of times to print in each line? - inner loop (j)
3. what to print? (*)

 */


class Patterns {

    public static void main(String[] args) {
        characterPattern(0);
        characterPattern(1);
        characterPattern(2);
        characterPattern(3);
        characterPattern(4);
    }


/* SQUARE PATTERN

*****
*****
*****
*****
*****        

    
*/

     static void squarePattern(int lines){
        printDashes();

        for (int i=0;i<lines;i++){
            for(int j=0;j<lines;j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }

        printDashes();
     }






/* STAR PATTERN

*
**
***
****
*****        

    
*/

static void starPattern(int lines){
    printDashes();

    for (int i=0;i<lines;i++){
        for(int j=0;j<=i;j++){
            System.out.print("*");
        }
        System.out.print("\n");
    }

    printDashes();
 }





/* INVERTED STAR PATTERN

*****
****
***
**
*        

    
*/

static void invertedStarPattern(int lines){
    printDashes();

    for (int i=0;i<lines;i++){
        for(int j=0;j<lines-i;j++){
            System.out.print("*");
        }
        System.out.print("\n");
    }

    printDashes();
 }





/* HALF PYRAMID PATTERN

1
12
123
1234
12345       

    
*/

static void halfPyramidPattern(int lines){
    printDashes();

    for (int i=0;i<lines;i++){
        for(int j=0;j<=i;j++){
            System.out.print(j+1);
        }
        System.out.print("\n");
    }

    printDashes();
 }





/* CHARACTER PATTERN

A
BC
DEF
GHIJ       

    
*/

static void characterPattern(int lines){
    printDashes();
    char a = 'A';
    for (int i=0;i<lines;i++){
        for(int j=0;j<=i;j++){
            System.out.print((a++));
        }
        System.out.print("\n");
    }

    printDashes();
 }



    
}
