/**
 * Half dollar class overrides abstract coin
 * @version 3/26/2026
 * @author 28mehta
 */

public class Dollar extends Coin {

    @Override
    public double getValue() {
        return 1.00;
    }

    @Override
    public String getName() {
        return "Dollar";
    }
}
