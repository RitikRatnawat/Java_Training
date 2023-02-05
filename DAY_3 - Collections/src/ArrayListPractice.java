import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListPractice
{
    public static void main(String[] args)
    {
        ArrayList<String> names = new ArrayList<>();
        names.add("Rohan");
        names.add("Shreya");
        names.add("Riya");
        names.add("Vikram");
        names.add("Utkarsh");
        names.add("Aman");

        Iterator<String> iterator = names.iterator();

        while(iterator.hasNext())
        {
            System.out.print(iterator.next() + " ");
        }

        names.set(2, "Yash");
        names.remove("Aman");
        System.out.println();

        for(int i = 0; i < names.size(); i++)
        {
            System.out.print(names.get(i) + " ");
        }
    }
}