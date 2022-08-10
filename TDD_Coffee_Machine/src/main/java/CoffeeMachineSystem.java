import java.util.*;

public class CoffeeMachineSystem extends CoffeeMachineScreen {

    private final Map<String, Drink> drinkList;
    private final int MAX_SUGAR = 2;

    public CoffeeMachineSystem() {
        this.drinkList = new HashMap<>();
        addNewDrink("T", new Tea());
        addNewDrink("H", new Chocolate());
        addNewDrink("C", new Coffee());
        addNewDrink("O", new OrangeJuice());
    }

    public DrinkCommand toDrinkCommand(String userCommand) {
        String[] finalCommand = organiseCommand(userCommand);
        return new DrinkCommand(getDrink(finalCommand), getNumberSugar(finalCommand),
                isWithTouillette(finalCommand), isExtraHot(finalCommand));
    }

    public boolean checkUserCommand(DrinkCommand command) {
        if (!drinkExists(command)) {
            System.out.println("ERROR : This drink is not valid");
            return false;
        }

        if (!numberOfSugarIsValid(command)) {
            System.out.println("ERROR : You only can have 0 - " + MAX_SUGAR + " sugars");
            return false;
        }
        return true;
    }

    public boolean userPutEnoughMoney(DrinkCommand command, double moneyFromUser) {
        return moneyFromUser >= command.getDrink().price();
    }

    public double missingMoney(DrinkCommand command, double moneyFromUser) {
        return command.getDrink().price() - moneyFromUser;
    }

    private String[] organiseCommand(String userCommand) {
        String[] splitCommand = userCommand.split(":");
        String[] finalDrinkCommand = {"Unknown drink", "0", "-1", "0"};

        for (int i = 0; i < splitCommand.length; i++) {
            if (!splitCommand[i].equals("")) {
                finalDrinkCommand[i] = splitCommand[i];
            }

            if (isExtraHot(userCommand)) {
                String[] toGetDrinkAndExtraHot = splitCommand[0].split("");
                finalDrinkCommand[0] = toGetDrinkAndExtraHot[0];
                finalDrinkCommand[3] = toGetDrinkAndExtraHot[1];
            }
        }
        return finalDrinkCommand;
    }

    private void addNewDrink(String acronym, Drink drink) {
        drinkList.put(acronym, drink);
    }

    private Drink getDrink(String[] finalCommand) {
        return drinkList.get(finalCommand[0]);
    }

    private int getNumberSugar(String[] finalCommand) {
        int numberOfSugar = 0;
        try {
            numberOfSugar = Integer.parseInt(finalCommand[1]);
        } catch (NumberFormatException ignored) {
        }
        return numberOfSugar;
    }

    private boolean isWithTouillette(String[] finalCommand) {
        return Integer.parseInt(finalCommand[2]) == 0;
    }

    private boolean isExtraHot(String[] finalCommand) {
        return finalCommand.length == 4 && !finalCommand[3].equals("0");
    }

    private boolean isExtraHot(String userCommand) {
        String[] splitCommand = userCommand.split(":");
        String[] toSplitDrinkAndExtraHot = splitCommand[0].split("");
        return toSplitDrinkAndExtraHot.length == 2 && toSplitDrinkAndExtraHot[1].equals("H");
    }

    private boolean drinkExists(DrinkCommand command) {
        return !(command.getDrink() == null);
    }

    private boolean numberOfSugarIsValid(DrinkCommand command) {
        return !(command.getNumberOfSugar() < 0 || command.getNumberOfSugar() > MAX_SUGAR);
    }
}
