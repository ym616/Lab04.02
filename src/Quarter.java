/**
 * Quarter class overrides abstract coin
 * @version 3/26/2026
 * @author 28mehta
 */

public class Quarter extends Coin {

    @Override
    public double getValue() {
        return 0.25;
    }

    @Override
    public String getName() {
        return "Quarter";
    }
}
