public class Tea extends Drink{
    @Override
    public String name() {
        return "tea";
    }

    @Override
    public String acronym() {
        return "T";
    }

    @Override
    public double price() {
        return 0.4;
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
