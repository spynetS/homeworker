import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class gui extends JFrame {
    Variables v = new Variables();
    String HomeWorksG = v.HomeWorks;
    public DefaultListModel model = new DefaultListModel();
    public DefaultListModel modelLang1 = new DefaultListModel();
    public DefaultListModel modelLang2 = new DefaultListModel();
    public DefaultListModel modelList1Edit = new DefaultListModel();
    public DefaultListModel modelList2Edit = new DefaultListModel();
    public JTabbedPane tabbedPane1;
    public JList list1;
    public JTextField subjekt;
    public JComboBox task;
    public JTextField date;
    public JPanel rootName;
    public JLabel home;
    public JButton subbmitButton;
    public JPanel tab2;
    public JPanel tab1;
    public JButton startButton;
    public JTextField question;
    public JComboBox Vocabulary;
    public JComboBox language;
    public JComboBox inOrder;
    public String fontSize;

    public JTextField answer;
    public JButton correctButton;
    public JPanel panel1;
    public JPanel panel2;
    public JPanel panel3;
    public JPanel panel4;
    public JPanel panel5;
    public JPanel panel6;
    public JPanel panel7;
    public JPanel panel8;
    private JButton deleteButton;
    private JTabbedPane tabbedPane3;
    private JTextField NameOfVocabulary;
    private JButton addVocabularyfile;
    private JList ListLang2;
    private JList ListLang1;
    private JTextField Lang2;
    private JTextField Lang1;
    private JButton addWordsToVocabulary;
    private JPanel newvoc;
    private JLabel sub;
    private JLabel tas;
    private JLabel dat;
    private JLabel nam;
    private JLabel wor;
    private JCheckBox deleteHomeWorkAutomateclyCheckBox;
    private JList list1Edit;
    private JList list2Edit;
    private JButton LoadButton;
    private JComboBox VocabularyEdit;
    private JPanel panelio;
    private JTextField Lang1Og;
    private JTextField Lang1New;
    private JButton changeButton;
    private JComboBox fontSizeChanger;
    private JButton deleteProdButton;
    private JButton deleteLineButton;
    private JTextField NewWord;
    private JButton addWordEdit;
    private JTextField NewWord2;
    private JPanel panele1;
    private JLabel AmountOfCorect;
    private JLabel CorectWordsLabel;
    private JLabel AddNewLineLabel;
    private JLabel ChnageLineLabel;
    public Color colors;
    boolean asd =true;
    int intplus=0;
    String name = "";
    String fontType;
    public String[] data = new String[1];
    Variables vs = new Variables();
    String Settingss = vs.Settings;
    FileHandler fh = new FileHandler();
    public String NameOfVocabularyFile(boolean onlyName) {
        String[] nameSplited = NameOfVocabulary.getText().split(" ");
        if (!onlyName) {
            return ("Files/Vocabularys/" + nameSplited[0] + "," + nameSplited[1] + "," + nameSplited[2]);
        } else {
            return (nameSplited[0] + "," + nameSplited[1] + "," + nameSplited[2]);
        }
    }

    public gui() {
        getRootPane().setDefaultButton(addWordsToVocabulary);
        getRootPane().setDefaultButton(subbmitButton);

        list1Edit.setModel(modelList1Edit);
        list2Edit.setModel(modelList2Edit);
        ListLang1.setModel(modelLang1);
        ListLang2.setModel(modelLang2);
        list1.setModel(model);
        add(rootName);
        setTitle("HomeWorker");
        setSize(960, 540);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        try {
            ReadSettings();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            AddVocabularyProds();
        } catch (Exception e) {
            e.printStackTrace();
        }
        correctButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                try {
                    GetRightAnswer();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        deleteLineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String line = list1Edit.getSelectedValue().toString()+","+list2Edit.getSelectedValue().toString();
                String pathname =  "Files/Vocabularys/"+StringSplitet(" ",VocabularyEdit.getSelectedItem().toString(),0)+","+StringSplitet(" ",VocabularyEdit.getSelectedItem().toString(),1)+","+StringSplitet(" ",VocabularyEdit.getSelectedItem().toString(),2);
                try
                {
                    fh.DeleteHomeWork(line,pathname);
                }
                catch (Exception e)
                {
                    System.out.println("e");
                }
                try {
                    Refresh();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        deleteProdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DeleteVocabularyProdjekt();
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    intplus=0;

                    StartVocabulary(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        fontSizeChanger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try {
                    fh.SetNewFontSize("Files/Settings", fontSizeChanger.getSelectedItem().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        NameOfVocabulary.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                NameOfVocabulary.setEditable(true);
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                NameOfVocabulary.setEditable(true);
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                NameOfVocabulary.setEditable(true);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    fh.DeleteHomeWork(list1.getSelectedValue().toString(),"Files/HomeWorks");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                model.removeElement(list1.getSelectedValue());
            }
        });

        addVocabularyfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                CreateNewFile(NameOfVocabularyFile(false));
                NameOfVocabulary.setEditable(false);
            }
        });
        addWordsToVocabulary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!name.equals(NameOfVocabularyFile(true))) {
                    CreateNewFile(NameOfVocabularyFile(false));
                    name = NameOfVocabularyFile(true);
                }
                NameOfVocabulary.setEditable(false);

                try {
                    String nothing = "";
                    String input = Lang1.getText() + "," + Lang2.getText();

                    FileWriter fw = new FileWriter(NameOfVocabularyFile(false), true);
                    fw.write(input + "\n");
                    fw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                modelLang1.addElement(Lang1.getText());
                modelLang2.addElement(Lang2.getText());
                Lang1.setText("");
                Lang2.setText("");

            }
        });

        subbmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    fh.Writer(false,""," ", subjekt.getText(), task.getSelectedItem().toString(), date.getText(), HomeWorksG);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                model.addElement(subjekt.getText() + " " + task.getSelectedItem().toString() + " " + date.getText());
                if (task.getSelectedItem().toString() == "Vocabulary") {
                    tabbedPane1.setSelectedIndex(1);
                    tabbedPane3.setSelectedIndex(1);
                    NameOfVocabulary.setText(subjekt.getText() + " " + task.getSelectedItem().toString() + " " + date.getText());
                }
            }
        });

        LoadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = VocabularyEdit.getSelectedItem().toString();
                File file = new File("Files/Vocabulary/" + name);

                try {
                    Load();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        list1Edit.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                list2Edit.setSelectedIndex(list1Edit.getSelectedIndex());
                Lang1Og.setText(list1Edit.getSelectedValue().toString());
            }
        });

        list2Edit.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                list1Edit.setSelectedIndex(list2Edit.getSelectedIndex());
                Lang1Og.setText(list2Edit.getSelectedValue().toString());
            }
        });

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                VocabularyEdit.setSelectedItem(list1.getSelectedValue());
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
                    tabbedPane1.setSelectedIndex(1);
                    tabbedPane3.setSelectedIndex(0);
                }
            }
        });
        try {
            AddToList("as");
        } catch (Exception es) {
            es.printStackTrace();
        }
    }

    private void GetRightAnswer() throws Exception {
        String name = Vocabulary.getSelectedItem().toString();
        String name1 = StringSplitet(" ",name,0)+","+StringSplitet(" ",name,1)+","+StringSplitet(" ",name,2);
        File file = new File("Files/Vocabularys/"+name1);
        String line32 = Files.readAllLines(Paths.get("Files/Vocabularys/"+name1)).get(intplus);


        if(answer.getText().equals(StringSplitet(",",line32,1))) {
            try {
                intplus++;
                AmountOfCorect.setText(String.valueOf(intplus));
                StartVocabulary(intplus);
            } catch (Exception e) {
                e.printStackTrace();
            }
            answer.setText("");

        }
    }

    public int LastTab(int lineNumber)throws Exception
    {

        String line = Files.readAllLines(Paths.get("Files/Last")).get(lineNumber);
        int firstTab = Integer.parseInt(line);
        return firstTab;
    }

    public void Refresh()throws Exception
    {
        gui main = new gui();
        main.setVisible(true);
        System.out.println(LastTab(0));
        this.dispose();
    }

    public void StartVocabulary(int lineNumber) throws Exception {
        String name = Vocabulary.getSelectedItem().toString();
        String name1 = StringSplitet(" ",name,0)+","+StringSplitet(" ",name,1)+","+StringSplitet(" ",name,2);
        File file = new File("Files/Vocabularys/"+name1);

        try{
            String line32 = Files.readAllLines(Paths.get("Files/Vocabularys/"+name1)).get(lineNumber);
            question.setText(StringSplitet(",",line32,0));
        }
        catch (Exception e)
        {
            intplus=0;
            question.setText("");
            answer.setText("");

        }
    }

    public String StringSplitet(String seperetor, String string,int index)
    {
        String[] stringSplitet = string.split(seperetor);
        return stringSplitet[index];

    }

    public void DeleteVocabularyProdjekt() {
        String name = VocabularyEdit.getSelectedItem().toString();
        String name1 = StringSplitet(" ",name,0)+","+StringSplitet(" ",name,1)+","+StringSplitet(" ",name,2);
        File file = new File("Files/Vocabularys/"+name1);

        if(file.delete())
        {
            try {
                fh.DeleteHomeWork(name1,"Files/Vocabularys/VocabularysList");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(name1);
        }
        else
        {
            System.out.println("Failed to delete the file");
        }
    }


    public void Load() throws Exception {
        modelList2Edit.removeAllElements();
        modelList1Edit.removeAllElements();
        String RealVocabularyName = StringSplitet(" ",VocabularyEdit.getSelectedItem().toString(),0)+","+StringSplitet(" ",VocabularyEdit.getSelectedItem().toString(),1)+","+StringSplitet(" ",VocabularyEdit.getSelectedItem().toString(),2);
        File file = new File("Files/Vocabularys/" + RealVocabularyName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String currentline;
        while ((currentline = br.readLine()) != null) {
            String[] currentlinesplit = currentline.split(",");
            modelList1Edit.addElement(currentlinesplit[0]);
            modelList2Edit.addElement(currentlinesplit[1]);
        }

    }

    public void AddVocabularyProds() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("Files/Vocabularys/VocabularysList"));
        String CurrentLine;
        while ((CurrentLine = br.readLine()) != null) {
            String[] CurrentLineSplited = CurrentLine.split(",");
            String prod = CurrentLineSplited[0] + " " + CurrentLineSplited[1] + " " + CurrentLineSplited[2];
                VocabularyEdit.addItem(prod);
                Vocabulary.addItem(prod);
        }
    }

    public void CreateNewFile(String CreateNewFileName) {

        try {
            fh.MakeNewVocabulary(new File(CreateNewFileName));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            if (!name.equals(NameOfVocabularyFile(true))) {
                FileWriter fw = new FileWriter("Files/Vocabularys/VocabularysList", true);
                fw.write(NameOfVocabularyFile(true) + "\n");
                fw.close();

                name = NameOfVocabularyFile(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void ReadSettings() throws Exception {
        String[] data = new String[1];
        File file = new File(Settingss);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            String[] stt = st.split(",");
            switch (stt[0]) {
                case "1":
                    SetColor(stt[1]);
                    break;
                case "2":
                    fontSize = stt[1];
                    break;
                case "3":
                    fontType = stt[1];

            }
        }
        int sizeFont = Integer.parseInt(fontSize);
        SetSetting(sizeFont, fontType, colors);
    }

    public void SetColor(String color) {
        switch (color) {
            case "GRAY":
                colors = Color.GRAY;
                break;
            case "WHITE":
                colors = Color.WHITE;
                break;
        }
    }

    public void SetSetting(int fontSize, String font, Color color) {
        home.setFont(new Font(font, Font.PLAIN, 32 + fontSize / 2));
        question.setFont(new Font(font, Font.PLAIN, fontSize));
        answer.setFont(new Font(font, Font.PLAIN, fontSize));
        tabbedPane1.setFont(new Font(font, Font.PLAIN, fontSize));
        sub.setFont(new Font(font, Font.PLAIN, fontSize));
        tas.setFont(new Font(font, Font.PLAIN, fontSize));
        dat.setFont(new Font(font, Font.PLAIN, fontSize));
        subjekt.setFont(new Font(font, Font.PLAIN, fontSize));
        task.setFont(new Font(font, Font.PLAIN, fontSize));
        date.setFont(new Font(font, Font.PLAIN, fontSize));
        list1.setFont(new Font(font, Font.PLAIN, fontSize));
        nam.setFont(new Font(font, Font.PLAIN, fontSize));
        wor.setFont(new Font(font, Font.PLAIN, fontSize));
        NameOfVocabulary.setFont(new Font(font, Font.PLAIN, fontSize));
        ListLang1.setFont(new Font(font, Font.PLAIN, fontSize));
        ListLang2.setFont(new Font(font, Font.PLAIN, fontSize));
        Lang1.setFont(new Font(font, Font.PLAIN, fontSize));
        Lang2.setFont(new Font(font, Font.PLAIN, fontSize));
        tabbedPane3.setFont(new Font(font, Font.PLAIN, fontSize));
        deleteButton.setFont(new Font(font, Font.PLAIN, fontSize));
        subbmitButton.setFont(new Font(font, Font.PLAIN, fontSize));
        addVocabularyfile.setFont(new Font(font, Font.PLAIN, fontSize));
        addWordsToVocabulary.setFont(new Font(font, Font.PLAIN, fontSize));
        Lang1Og.setFont(new Font(font, Font.PLAIN, fontSize));
        Lang1New.setFont(new Font(font, Font.PLAIN, fontSize));
        VocabularyEdit.setFont(new Font(font, Font.PLAIN, fontSize));
        changeButton.setFont(new Font(font, Font.PLAIN, fontSize));
        LoadButton.setFont(new Font(font, Font.PLAIN, fontSize));
        list1Edit.setFont(new Font(font, Font.PLAIN, fontSize));
        list2Edit.setFont(new Font(font, Font.PLAIN, fontSize));
        Vocabulary.setFont(new Font(font, Font.PLAIN, fontSize));
        language.setFont(new Font(font, Font.PLAIN, fontSize));
        inOrder.setFont(new Font(font, Font.PLAIN, fontSize));
        startButton.setFont(new Font(font, Font.PLAIN, fontSize));
        correctButton.setFont(new Font(font, Font.PLAIN, fontSize));
        answer.setFont(new Font(font, Font.PLAIN, fontSize));
        question.setFont(new Font(font, Font.PLAIN, fontSize));
        deleteProdButton.setFont(new Font(font, Font.PLAIN, fontSize));
        deleteLineButton.setFont(new Font(font, Font.PLAIN, fontSize));
        NewWord.setFont(new Font(font, Font.PLAIN, fontSize));
        NewWord2.setFont(new Font(font, Font.PLAIN, fontSize));
        addWordEdit.setFont(new Font(font, Font.PLAIN, fontSize));
        question.setFont(new Font(font, Font.PLAIN, fontSize+3));
        CorectWordsLabel.setFont(new Font(font, Font.PLAIN, fontSize+3));
        AmountOfCorect.setFont(new Font(font, Font.PLAIN, fontSize+3));

        rootName.setBackground(color);
        tab1.setBackground(color);
        tab2.setBackground(color);
        panel1.setBackground(color);
        panel6.setBackground(color);
        panel7.setBackground(color);
        panel8.setBackground(color);
        newvoc.setBackground(color);
        panele1.setBackground(color);
        panelio.setBackground(color);
        setBackground(color);

    }

    public void AddToList(String output) throws Exception {
        File file = new File(HomeWorksG);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        while ((st = br.readLine()) != null) {
            model.addElement(st);
        }
    }

    public void ChangeLine(String file,String lineto)throws Exception
    {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        while ((st = br.readLine()) != null) {
        }
    }

}
