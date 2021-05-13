package module1.java_basic;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/*
    Given a list of prices of a single stock for N number of days, find stock span for each day.
    Stock span is defined as a number of consecutive days prior to the current day when the price of a stock was
    less than or equal to the price at current day.
    For example, {100,60,70,65,80,85} span will be {1,1,2,1,4,5}.
"*/
public class StockSpan {
    public static void main(String[] args){
        int[] input = {100, 60, 70, 65, 80, 85};
        int[] span = {0, 0, 0, 0, 0, 0};
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        span[0] = 1;
        for (int i = 1; i < input.length; i++) {
            while(!stack.empty() && input[stack.peek()] < input[i]) {
                stack.pop();
            }

            span[i] = stack.empty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        System.out.println(Arrays.toString(span));
    }
}
