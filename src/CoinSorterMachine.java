import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

/**
 * Manages the importing sorting, and adding of recognized coins.
 * @author 28mehta
 * @version 2026-04-01
 */
public class CoinSorterMachine {
    private ArrayList<Coin> coins;
    private HashMap<Integer, Coin> coinTypes;
    private HashMap<Coin, Integer> coinCounts;
    private String fileName;

    /**
     * initializes the  maps and prompts for the input file.
     */
    public CoinSorterMachine() {
        coins = new ArrayList<>();
        coinCounts = new LinkedHashMap<>();
        coinTypes = new HashMap<>();


        coinTypes.put(1, new Penny());
        coinTypes.put(5, new Nickel());
        coinTypes.put(10, new Dime());
        coinTypes.put(25, new Quarter());
        coinTypes.put(50, new HalfDollar());
        coinTypes.put(100, new Dollar());


        coinCounts.put(coinTypes.get(1), 0);
        coinCounts.put(coinTypes.get(5), 0);
        coinCounts.put(coinTypes.get(10), 0);
        coinCounts.put(coinTypes.get(25), 0);
        coinCounts.put(coinTypes.get(50), 0);
        coinCounts.put(coinTypes.get(100), 0);

        Scanner console = new Scanner(System.in);
        System.out.print("Enter the name of the data file for coin deposit or 0 to quit: ");
        fileName = console.nextLine();
    }

    /**
     * reads coin data from the specified file and sorts them.
     */
    public void depositCoins() {
        if (fileName.equals("0")) return;

        System.out.println("Depositing coins...");
        try {
            Scanner fileScanner = new Scanner(new File(fileName));
            while (fileScanner.hasNext()) {
                if (fileScanner.hasNextInt()) {
                    int val = fileScanner.nextInt();
                    if (coinTypes.containsKey(val)) {
                        Coin c = coinTypes.get(val);
                        coins.add(c);
                        coinCounts.put(c, coinCounts.get(c) + 1);
                    } else {
                        System.out.println("Coin value " + val + " not recognized");
                    }
                } else {
                    fileScanner.next();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    /**
     * prints summary of all coins deposited and the total value.
     */
    public void printDepositSummary() {
        DecimalFormat df = new DecimalFormat("$0.00");
        System.out.println("Summary of deposit:");

        for (Coin c : coinCounts.keySet()) {
            int count = coinCounts.get(c);
            double value = count * c.getValue();
            System.out.printf("%d %-13s %s\n", count,
                    (count == 1 ? c.getName() : c.getPluralName()),
                    df.format(value));
        }

        System.out.println("TOTAL DEPOSIT: " + df.format(getTotalValue()));
    }

    /**
     * calculates the total value of all coins in the list.
     * @return total double value
     */
    public double getTotalValue() {
        double total = 0;
        for (Coin c : coins) {
            total += c.getValue();
        }
        return total;
    }

    /**
     * entry point for application
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        CoinSorterMachine app = new CoinSorterMachine();
        app.depositCoins();
        app.printDepositSummary();
    }
}