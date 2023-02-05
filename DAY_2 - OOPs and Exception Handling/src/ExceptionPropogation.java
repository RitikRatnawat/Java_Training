public class ExceptionPropogation
{
    public static void main(String[] args)
    {
        try
        {
            doOperation(340, 0);
        }
        catch (ArithmeticException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("Exception Handled");
    }

    public static void doOperation(int dividend, int divisor) throws ArithmeticException
    {
        System.out.println("doOperation() function called");
        divide(dividend, divisor);
    }

    public static void divide(int dividend, int divisor) throws ArithmeticException
    {
        System.out.println("divide() function called");
        int answer = dividend/divisor;
    }
}
