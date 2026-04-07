import java.util.Objects;

/**
 * Name: Yash Mehta
 * Date: April 4, 2026
 * abstract class representing a US Coin
 */
public abstract class Coin implements Comparable<Coin> {

    public abstract double getValue();


    public abstract String getName();


    public String getPluralName() {
        if (getName().equalsIgnoreCase("penny")) return "pennies";
        return getName() + "s";
    }


    @Override
    public int compareTo(Coin other) {
        return Double.compare(this.getValue(), other.getValue());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coin)) return false;
        Coin coin = (Coin) o;
        return Double.compare(coin.getValue(), getValue()) == 0;
    }
}