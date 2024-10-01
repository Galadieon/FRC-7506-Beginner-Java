import java.util.Scanner;

public class Calculator {
    private final String operators = "+-*/^";
    private double num1 = 0.0, num2 = 0.0;
    private Scanner in = new Scanner(System.in);

    public Calculator() {
        println("Welcome to the calculator!");
        println("Enter 'exit' to quit.");
    }

    public void run() {
        char operator;
        while (true) {
            num1 = getValidDouble("Enter an number: ");
            operator = getValidOperator("Enter an operator (" + operators + "): ");
            num2 = getValidDouble("Enter another number: ");
            try {
                println("Result: " + calculate(operator));
            } catch (Exception e) {
                println("Invalid expression. Please try again.");
            }
        }
    }

    private double calculate(char op) {
        switch (op) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/': return num1 / num2;
            case '^': return Math.pow(num1, num2);
            default: return 0;
        }
    }

    public void exit() {
        println("Goodbye!");
        System.exit(0);
    }

    private char getValidOperator(String prompt) {
        String temp;
        char input = ' ';
        while (true) {
            print(prompt);
            try {
                temp = in.nextLine();
                if (temp.equals("exit")) {
                    exit();
                }
                input = temp.charAt(0);
                if (operators.indexOf(input) != -1) {
                    return input;
                }
                throw new Exception();
            } catch (Exception e) {
                println("Invalid input. Please enter a valid operator.");
            }
        }
    }

    private double getValidDouble(String prompt) {
        String temp;
        double input = Double.MIN_VALUE;
        while (input == Double.MIN_VALUE) {
            try {
                print(prompt);
                temp = in.nextLine();
                if (temp.equals("exit")) {
                    exit();
                }
                input = Double.parseDouble(temp);
            } catch (Exception e) {
                println("Invalid input. Please enter a valid number.");
            }
        }
        return input;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.run();
    }

    public static void print(Object obj) {System.out.print(obj);}
    public static void println(Object obj) {System.out.println(obj);}
}