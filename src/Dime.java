/**
 * Dime class overrides abstract coin
 * @version 3/26/2026
 * @author 28mehta
 */

public class Dime extends Coin {

    @Override
    public double getValue() {
        return 0.10;
    }

    @Override
    public String getName() {
        return "Dime";
    }
}
