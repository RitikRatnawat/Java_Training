import java.io.BufferedReader;
import java.io.FileReader;

public class ExceptionWithResources
{
    public static void main(String[] args)
    {
        try(FileReader fileReader = new FileReader("test.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader))
        {
            String line;

            while((line = bufferedReader.readLine()) != null)
            {
                System.out.println(line);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
