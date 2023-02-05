public class Abstraction
{
    public static void main(String[] args)
    {
        Rectangle rectangle = new Rectangle();
        Circle circle = new Circle();

        rectangle.draw();
        circle.draw();
    }
}

abstract class Shape
{
    abstract void draw();
}

class Rectangle extends Shape
{
    @Override
    void draw()
    {
        System.out.println("Drawing Rectangle");
    }
}

class Circle extends Shape
{
    @Override
    void draw()
    {
        System.out.println("Drawing Circle");
    }
}
