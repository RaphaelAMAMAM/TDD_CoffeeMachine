public class OrangeJuice extends Drink{
    @Override
    public String name() {
        return "orange juice";
    }

    @Override
    public String acronym() {
        return "O";
    }

    @Override
    public double price() {
        return 0.6;
    }

    @Override
    public boolean isHotDrink() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
