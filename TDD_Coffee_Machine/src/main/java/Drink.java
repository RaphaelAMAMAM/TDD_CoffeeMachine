public abstract class Drink {
    public abstract String name();
    public abstract String acronym();
    public abstract double price();
    public abstract boolean isHotDrink();


    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name() + "'" +
                "price='" + price() + "'}";
    }
}
