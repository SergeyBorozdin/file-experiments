import java.io.FileOutputStream;

public class Main {

    public static void main(String[] args)
    {
        String path = "C:\\Users\\60034452\\Desktop\\output.txt";
        try
        {
            FileOutputStream outputStream = new FileOutputStream(path);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 100; i++)
            {
                stringBuilder.append(i + "\n");
            }
            outputStream.write(stringBuilder.toString().getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
