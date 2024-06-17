package ds.basics;

import static ds.helper.Helper.*;

import java.util.Scanner;

class Basics{

    public static void main(String[] args) {
        decimalToBinary(10);
        decimalToBinary(0);
        decimalToBinary(5);
        decimalToBinary(16);
        decimalToBinary(20);
    }

    // TEST METHOD
    static void printTest(){




    }




    // FACTORIAL OF A GIVEN METHOD
    static void factorialOfANumber(int givenNumber){
        printDashes();

        if(givenNumber<0){
            System.out.println("Cannot find factorial of givenNumber -> " + givenNumber);
            return;
        }

        int factorial = 1;
        for (int i=1;i<=givenNumber;i++){
            factorial = factorial*i;
        }

        System.out.println("Factorial of givenNumber " + givenNumber + " is -> " + factorial);

        printDashes();
    }


    // PRINT SUM OF EVEN AND ODD NUMBERS
    static void printSumOfEvenAndOddNumbers(){
        printDashes();

        Scanner sc = new Scanner(System.in);
        int even = 0, odd = 0;
        boolean wantToEnterAnyNumber = false;
        System.out.println("Do you want to enter any number?");
        String enterNumber = sc.next();
        if(enterNumber.toLowerCase().charAt(0) == 'y') wantToEnterAnyNumber = true;


        while(wantToEnterAnyNumber){
            System.out.println("Please enter the number");
            int numberEntered = sc.nextInt();
            if(numberEntered%2==0) even+=numberEntered;
            else odd+=numberEntered;
            System.out.println("Do you want to enter any number?");
            enterNumber = sc.next();
            if(enterNumber.toLowerCase().charAt(0) == 'n') wantToEnterAnyNumber = false;
        }
        String sumString = """
                Sum of odd numbers is %d,
                Sum of even numbers is %d
                """;
        System.out.printf(sumString,odd,even);

        printDashes();
    }



    //LEAP YEAR OR NOT
    static void leapYearOrNot(int year){
        printDashes();

        if(year%400==0){
            System.out.println(year + " is leap");
        } else{
            if(year%100==0){
                System.out.println(year + " is non leap");
            } else if(year%4==0){
                System.out.println(year + " is leap");
            } else{
                System.out.println(year + " is non leap");
            }
        }

        printDashes();
    }


    // REVERSE GIVEN NUMBER
    static void reverseGivenNumber(int givenNumber){
        printDashes();

        int reverse = 0;
        int number = givenNumber;

        while(number>0){
            reverse = reverse*10 + number%10;
            number = number/10;
        }
        
        System.out.println("Reverse of " + givenNumber + "is - " + reverse);

        printDashes();
    }


    // PRINT REVERSE OF GIVEN NUMBER
    static void printReverseOfGivenNumber(int givenNumber){
        printDashes();

        String reverseNumber = "";
        int number = givenNumber;
        while (number>0) {
            int firstDigit = number%10;
            // OR We can do w/o string also -> directly print the first digit (w/o ln)
            number = number/10;
            reverseNumber = reverseNumber + String.valueOf(firstDigit);
        }
        System.out.println("Printing reverse of " + givenNumber + " is -> " + reverseNumber);

        printDashes();
    }


    // CHECK PRIME OR NOT
    static void checkPrimeOrNot(int givenNumber){
        printDashes();

        if(givenNumber<=1) {
            System.out.println(givenNumber + " is not prime");
            return;
        }
        
        int div = 2;
        
        for (int i=div; i<=Math.sqrt(givenNumber); i++){

            if(givenNumber%i==0){
                System.out.println(givenNumber + " is not prime");
                return;
            }

        }

        System.out.println(givenNumber + " is prime");

        printDashes();
    }


    // BINARY TO DECIMAL
    static void binaryToDecimal(int binaryNumber){
        printDashes();

        int decimalNumber = 0;
        int number = binaryNumber;
        int power = 0;
        while (number>0) {
            int firstDigit = number%10;
            number = number/10;
            decimalNumber += Math.pow(2, power++)*firstDigit;
        }
        System.out.println("Decimal of binary " + binaryNumber + " is -> " + decimalNumber);

        printDashes();
    }




    // DECIMAL TO BINARY
    static void decimalToBinary(int decimalNumber){
        printDashes();

        int binaryNumber = 0;
        int number = decimalNumber;
        int power = 0;
        while (number>0) {
            int digit = number%2;
            number = number/2;
            binaryNumber = (int) (digit* Math.pow(10, power++)) + binaryNumber;
        }
        System.out.println("Binary of decimal " + decimalNumber + " is -> " + binaryNumber);

        printDashes();
    }


}




