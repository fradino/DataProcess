import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.ArrayList;

public class CopyFile {
    public static void main(String[] args) throws Exception{
        try (BufferedReader gr=new BufferedReader(new FileReader("D:\\BaiduNetdiskDownload\\glasses.txt"));
            BufferedReader ngr=new BufferedReader(new FileReader("D:\\BaiduNetdiskDownload\\noglasses.txt"))){
            ArrayList<File> files=getFiles("D:\\BaiduNetdiskDownload\\img_align_celeba\\img_align_celeba");
            String noglass=ngr.readLine();
            String glass=gr.readLine();
            String gdest="D:\\BaiduNetdiskDownload\\glasses\\";
            String ngdest="D:\\BaiduNetdiskDownload\\noglasses\\";
            for (int i=0;i<files.size();i++){
                if (noglass.equals(files.get(i).getName())){
                    FileUtils.copyFile(files.get(i).getAbsoluteFile(),new File(ngdest+files.get(i).getName()));
                    noglass=ngr.readLine();
                    if (noglass==null)
                        break;
                }else if (glass.equals(files.get(i).getName())){
                    FileUtils.copyFile(files.get(i).getAbsoluteFile(),new File(gdest+files.get(i).getName()));
                    glass=gr.readLine();
                }
            }
        }
    }
    public static ArrayList<File> getFiles(String path) {
        ArrayList<File> files = new ArrayList<>();
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
//              System.out.println("文     件：" + tempList[i]);
                files.add(tempList[i]);
            }
            if (tempList[i].isDirectory()) {
//              System.out.println("文件夹：" + tempList[i]);
            }
        }
        return files;
    }
}
