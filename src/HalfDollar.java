/**
 * Half dollar class overrides abstract coin
 * @version 3/26/2026
 * @author 28mehta
 */

public class HalfDollar extends Coin {

    @Override
    public double getValue() {
        return 0.50;
    }

    @Override
    public String getName() {
        return "Half Dollar";
    }
}
