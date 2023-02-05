public class Inheritance {
    public static void main(String[] args)
    {
        Programmer p1 = new Programmer();
        p1.setSalary(70000);
        p1.setBonus(8000);

        p1.getSalary();
        p1.getBonus();
    }
}

class Employee
{
    private float salary;

    public void getSalary()
    {
        System.out.println("Your salary is Rs. " + this.salary);
    }

    public void setSalary(float salary)
    {
        this.salary = salary;
    }
}

class Programmer extends Employee
{
    private float bonus;

    public void getBonus()
    {
        System.out.println("Your salary is Rs. " + this.bonus);
    }

    public void setBonus(float bonus)
    {
        this.bonus = bonus;
    }
}