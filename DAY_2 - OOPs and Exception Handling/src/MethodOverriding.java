public class MethodOverriding
{
    public static void main(String[] args)
    {
        ITCompany itCompany = new ITCompany();
        FinTechCompany finTechCompany = new FinTechCompany();
        ECommerce eCommerce = new ECommerce();

        itCompany.getRevenue();
        finTechCompany.getRevenue();
        eCommerce.getRevenue();
    }
}

class Company
{
    public void getRevenue()
    {
        System.out.println("Company Revenue : $30M");
    }
}

class ITCompany extends Company
{
    @Override
    public void getRevenue()
    {
        System.out.println("IT Company Revenue : $200M");
    }
}

class FinTechCompany extends Company
{
    @Override
    public void getRevenue()
    {
        System.out.println("FinTech Company Revenue : $1B");
    }
}

class ECommerce extends Company
{
    @Override
    public void getRevenue()
    {
        System.out.println("ECommerce Company Revenue : $500M");
    }
}
