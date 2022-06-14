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
        String in = path + "folder";
        String out = path + "archive.zip";

        try // Обязательно в трай катч т.к. ошибки в пути возможны
        {
            FileOutputStream outputStream = new FileOutputStream(out);// создаем и передаем путь куда сохранять
            ZipOutputStream zipOut = new ZipOutputStream(outputStream);//
            writeFileToZip(new File(in), zipOut, "");
            zipOut.flush();
            zipOut.close();
            outputStream.close();
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public static void writeFileToZip(File file, ZipOutputStream zipOut, String path) throws Exception
    {
        if (file.isDirectory())
        {
            String folder = path + file.getName() + "/";
            ZipEntry entry = new ZipEntry(folder);
            zipOut.putNextEntry(entry);
            zipOut.closeEntry();
            File[] files = file.listFiles();
            for (File subFile : files){
                writeFileToZip(subFile, zipOut, folder);
            }
            return;
        }
        ZipEntry entry = new ZipEntry(path + file.getName());
        zipOut.putNextEntry(entry);
        byte[] bytes = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        zipOut.write(bytes);
    }
}
