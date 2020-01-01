import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class WarningDeleteWindow extends JFrame{
    private JButton canselButton;
    private JButton yesButton;
    private JPanel rootName;
    private JButton noButton1;

    public WarningDeleteWindow(String deleteName)
    {
        add(rootName);
        setSize(300,200);

        noButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] name = deleteName.split(" ");
                File file = new File("Files/Vocabularys/"+name[0]+","+name[1]+","+name[2]);
                file.delete();
            }
        });

    }

}
