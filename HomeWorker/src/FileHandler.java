import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.io.*;

public class FileHandler {
    public void MakeNewVocabulary(File file) throws Exception {
        FileWriter Fr = new FileWriter(file);
        Fr.close();
    }
    public void WriteColor()throws Exception
    {

    }

    public void SetNewFontSize(String file,String NewLine)throws Exception
    {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String CurrentLine;
        String LineToChange="2,18";

        while((CurrentLine=br.readLine())!=null)
        {
            FileWriter fw = new FileWriter(file,true);

            if(!CurrentLine.equals(LineToChange))
            {
                fw.write("CurrentLine");
            }
        }
    }

    public void DeleteHomeWork(String name,String path) throws Exception
    {
        File file = new File(path+"/"+name);
        file.delete();
    }

    public void Reader(String fille) throws Exception {
        gui guic = new gui();
        File file = new File(fille);

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        while ((st = br.readLine()) != null){
            guic.AddToList(st);
        }
    }


    public void NewHomework(String name) throws Exception
    {
        File file = new File("Files/HomeWorkers/"+name);
        BufferedWriter wr = new BufferedWriter(new FileWriter(file));
    }

    public void WriteFont(String line)throws Exception
    {

    }

    public void Writer(Boolean vocabulary,String lang,String seperateor,String subjekts, String tasks, String dates,String filee) throws Exception
    {
        File file = new File(filee);
        String input = subjekts+seperateor+tasks+seperateor+dates;

        FileWriter fw = new FileWriter(file,true);
        if(vocabulary)
        {fw.write(lang+"\n");
        }
        fw.write(input+"\n");
        fw.close();

    }
}