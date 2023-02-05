import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListPractice
{
    public static void main(String[] args)
    {
        LinkedList<String> namesList = new LinkedList<>();
        namesList.add("Vijay");
        namesList.add("Ajay");
        namesList.add("Anuj");
        namesList.add("Gaurav");
        namesList.add("Harsh");
        namesList.add("Virat");
        namesList.add("Gaurav");
        namesList.add("Amit");

        Iterator<String> iterator = namesList.iterator();

        while(iterator.hasNext())
            System.out.print(iterator.next() + " ");

        namesList.addFirst("Ravi");
        namesList.addLast("Harsh");
        namesList.remove("Gaurav");
        namesList.remove("Harsh");
        System.out.println();

        for(int i = 0; i < namesList.size(); i++)
            System.out.print(namesList.get(i) + " ");
    }
}
