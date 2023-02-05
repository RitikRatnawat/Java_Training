public class ForLoop
{
    public static void main(String[] args)
    {
        int[] arr = {13, 86, 9, 54, 21, 43};

        printPattern(10);
        System.out.println();
        printArray(arr);
        printArray(new int[]{1, 2, 3, 4, 5});
    }

    public static void printPattern(int len)
    {
        for(int i = 0; i < len; i++)
        {
            for (int j = 0; j <= i; j++)
                System.out.print("* ");

            System.out.println();
        }
    }

    public static void printArray(int[] arr)
    {
        System.out.print("[ ");

        for(int i : arr)
            System.out.print(i + ", ");

        System.out.println("]");
    }
}
