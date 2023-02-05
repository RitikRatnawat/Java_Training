import java.util.Iterator;
import java.util.Stack;

public class StackPractice
{
    public static void main(String[] args)
    {
        Stack<Character> reverseString = new Stack<>();
        String str = "It is a Stack";

        for(int i = 0; i < str.length(); i++)
            reverseString.push(str.charAt(i));

        System.out.println(reverseString.peek());

        while(!reverseString.empty())
            System.out.print(reverseString.pop());
    }
}
