//Lab One 9/4/24
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Register
{
    public static void main(String[] args)//creates register
    {
        Register register = new Register();

        System.out.println("please enter the amount you would like to get change for: ");
        Scanner sc = new Scanner(System.in);

        double amt = sc.nextDouble();

        Purse purse = makeChange(amt);

        System.out.println(purse);
        System.out.println("Total Value: $" + purse.getValue());
    }

    public static Purse makeChange(Double amt)//takes the amt and returns a Purse containing the amt in proper form
    {
        Purse purse = new Purse();

        // Bills (dollars part)
        int bills = amt.intValue();  // Extract the whole dollar amount

        int fifties = bills / 50;
        bills %= 50;
        purse.add(new Denomination("FiftyNote", 50, "bill", "FiftyNote.png"), fifties);

        int twenties = bills / 20;
        bills %= 20;
        purse.add(new Denomination("TwentyNote", 20, "bill", "TwentyNote.png"), twenties);

        int tens = bills / 10;
        bills %= 10;
        purse.add(new Denomination("TenNote", 10, "bill", "TenNote.png"), tens);

        int fives = bills / 5;
        bills %= 5;
        purse.add(new Denomination("FiveNote", 5, "bill", "FiveNote.png"), fives);

        int ones = bills;
        purse.add(new Denomination("OneNote", 1, "bill", "OneNote.png"), ones);

        // Cents (fractional part)
        int cents = (int) Math.round((amt - amt.intValue()) * 100);  // Extract the cents

        int quarters = cents / 25;
        cents %= 25;
        purse.add(new Denomination("Quarter", 0.25, "coin", "Quarter.png"), quarters);

        int dimes = cents / 10;
        cents %= 10;
        purse.add(new Denomination("Dime", 0.10, "coin", "Dime.png"), dimes);

        int nickels = cents / 5;
        cents %= 5;
        purse.add(new Denomination("Nickel", 0.05, "coin", "Nickel.png"), nickels);

        int pennies = cents;
        purse.add(new Denomination("Penny", 0.01, "coin", "Penny.png"), pennies);

        return purse;
    }

    //I put my denomination here, it just worked better for me like that
    public record Denomination(String name, double amt, String form, String img)
    {
    }

    List<Denomination> register = new ArrayList<Denomination>();

    Denomination fiftyNote = new Denomination("FiftyNote", 50, "bill", "FiftyNote.png");
    Denomination twentyNote = new Denomination("TwentyNote", 20, "bill", "TwentyNote.png");
    Denomination tenNote = new Denomination("TenNote", 10, "bill", "TenNote.png");
    Denomination fiveNote = new Denomination("FiveNote", 5, "bill", "FiveNote.png");
    Denomination quarter = new Denomination("Quarter", 0.25, "coin", "Quarter.png");
    Denomination dime = new Denomination("Dime", 0.10, "coin", "Dime.png");
    Denomination nickle = new Denomination("Nickle", 0.05, "coin", "Nickle.png");
    Denomination penny = new Denomination("Penny", 0.05, "coin", "Penny.png");



}
