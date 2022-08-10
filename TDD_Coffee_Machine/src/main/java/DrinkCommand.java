public class DrinkCommand {

    private final Drink drink;
    private final boolean isExtraHot;
    private final int numberOfSugar;
    private final boolean withTouillette;

    public DrinkCommand(Drink drink, int numberOfSugar, boolean withTouillette, boolean isExtraHot) {
        this.drink = drink;
        this.numberOfSugar = numberOfSugar;
        this.withTouillette = withTouillette;
        this.isExtraHot = isExtraHot;
    }

    public Drink getDrink() {
        return drink;
    }

    public boolean isExtraHot() {
        return isExtraHot;
    }

    public int getNumberOfSugar() {
        return numberOfSugar;
    }

    public boolean isWithTouillette() {
        return withTouillette;
    }

    @Override
    public String toString() {
        return "Command{" +
                "drink='" + drink + '\'' +
                ", numberOfSugar=" + numberOfSugar +
                ", withTouillette=" + withTouillette +
                '}';
    }
}
