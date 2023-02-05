import java.util.Scanner;

public class NestedIf
{
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        while(true)
        {
            boolean isLeap = false;

            System.out.print("Enter the Year : ");
            String year = sc.next();

            if(year.equals("exit") || year.equals("Exit") || year.equals("EXIT"))
                break;

            int yearInt = Integer.parseInt(year);

            if(yearInt % 4 == 0)
            {
                isLeap = true;

                if(yearInt % 100 == 0)
                {
                    isLeap = yearInt % 400 == 0;
                }
            }

            if(isLeap)
                System.out.println(yearInt + " is a Leap Year");
            else
                System.out.println(yearInt + " is not a Leap Year");
        }

        sc.close();
    }
}
