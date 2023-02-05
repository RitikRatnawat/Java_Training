public class MethodOverloading
{
    public static void main(String[] args)
    {
        Product product = new Product();

        product.getProduct(34, 90);
        product.getProduct(11, 564, 98);
        product.getProduct(new int[]{5, 23, 44, 10, 76, 83});
    }
}

class Product
{
    public void getProduct(int a, int b)
    {
        System.out.println("Product is " + (a * b));
    }

    public void getProduct(int a, int b, int c)
    {
        System.out.println("Product is " + (a * b * c));
    }

    public void getProduct(int[] elements)
    {
        int prod = 1;

        for(int i : elements)
            prod *= i;

        System.out.println("Product is " + prod);
    }
}
