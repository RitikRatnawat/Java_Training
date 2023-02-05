import java.util.Scanner;

public class SwitchCase
{
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        while(true)
        {
            System.out.print("Enter a Character : ");
            String character = sc.next();

            if(character.equals("exit") || character.equals("Exit") || character.equals("EXIT"))
                break;

            char c = character.charAt(0);

            switch (c) {
                case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U':
                    System.out.println(c + " is a Vowel");
                    break;

                default:
                    System.out.println(c + " is a Consonant");
                    break;
            }
        }

        sc.close();
    }
}
