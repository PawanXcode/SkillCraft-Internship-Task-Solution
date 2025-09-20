import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter temperature value:");
        double temp = sc.nextDouble();

        System.out.println("Enter the scale of input (C/F/K): ");
        char scale = sc.next().toUpperCase().charAt(0);

        if (scale == 'C') {
            System.out.println("Celsius: " + temp);
            System.out.println("Fahrenheit: " + (temp * 9 / 5 + 32));
            System.out.println("Kelvin: " + (temp + 273.15));
        } else if (scale == 'F') {
            double c = (temp - 32) * 5 / 9;
            System.out.println("Celsius: " + c);
            System.out.println("Fahrenheit: " + temp);
            System.out.println("Kelvin: " + (c + 273.15));
        } else if (scale == 'K') {
            double c = temp - 273.15;
            System.out.println("Celsius: " + c);
            System.out.println("Fahrenheit: " + (c * 9 / 5 + 32));
            System.out.println("Kelvin: " + temp);
        } else {
            System.out.println("Invalid scale entered!");
        }

        sc.close();
    }
}
