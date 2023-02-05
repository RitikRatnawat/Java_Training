import java.util.Scanner;

public class IfElse {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {

        while(true)
        {
            System.out.print("Enter Your Age : ");
            int age = sc.nextInt();

            if (age >= 1 && age <= 12)
                System.out.println("The person is still a Children.");
            else if (age >= 13 && age <= 17)
                System.out.println("The person is a Teenager.");
            else if (age >= 18 && age < 65)
                System.out.println("The person is Adult now.");
            else if (age >= 65)
                System.out.println("The person is Old adult.");
            else if(age == 0)
                break;
        }

        sc.close();
    }
}