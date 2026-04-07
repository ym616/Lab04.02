/**
 * Nickel class overrides abstract coin
 * @version 3/26/2026
 * @author 28mehta
 */

public class Nickel extends Coin {

    @Override
    public double getValue() {
        return 0.05;
    }

    @Override
    public String getName() {
        return "Nickel";
    }
}
