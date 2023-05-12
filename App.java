package sdf;

import java.io.Console;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Console con = System.console(); 
        Calculator calc = new Calculator();
        Float $last = 0f;
        String input = "";
        System.out.println("Welcome.");
        while (true) {
            input = con.readLine();
            if(input.equals("exit")){
                System.out.println("Bye bye");
                break;
            }
            Scanner scan = new Scanner(input);
            String strnum1 = scan.next();
            String operator = scan.next();
            String strnum2 = scan.next();
            Float num1;
            Float num2;
            if (strnum1.equals("$last")) {
                num1 = $last;
            }
            else {
                num1 = Float.parseFloat(strnum1);
            }
            if (strnum2.equals("$last")) {
                num2 = $last;
            }
            else {
                num2 = Float.parseFloat(strnum2);
            }

            $last = calc.Calculate(num1, operator, num2);
            if ($last % 1 != 0){
                System.out.println(String.format("%,.2f", $last));
            }
            else {
                System.out.println((int)($last.floatValue()));
            }
            scan.close();
        }
        
    }
}
