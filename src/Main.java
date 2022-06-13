import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args)
    {
        String path = "C:\\Users\\60034452\\Desktop\\output.txt";
        try
        {
            String data = Files.readString(Paths.get(path));
            System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
