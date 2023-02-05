import java.util.Scanner;

public class ExceptionHandling
{
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        int[] arr = {50, 26, 98, 55, 70};

        System.out.print("Enter the Divisor : ");
        int divisor = sc.nextInt();

        try
        {
            for(int i = 0; i <= arr.length; i++)
            {
                int ans = arr[i] / divisor;
            }
        }
        catch (ArithmeticException e)
        {
            System.out.println(e.getMessage());
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
