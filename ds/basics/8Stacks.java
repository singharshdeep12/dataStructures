package ds.basics;

import java.util.ArrayList;
import java.util.Stack;
import static ds.helper.Helper.*;

class StackUsingArrayList {

    private static ArrayList<Integer> stack;
    // private static Integer top = -1;

    StackUsingArrayList(){
        stack = new ArrayList<>();
    }


    boolean isEmpty(){
        return stack.size()==0;
    }


    void push(Integer data){
        stack.add(data);
        printStack();
    }

    Integer pop(){
        if(isEmpty()){
            System.out.println("STACK IS EMPTY, CANNOT POP");
            return null;
        }
        int data = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        printStack();
        return data;
    }

    Integer peek(){
        if(isEmpty()){
            System.out.println("STACK IS EMPTY, CANNOT PEEK");
            return null;
        }
        return stack.get(stack.size()-1);
    }

    void printStack(){
        stack.forEach((element) -> System.out.print(element + " -> "));
        System.out.println("end of stack");
    }

}


class StackUsingLinkedList {

    public static class Node{
        int data;
        Node next;
    }

    static Node head = null;

    boolean isEmpty(){
        return head == null;
    }

    void printStack(){
        Node current = head;
        while(current!=null){
            System.out.print( current.data + " -> ");
            current = current.next;
        }
        System.out.println();
    }

    void push(int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        head = newNode;

        printStack();
    }

    Integer pop(){

        if(isEmpty()){
            System.out.println("STACK IS EMPTY, CANNOT POP");
            return null;
        }

        int data = head.data;
        head = head.next;

        printStack();

        return data;
    }

    Integer peek(){

        if(isEmpty()){
            System.out.println("STACK IS EMPTY, CANNOT PEEK");
            return null;
        }

        int data = head.data;
        return data;
    }




}




class StackMainClass {

    public static void main(String[] args) {
        // StackUsingArrayList stack = new StackUsingArrayList();
        // StackUsingLinkedList stack = new StackUsingLinkedList();
        Stack<Integer> stack = new Stack<>();
        // stack.pop();
        // stack.peek();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.forEach((element) -> System.out.print(element + " -> "));
        System.out.println();

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());

        System.out.println(stack.peek());

        stack.push(5);

        stack.forEach((element) -> System.out.print(element + " -> "));
        System.out.println();

        StackQuestions.pushAtBottomOfStack(stack, 100);
        stack.forEach((element) -> System.out.print(element + " -> "));
        System.out.println();

        stack.push(500);
        stack.forEach((element) -> System.out.print(element + " -> "));
        System.out.println();

        // StackQuestions.reverseStringUsingStack("arsh");

        // StackQuestions.reverseAStackBruteForce(stack);
        // System.out.println("Reversed stack is -> ");
        // StackQuestions.reversedStack.push(87);
        // StackQuestions.reversedStack.forEach((element) -> System.out.print(element + " -> "));
        // System.out.println();


        // StackQuestions.reverseAStackOptimal(stack);
        // System.out.println("Reversed stack is -> ");
        // stack.push(87);
        // stack.forEach((element) -> System.out.print(element + " -> "));
        // System.out.println();

        // int[] inputArray = {100,80,60,70,60,85,100};
        // StackQuestions.stockSpanProblem(inputArray);

        int[] inputArray = {2,1,5,6,2,3};
        // StackQuestions.nextGreaterElement(inputArray);
        // StackQuestions.nextSmallElementLeft(inputArray);


    }




}


class StackQuestions {


    static void pushAtBottomOfStack(Stack<Integer> stack, int data){
        pushBottomHelper(stack,data);
    }

    private static void pushBottomHelper(Stack<Integer> stack, int data){
        if(stack.empty()){
            stack.push(data);
            return;
        }
        int stackPop = stack.pop();
        pushBottomHelper(stack, data);
        stack.push(stackPop);
    }


    static void reverseStringUsingStack(String data){
        char[] dataArray = data.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<dataArray.length; i++){
            stack.push(dataArray[i]);
        }
        String reverseData = "";
        while (!stack.empty()) {
            reverseData = reverseData + stack.pop();
        }
        System.out.println("Reversed string is -> " + reverseData);
    }


    static void reverseAStackBruteForce(Stack<Integer> stack){
        reverseStackHelperBruteForce(stack);
    }

    static Stack<Integer> reversedStack = new Stack<>();

    private static void reverseStackHelperBruteForce(Stack<Integer> stack){

        if(stack.empty()) return;
        // int top = stack.pop();
        reversedStack.push(stack.pop());
        reverseStackHelperBruteForce(stack);
    }

    static void reverseAStackOptimal(Stack<Integer> stack){
        reverseStackHelperOptimal(stack);
    }

    private static void reverseStackHelperOptimal(Stack<Integer> stack) {
        if(stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        reverseStackHelperOptimal(stack);
        pushAtBottomOfStack(stack, top);
    }



    public static void stockSpanProblem(int[] inputArray){
        int inputLength = inputArray.length;
        int[] span = new int[inputLength];
        Stack<Integer> stack = new Stack<>();
        span[0] = 1;
        stack.push(0);

        for(int i=1; i<inputLength; i++){
            while(!stack.empty() && inputArray[stack.peek()] <= inputArray[i]){
                stack.pop();
            }
            if(stack.empty()){
                span[i] = i;
                stack.push(i);
                continue;
            }
            span[i] = i-stack.peek();
            stack.push(i);
        }

        printArray("The input array is ", inputArray);
        printArray("The span for input array is ", span);
        


    }


    public static void nextGreaterElement(int[] inputArray){

        int length = inputArray.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(inputArray[length-1]);
        int[] nextGreater = new int[length];
        nextGreater[length-1] = -1;  

        for(int i=length-2;i>=0;i--){
            while(!stack.empty() && stack.peek()<inputArray[i]){
                stack.pop();
            }
            if(stack.empty()){
                nextGreater[i] = -1;
                stack.push(inputArray[i]);
                continue;
            }
            nextGreater[i] = stack.peek();
            stack.push(inputArray[i]);
        }



        printArray("The input array is ", inputArray);
        printArray("The next greater for input array is ", nextGreater);

    }


    public static int[] nextSmallElementLeft(int[] inputArray){

        int length = inputArray.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] nextSmallLeftIndex = new int[length];
        nextSmallLeftIndex[0] = -1;

        for(int i=1;i<=length-1;i++){
            while(!stack.empty() && inputArray[stack.peek()]>inputArray[i]){
                stack.pop();
            }
            if(stack.empty()){
                nextSmallLeftIndex[i] = -1;
                stack.push(i);
                continue;
            }
            nextSmallLeftIndex[i] = stack.peek();
            stack.push(i);
        }


        printArray("The input array is ", inputArray);
        printArray("The next smaller left for input array is ", nextSmallLeftIndex);

        return nextSmallLeftIndex;

    }


    public static int[] nextSmallElementRight(int[] inputArray){

        int length = inputArray.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(length-1);
        int[] nextSmallLeftIndex = new int[length];
        nextSmallLeftIndex[length-1] = length;  

        for(int i=length-2;i>=0;i--){
            while(!stack.empty() && inputArray[stack.peek()]>inputArray[i]){
                stack.pop();
            }
            if(stack.empty()){
                nextSmallLeftIndex[i] = length;
                stack.push(i);
                continue;
            }
            nextSmallLeftIndex[i] = stack.peek();
            stack.push(i);
        }


        printArray("The input array is ", inputArray);
        printArray("The next smaller right for input array is ", nextSmallLeftIndex);

        return nextSmallLeftIndex;

    }




    // https://takeuforward.org/data-structure/area-of-largest-rectangle-in-histogram/
    public static void bruteForceLargestAreaInHistogram(int[] array){

        int length = array.length;
        
        int maxArea = 0;

        for(int i=0; i<length; i++){
            int minHeight = Integer.MAX_VALUE;
            for(int j=i; j<length; j++){
                minHeight = Math.min(minHeight, array[j]);
                maxArea = Math.max(maxArea, (minHeight*(j-i+1)));
            }

        }

        printArray("The input array is ", array);
        System.out.println("The max area is " + maxArea);
    }


    public static void largestAreaInHistogram(int[] array){

        int[] nsl = nextSmallElementLeft(array);

        int[] nsr = nextSmallElementRight(array);

        int[] maxArea = new int[array.length];

        for(int i =0; i<array.length; i++){
            maxArea[i] = array[i] * (nsr[i]-nsl[i]-1);
        }

        printArray("The input array is ", array);
        printArray("The max area for input array is ", maxArea);


    }



}