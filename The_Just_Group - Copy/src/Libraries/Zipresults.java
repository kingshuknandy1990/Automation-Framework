

package Libraries;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class Zipresults {

    public void zipRes() throws Exception{
        Configuration config = new Configuration();
        String path=config.Zippedfile;
        String res=config.ResultPath;
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        String dt=date.toString().replace(":","_");
        System.out.println(date.toString());
        zipFolder(res,path+"/"+dt+".zip");
    }

    static public void zipFolder(String srcFolder, String destZipFile) throws Exception {
        ZipOutputStream zip = null;
        FileOutputStream fileWriter = null;

        fileWriter = new FileOutputStream(destZipFile);
        zip = new ZipOutputStream(fileWriter);

        addFolderToZip("", srcFolder, zip);
        zip.flush();
        zip.close();
      }

      static private void addFileToZip(String path, String srcFile, ZipOutputStream zip) throws Exception {
      File folder = new File(srcFile);
      if (folder.isDirectory()) {
        addFolderToZip(path, srcFile, zip);
      }
      else {
        byte[] buf = new byte[1024];
          int len;
          FileInputStream in = new FileInputStream(srcFile);
          zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
          while ((len = in.read(buf)) > 0) {
            zip.write(buf, 0, len);
          }
        }
      }

      static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip)
          throws Exception {
        File folder = new File(srcFolder);

        for (String fileName : folder.list()) {
          if (path.equals("")) {
            addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
          } else {
            addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip);
          }
        }
      }
}