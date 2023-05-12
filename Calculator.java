package sdf;

public class Calculator {
    public Calculator() {
    }
    
    public Float Calculate(Float num1, String operator, Float num2) {
        if (operator.equals("+")) {
            return num1 + num2;
        }
        if (operator.equals("-")) {
            return num1 - num2;
        }
        if (operator.equals("/")) {
            return (num1 / num2);
        }
        if (operator.equals("*")) {
            return num1 * num2;
        }
        return null;
    }
    
}