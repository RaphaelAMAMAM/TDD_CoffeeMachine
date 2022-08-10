import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CoffeeMachineSystem coffeeMachine = new CoffeeMachineSystem();
        System.out.println("Hey user!" +
                "\n\t Tea : 0.40€" +
                "\n\t Chocolate : 0.50€" +
                "\n\t Coffee : 0.60€" +
                "\n\t Orange juice : 0.60€" +
                "\nPlease enter your command :");

        while (true) {
            String userCommand = userInputText().toUpperCase();

            if (isAMessageCommand(userCommand) && thereIsAMessage(userCommand)) {
                System.out.println(displayMessage(userCommand));
                break;
            }

            if (isADrinkCommand(userCommand)) {
                DrinkCommand command = coffeeMachine.toDrinkCommand(userCommand);
                if (coffeeMachine.checkUserCommand(command)) {
                    System.out.println("Please put money : ");
                    double userMoney = userInputMoney();
                    if (coffeeMachine.userPutEnoughMoney(command, userMoney)) {
                        System.out.println(coffeeMachine.getMessageToDisplay(command));
                        break;
                    }
                    System.out.println("ERROR : not enough money, " +
                            coffeeMachine.missingMoney(command, userMoney) + "€ missing");
                }
            }
            System.out.println("Please retry, enter your command : ");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    private static String userInputText() {
        return scanner.nextLine();
    }

    private static boolean isADrinkCommand(String userInput) {
        String[] splitInput = toSplit(userInput);
        return !splitInput[0].equals("M");
    }

    private static boolean isAMessageCommand(String userInput) {
        String[] splitInput = toSplit(userInput);
        return splitInput[0].equals("M");
    }

    private static boolean thereIsAMessage(String userInput) {
        return toSplit(userInput).length == 2;
    }

    private static String displayMessage(String userInput) {
        return toSplit(userInput)[1];
    }

    private static String[] toSplit(String userInput) {
        return userInput.split(":");
    }

    private static double userInputMoney() {

        while (true) {
            try {
                double money = scanner.nextDouble();
                scanner.nextLine();
                return money;
            } catch (InputMismatchException e) {
                System.out.println("ERROR : not a number, please retry :");
                scanner.nextLine();
            }
        }
    }
}
