import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args)
    {
        String path = "C:\\Users\\60034452\\Desktop\\";
        String[] in = {"picture.jpeg", "output.txt", "test.txt"}; // кладем файлы в массив
        String out = path + "archive.zip";

        try // Обязательно в трай катч т.к. ошибки в пути возможны
        {
            FileOutputStream outputStream = new FileOutputStream(out);// создаем и передаем путь куда сохранять
            ZipOutputStream zipOut = new ZipOutputStream(outputStream);//
            for (String fileName : in) // ходим по массиву
            {
                File file = new File(path + fileName); // создем обьект класса File передаем ему путь
                ZipEntry entry = new ZipEntry(file.getName()); // специальная запись архива, которая содержит в себе имя файла
                zipOut.putNextEntry(entry);// кладем в него entry - говорит что начнутся данные вот с таким именем
                //  дальше можем читать строками или байтами(будем читать в байтовом массиве)
                Path filePath = Paths.get(file.getAbsolutePath());
                byte[] data = Files.readAllBytes(filePath); // читаем в байтах наш файл
                zipOut.write(data); // после пишем в архив
            }
            zipOut.flush(); // после выгружаем из буфера
            zipOut.close(); // после закрываем
            outputStream.close(); // после закрываем
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
