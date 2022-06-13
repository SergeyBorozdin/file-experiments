import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {

    public static void main(String[] args)
    {
        String path = "C:\\Users\\60034452\\Desktop\\output.txt";
        try
        {
            //Files.writeString(Paths.get(path), "запишет этот текст\n", StandardOpenOption.APPEND); //допишет в файл
            Files.writeString(Paths.get(path), "запишет этот текст\n", StandardOpenOption.CREATE); //создаст и запишет
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
