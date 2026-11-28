
import java.util.Scanner;

public class RabbitProblem {

    // Calculate rabbit pairs
    public static int rabbits(int month) {

        if (month == 1 || month == 2) {
            return 1;
        }

        return rabbits(month - 1) + rabbits(month - 2);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of months: ");
        int months = input.nextInt();

        if (months < 1) {
            System.out.println("Invalid month");
        } else {
            System.out.println("Rabbit pairs: " + rabbits(months));
        }

        input.close();
    }
}
