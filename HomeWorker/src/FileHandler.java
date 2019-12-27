import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
        File inputFile = new File(path);
        File tempFile = new File("myTempFile");
        //System.out.println(name);
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String lineToRemove = name;
        String currentline;

        while((currentline=reader.readLine()) !=null)
        {
            String trimmedLine = currentline.trim();
            if(trimmedLine.equals(lineToRemove)) continue;
            writer.write(currentline + System.getProperty("line.separator"));
        }

        writer.close();
        reader.close();
        boolean successful = tempFile.renameTo(inputFile);


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

