public class Coffee extends Drink {

    @Override
    public String name() {
        return "coffee";
    }

    @Override
    public String acronym() {
        return "C";
    }

    @Override
    public double price() {
        return 0.6;
    }

    @Override
    public boolean isHotDrink() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
