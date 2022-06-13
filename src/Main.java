import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args)
    {
        String path = "C:\\Users\\60034452\\Desktop\\";
        String in = path + "picture.jpeg";
        String out = path + "archive.zip";

        try // Обязательно в трай катч т.к. ошибки в пути возможны
        {
            FileOutputStream outputStream = new FileOutputStream(out);// создаем и передаем путь куда сохранять
            ZipOutputStream zipOut = new ZipOutputStream(outputStream);//
            ZipEntry entry = new ZipEntry(new File(in).getName()); // специальная запись архива, которая содержит в себе имя файла
            zipOut.putNextEntry(entry);// кладем в него entry - говорит что начнутся данные вот с таким именем
            //  дальше можем читать строками или байтами(будем читать в байтовом массиве)
            byte[] data = Files.readAllBytes(Paths.get(in)); // читаем в байтах наш файл
            zipOut.write(data); // после пишем в архив
            zipOut.flush(); // после выгружаем из буфера
            zipOut.close(); // после закрываем
            outputStream.close(); // после закрываем
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
