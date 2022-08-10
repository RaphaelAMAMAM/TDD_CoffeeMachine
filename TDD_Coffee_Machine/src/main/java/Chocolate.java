public class Chocolate extends Drink {

    @Override
    public String name() {
        return "chocolate";
    }

    @Override
    public String acronym() {
        return "H";
    }

    @Override
    public double price() {
        return 0.5;
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
