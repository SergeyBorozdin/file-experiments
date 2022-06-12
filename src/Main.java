import java.io.FileInputStream;

public class Main {

    public static void main(String[] args)
    {
        String path = "C:\\Users\\60034452\\Desktop\\test.txt";
        try
        {
            StringBuilder stringBuilder = new StringBuilder();
            FileInputStream inputStream = new FileInputStream(path);
            while (true)
            {
                int code = inputStream.read();
                if (code < 0){
                    break;
                }
                stringBuilder.append((char) code);
            }
            inputStream.close();
            System.out.println(stringBuilder);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
