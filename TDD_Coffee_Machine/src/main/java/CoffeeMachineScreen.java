public class CoffeeMachineScreen {

    private final StringBuilder messageToDisplay = new StringBuilder();

    public String getMessageToDisplay(DrinkCommand command) {
        messageToDisplay.append("Drink maker makes 1 ");
        if (command.isExtraHot()) {
            messageToDisplay.append("extra hot ");
        }
        messageToDisplay.append(getTypeOfDrinkPart(command.getDrink()));
        if (isHotDrink(command)) {
            messageToDisplay.append(" with ");
            messageToDisplay.append(getNumberOfSugar(command.getNumberOfSugar()));
            messageToDisplay.append(getIfStick(command.getNumberOfSugar(), command.isWithTouillette()));
        }
        return String.valueOf(messageToDisplay);
    }

    private String getTypeOfDrinkPart(Drink drink) {
        return drink.name();
    }

    private String getNumberOfSugar(int numberOfSugar) {
        return numberOfSugar == 0 ? "no sugar" : numberOfSugar == 1 ? "1 sugar" : numberOfSugar + " sugars";
    }

    private String getIfStick(int numberOfSugar, boolean isWithTouillette) {
        if (numberOfSugar > 0 && !isWithTouillette) {
            return " and no stick";
        }
        if (numberOfSugar > 0) {
            return " and a stick";
        }
        return " - and therefore no stick";
    }

    private boolean isHotDrink(DrinkCommand command) {
        return command.getDrink().isHotDrink();
    }
}
