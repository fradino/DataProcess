import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class ReadFile {
    public static void main(String[] args) throws Exception{
        try (BufferedWriter bwg= new BufferedWriter(new FileWriter("D:\\BaiduNetdiskDownload\\glasses.txt",true));
            BufferedWriter bwng= new BufferedWriter(new FileWriter("D:\\BaiduNetdiskDownload\\noglasses.txt",true));
             BufferedReader reader=new BufferedReader(new FileReader("D:\\BaiduNetdiskDownload\\list_attr_celeba.txt"))){
            String line=reader.readLine();
            line=reader.readLine();
            //System.out.println(Arrays.toString(line.split(" ")));
            //System.out.println(line.split(" ").length);
            line=reader.readLine();
            int g=0,ng=0;
            while (line!=null){
                String[] words=line.split(" +");
                //System.out.println(Arrays.toString(words));
                if (words[16].equals("-1")){
                    String newWord=words[0]+"\r\n";
                    bwng.append(newWord);
                    ng++;
                }else {
                    String newWord=words[0]+"\r\n";
                    bwg.append(newWord);
                    g++;
                }
                line=reader.readLine();
            }
            System.out.printf("g  :  %d",g);
            System.out.printf("ng :  %d",ng);
        }
    }
}
