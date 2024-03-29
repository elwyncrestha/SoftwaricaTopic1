package com.softwarica.topic1.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Elvin Shrestha on 14/11/19
 */
public class ExpressionEvaluator {

    private static Stack<Character> operatorStack = new Stack<>();
    private static Stack<Double> operandStack = new Stack<>();
    private static Map<Character, Integer> operatorMap = new HashMap<>();

    static {
        operatorMap.put('-', 1);
        operatorMap.put('+', 1);
        operatorMap.put('*', 2);
        operatorMap.put('/', 3);
        operatorMap.put('%', 4);
    }

    public static String evaluate(String expression) {
        int nextChar = 0;
        double oldOperand = 0;
        while (nextChar < expression.length()) {
            char ch = expression.charAt(nextChar);
            if (operatorMap.containsKey(ch)) {
                oldOperand = 0;
                if (operatorStack.isEmpty()) {
                    operatorStack.push(ch);
                    nextChar++;
                } else {
                    int oPrecedence;
                    try {
                        oPrecedence = operatorMap.get(operatorStack.peek());    // old
                    } catch (NullPointerException e) {
                        oPrecedence = 0;
                    }
                    int cPrecedence = operatorMap.get(ch);  // current
                    if (cPrecedence > oPrecedence) {
                        operatorStack.push(ch);
                        nextChar++;
                    } else {
                        popOperatePush();
                    }
                }
            } else if (ch == '(') {
                oldOperand = 0;
                operatorStack.push(ch);
                nextChar++;
            } else if (ch == ')') {
                oldOperand = 0;
                while (operatorStack.peek() != '(')
                    popOperatePush();

                operatorStack.pop();
                nextChar++;
            } else {
                if (oldOperand != 0) {
                    operandStack.push(operandStack.pop() * 10 + Double.parseDouble(String.valueOf(ch)));
                } else {
                    operandStack.push(Double.parseDouble(String.valueOf(ch)));
                }
                oldOperand = operandStack.peek();
                nextChar++;
            }
        }

        while (operatorStack.size() != 0)
            popOperatePush();

        return String.valueOf((int)Math.floor(operandStack.peek()));
    }

    private static void popOperatePush() {
        double num2 = operandStack.pop();
        char operator = operatorStack.pop();
        double num1 = operandStack.pop();
        double finalValue;

        switch (operator) {
            case '+':
                finalValue = num1 + num2;
                break;
            case '-':
                finalValue = num1 - num2;
                break;
            case '*':
                finalValue = num1 * num2;
                break;
            case '/':
                finalValue = num1 / num2;
                break;
            case '%':
                finalValue = num1 % num2;
                break;
            default:
                finalValue = 0;
                break;
        }

        operandStack.push(finalValue);
    }

    public static void main(String[] args) {
        System.out.println(evaluate("1+2"));
    }

}
