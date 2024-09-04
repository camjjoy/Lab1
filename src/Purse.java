//Lab One 9/4/24
import java.util.HashMap;
import java.util.Map;

public class Purse
{
    //represents the money in the purse
    HashMap<Register.Denomination, Integer> cash = new HashMap<Register.Denomination, Integer>();

    public void add(Register.Denomination type, int num)//adds a num of a particular denomination
    {
        cash.put(type, cash.getOrDefault(type, 0) + num);
    }

    public Double remove(Register.Denomination type, int num)//removes money then returns that amount
    {
        if (cash.containsKey(type) && cash.get(type) >= num)
        {
            cash.put(type, cash.get(type) - num);
        }
        return type.amt() * num;
    }

    public double getValue()//returns the amount of $$ in purse
    {
        return cash.entrySet().stream().
                mapToDouble(entry -> entry.getKey().
                        amt() * entry.getValue()).sum();
    }

    //had to make this to properly return the denominations to purse and not just the value
    public Map<Register.Denomination, Integer> getDenominations()
    {
        return cash;
    }

    public String toString()//returns a string representation of the Purse and its contents
    {
        StringBuilder str = new StringBuilder();

        //Empty Purse
        if (cash.isEmpty() || cash.values().stream().allMatch(value -> value <= 0))
        {
            return "Empty purse";
        }

        cash.entrySet().stream()
                .filter(entry -> entry.getValue() > 0) //if value is greater than 0
                .forEach(entry -> str.append(entry.getValue()).append(" ")
                        .append(entry.getKey().name()).append(" (")
                        .append(entry.getKey().amt()).append(")\n"));


        return str.toString();
    }

}



