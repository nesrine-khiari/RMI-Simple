import java.rmi.Naming;
import java.util.Scanner;

public class CalculatorClient {

    public static void main(String[] args) {
        try {
            Calculator calculator = (Calculator) Naming.lookup("//localhost/CalculatorService");
            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    System.out.println("Enter operation code (1: add, 2: subtract, 3: multiply, 4: divide): ");
                    int operationCode = scanner.nextInt();

                    System.out.println("Enter operand 1: ");
                    int operand1 = scanner.nextInt();

                    System.out.println("Enter operand 2: ");
                    int operand2 = scanner.nextInt();

                    int result;

                    switch (operationCode) {
                        case 1:
                            result = calculator.add(operand1, operand2);
                            break;
                        case 2:
                            result = calculator.subtract(operand1, operand2);
                            break;
                        case 3:
                            result = calculator.multiply(operand1, operand2);
                            break;
                        case 4:
                            result = calculator.divide(operand1, operand2);
                            break;
                        default:
                            System.out.println("Invalid operation code. Try again.");
                            continue;
                    }

                    System.out.println("Result: " + result);

                    System.out.println("Do you want to continue? (y/n): ");
                    String choice = scanner.next().toLowerCase();

                    if (!choice.equals("y")) {
                        break;
                    }
                }
            }

            System.out.println("Client stopped.");

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

