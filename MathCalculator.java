import java.util.*;

public class MathCalculator {

    // Function to calculate GCD using Euclidean algorithm
    public static int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calculateGCD(b, a % b);
    }

    // Function to calculate LCM using GCD
    public static int calculateLCM(int a, int b) {
        return (a * b) / calculateGCD(a, b);
    }

    // Function to calculate prime factors
    public static List<Integer> primeFactors(int n) {
        List<Integer> factors = new ArrayList<>();

        // Divide by 2 until n is odd
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }

        // n must be odd at this point, so we can skip one element (i = i + 2)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        // If n is a prime greater than 2, add it to the factors
        if (n > 2) {
            factors.add(n);
        }

        return factors;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        // Calculate and display GCD
        int gcd = calculateGCD(num1, num2);
        System.out.println("GCD of " + num1 + " and " + num2 + " is " + gcd);

        // Calculate and display LCM
        int lcm = calculateLCM(num1, num2);
        System.out.println("LCM of " + num1 + " and " + num2 + " is " + lcm);

        // Calculate and display prime factors
        List<Integer> factors1 = primeFactors(num1);
        List<Integer> factors2 = primeFactors(num2);
        System.out.println("Prime factors of " + num1 + " are: " + factors1);
        System.out.println("Prime factors of " + num2 + " are: " + factors2);

        scanner.close();
    }
}